package com.catcare.project;

import com.catcare.project.Entity.Droga;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Entity.Tratamiento;
import com.catcare.project.Entity.Veterinario;
import com.catcare.project.Repository.DrogaRepository;
import com.catcare.project.Repository.PacienteRepository;
import com.catcare.project.Repository.VeterinarioRepository;
import com.catcare.project.Service.DrogaService;
import com.catcare.project.Service.TratamientoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class QueryTests {

    @Autowired
    private TratamientoService tratamientoService;
    
    @Autowired
    private DrogaService drogaService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DrogaRepository drogaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @BeforeEach
    public void init() {

        Paciente pacienteTest = new Paciente();
        pacienteTest.setNombre("Snowball");
        pacienteRepository.save(pacienteTest);

        Veterinario veterinarioTest = new Veterinario();
        veterinarioTest.setNombre("Dr. Smith");
        veterinarioRepository.save(veterinarioTest);

        Paciente anotherPacienteTest = new Paciente();
        anotherPacienteTest.setNombre("Fido");
        pacienteRepository.save(anotherPacienteTest);

        Droga droga1 = new Droga("Antibiótico", 150.0f, 100.0f, 50, 10); 
        drogaRepository.save(droga1);

        Droga droga2 = new Droga("Antiparasitario", 80.0f, 40.0f, 100, 20);
        drogaRepository.save(droga2);

        Tratamiento tratamientoRecent = new Tratamiento();
        tratamientoRecent.setPaciente(pacienteTest);
        tratamientoRecent.setDroga(droga1);
        tratamientoRecent.setVeterinario(veterinarioTest);
        tratamientoRecent.setFechaDeInicio(Date.valueOf(LocalDate.now().minusDays(10))); 
        tratamientoService.add(tratamientoRecent);

        Tratamiento inactiveTratamiento = new Tratamiento();
        inactiveTratamiento.setPaciente(anotherPacienteTest);
        inactiveTratamiento.setDroga(droga1);
        inactiveTratamiento.setVeterinario(veterinarioTest);
        inactiveTratamiento.setFechaDeInicio(Date.valueOf(LocalDate.now().minusMonths(3))); 
        tratamientoService.add(inactiveTratamiento);
    }

    // 1. Cantidad total de tratamiento administrados en el último mes -> TratamientoService
    @Test
    public void countTratamientosLastMonth_ShouldReturnNumberOfTreatmentsInLastMonth() {
  
        Long count = tratamientoService.countTratamientosLastMonth();

        Assertions.assertThat(count).isEqualTo(1);
    }

    //2. Cantidad de mascotas activas (en tratamiento) en la veterinaria -> TratamientoService
    @Test
    public void countMascotasEnTratamiento_ShouldReturnNumberOfActivePets() {

        Long count = tratamientoService.countMascotasEnTratamiento();

        Assertions.assertThat(count).isEqualTo(2); 
    }

    //3. Ventas totales de la veterinaria -> DrogaService
    @Test
    public void ventasTotales_ShouldReturnTotalSales() {
        Float ventas = drogaService.calcularVentasTotales(); 

        Float expectedVentas = 150.0f * 10 + 80.0f * 20; 
        Assertions.assertThat(ventas).isEqualTo(expectedVentas);
    }

    //4. Ganancias totales de la veterinaria -> DrogaService
    @Test
    public void gananciasTotales_ShouldReturnTotalEarnings() {
        Float ganancias = drogaService.calcularGananciasTotales(); 
        Float expectedGanancias = (150.0f - 100.0f) * 10 + (80.0f - 40.0f) * 20; 
        Assertions.assertThat(ganancias).isEqualTo(expectedGanancias);
    }

    //5. Top 3 tratamientos con más unidades vendidas -> DrogaService
    @Test
    public void top3MedicamentosUnidadesVendidas_ShouldReturnTop3Tratamientos() {
       
        List<Object[]> topResults = drogaService.getTop3MedicamentosUnidadesVendidas();
    
        // Correcting the method name to 'isLessThanOrEqualTo'
        Assertions.assertThat(topResults.size()).isLessThanOrEqualTo(3);
    
        List<String> drugNames = topResults.stream().map(result -> (String) result[0]).collect(Collectors.toList());
        List<String> expectedDrugNames = List.of("Antibiótico", "Antiparasitario");
        
        Assertions.assertThat(drugNames).allMatch(expectedDrugNames::contains);
    }
    
}
