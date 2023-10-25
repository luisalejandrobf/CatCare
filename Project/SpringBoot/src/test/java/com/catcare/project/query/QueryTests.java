package com.catcare.project.query;

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

        Droga droga3 = new Droga("Antiinflamatorio", 60.0f, 30.0f, 80, 15);
        drogaRepository.save(droga3);

        Droga droga4 = new Droga("Vitaminas", 30.0f, 10.0f, 50, 5);
        drogaRepository.save(droga4);

        Droga droga5 = new Droga("Antiinfeccioso", 100.0f, 60.0f, 40, 8);
        drogaRepository.save(droga5);

        Tratamiento tratamientoRecent1 = new Tratamiento();
        tratamientoRecent1.setPaciente(pacienteTest);
        tratamientoRecent1.setDroga(droga1);
        tratamientoRecent1.setVeterinario(veterinarioTest);
        tratamientoRecent1.setFechaDeInicio(Date.valueOf(LocalDate.now().minusDays(10)));
        tratamientoService.add(tratamientoRecent1);

        Tratamiento tratamientoRecent2 = new Tratamiento();
        tratamientoRecent2.setPaciente(pacienteTest);
        tratamientoRecent2.setDroga(droga2);
        tratamientoRecent2.setVeterinario(veterinarioTest);
        tratamientoRecent2.setFechaDeInicio(Date.valueOf(LocalDate.now().minusDays(5)));
        tratamientoService.add(tratamientoRecent2);

        Tratamiento tratamientoRecent3 = new Tratamiento();
        tratamientoRecent3.setPaciente(pacienteTest);
        tratamientoRecent3.setDroga(droga3);
        tratamientoRecent3.setVeterinario(veterinarioTest);
        tratamientoRecent3.setFechaDeInicio(Date.valueOf(LocalDate.now().minusDays(15)));
        tratamientoService.add(tratamientoRecent3);

        Tratamiento tratamientoRecent4 = new Tratamiento();
        tratamientoRecent4.setPaciente(pacienteTest);
        tratamientoRecent4.setDroga(droga4);
        tratamientoRecent4.setVeterinario(veterinarioTest);
        tratamientoRecent4.setFechaDeInicio(Date.valueOf(LocalDate.now().minusDays(8)));
        tratamientoService.add(tratamientoRecent4);

        Tratamiento tratamientoRecent5 = new Tratamiento();
        tratamientoRecent5.setPaciente(anotherPacienteTest);
        tratamientoRecent5.setDroga(droga5);
        tratamientoRecent5.setVeterinario(veterinarioTest);
        tratamientoRecent5.setFechaDeInicio(Date.valueOf(LocalDate.now().minusDays(20)));
        tratamientoService.add(tratamientoRecent5);

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
        Assertions.assertThat(count).isEqualTo(5);
    }

    // 2. Cantidad de mascotas activas (en tratamiento) en la veterinaria -> TratamientoService
    @Test
    public void countMascotasEnTratamiento_ShouldReturnNumberOfActivePets() {
        Long count = tratamientoService.countMascotasEnTratamiento();
        Assertions.assertThat(count).isEqualTo(2);
    }

    // 3. Ventas totales de la veterinaria -> DrogaService
    @Test
    public void ventasTotales_ShouldReturnTotalSales() {
        Float ventas = drogaService.calcularVentasTotales();
        Float expectedVentas = 150.0f * 10 + 80.0f * 20 + 60.0f * 15 + 30.0f * 5 + 100.0f * 8;
        Assertions.assertThat(ventas).isEqualTo(expectedVentas);
    }

    // 4. Ganancias totales de la veterinaria -> DrogaService
    @Test
    public void gananciasTotales_ShouldReturnTotalEarnings() {
        Float ganancias = drogaService.calcularGananciasTotales();
        Float expectedGanancias = (150.0f - 100.0f) * 10 + (80.0f - 40.0f) * 20 + (60.0f - 30.0f) * 15 + (30.0f - 10.0f) * 5 + (100.0f - 60.0f) * 8;
        Assertions.assertThat(ganancias).isEqualTo(expectedGanancias);
    }

    // 5. Top 3 tratamientos con más unidades vendidas -> DrogaService
    @Test
    public void top3MedicamentosUnidadesVendidas_ShouldReturnTop3TratamientosWithAdditionalData() {
        List<Object[]> topResults = drogaService.getTop3MedicamentosUnidadesVendidas();

        Assertions.assertThat(topResults.size()).isLessThanOrEqualTo(3);
        List<String> drugNames = topResults.stream().map(result -> (String) result[0]).collect(Collectors.toList());
        List<String> expectedDrugNames = List.of("Antibiótico", "Antiparasitario", "Antiinflamatorio", "Vitaminas", "Antiinfeccioso");
        Assertions.assertThat(drugNames).allMatch(expectedDrugNames::contains);
    }
}
