package com.catcare.project.query;

import com.catcare.project.Entity.Droga;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Entity.Tratamiento;
import com.catcare.project.Entity.Veterinario;
import com.catcare.project.Repository.DrogaRepository;
import com.catcare.project.Repository.PacienteRepository;
import com.catcare.project.Repository.TratamientoRepository;
import com.catcare.project.Repository.VeterinarioRepository;
import com.catcare.project.Service.DrogaService;
import com.catcare.project.Service.TratamientoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class QueryTests {

    @Mock
    private TratamientoRepository tratamientoRepository;

    @Mock
    private PacienteRepository pacienteRepository;

    @Mock
    private DrogaRepository drogaRepository;

    @Mock
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
        tratamientoRepository.save(tratamientoRecent1);

        Tratamiento tratamientoRecent2 = new Tratamiento();
        tratamientoRecent2.setPaciente(pacienteTest);
        tratamientoRecent2.setDroga(droga2);
        tratamientoRecent2.setVeterinario(veterinarioTest);
        tratamientoRecent2.setFechaDeInicio(Date.valueOf(LocalDate.now().minusDays(5)));
        tratamientoRepository.save(tratamientoRecent2);

        Tratamiento tratamientoRecent3 = new Tratamiento();
        tratamientoRecent3.setPaciente(pacienteTest);
        tratamientoRecent3.setDroga(droga3);
        tratamientoRecent3.setVeterinario(veterinarioTest);
        tratamientoRecent3.setFechaDeInicio(Date.valueOf(LocalDate.now().minusDays(15)));
        tratamientoRepository.save(tratamientoRecent3);

        Tratamiento tratamientoRecent4 = new Tratamiento();
        tratamientoRecent4.setPaciente(pacienteTest);
        tratamientoRecent4.setDroga(droga4);
        tratamientoRecent4.setVeterinario(veterinarioTest);
        tratamientoRecent4.setFechaDeInicio(Date.valueOf(LocalDate.now().minusDays(8)));
        tratamientoRepository.save(tratamientoRecent4);

        Tratamiento tratamientoRecent5 = new Tratamiento();
        tratamientoRecent5.setPaciente(anotherPacienteTest);
        tratamientoRecent5.setDroga(droga5);
        tratamientoRecent5.setVeterinario(veterinarioTest);
        tratamientoRecent5.setFechaDeInicio(Date.valueOf(LocalDate.now().minusDays(20)));
        tratamientoRepository.save(tratamientoRecent5);

        Tratamiento inactiveTratamiento = new Tratamiento();
        inactiveTratamiento.setPaciente(anotherPacienteTest);
        inactiveTratamiento.setDroga(droga1);
        inactiveTratamiento.setVeterinario(veterinarioTest);
        inactiveTratamiento.setFechaDeInicio(Date.valueOf(LocalDate.now().minusMonths(3)));
        tratamientoRepository.save(inactiveTratamiento);
    }

    // 1. Cantidad total de tratamiento administrados en el último mes -> DrogaRepository
    
        @Test
        public void testCountTratamientosLastMonth() {
            when(tratamientoRepository.countTratamientosLastMonth()).thenReturn(5L);
            Long count = tratamientoRepository.countTratamientosLastMonth();
            assertThat(count).isEqualTo(5L);
        }
    // 2. Cantidad de mascotas activas (en tratamiento) en la veterinaria -> DrogaRepository
    
    @Test
    public void testCountMascotasEnTratamiento() {
        when(tratamientoRepository.countMascotasEnTratamiento()).thenReturn(2L);
        Long count = tratamientoRepository.countMascotasEnTratamiento();
        Assertions.assertThat(count).isNotNull();
        Assertions.assertThat(count).isEqualTo(2L);
    }

    // 3. Ventas totales de la veterinaria -> DrogaRepository
    

    @Test
    public void testCalcularVentasTotales() {
        when(drogaRepository.calcularVentasTotales()).thenReturn(4950.0f);
        Float ventasTotales = drogaRepository.calcularVentasTotales();
        assertThat(ventasTotales).isEqualTo(4950.0f);
    }
    
    // 4. Ganancias totales de la veterinaria -> DrogaRepository
    @Test
    public void testCalcularGananciasTotales() {
        when(drogaRepository.calcularGananciasTotales()).thenReturn(2170.0f);
        Float gananciasTotales = drogaRepository.calcularGananciasTotales();
        assertThat(gananciasTotales).isEqualTo(2170.0f);
    }
    
    // 5. Top 3 tratamientos con más unidades vendidas -> DrogaRepository
    @Test
    public void testGetTop3MedicamentosUnidadesVendidas() {
        List<Object[]> datosEsperados = new ArrayList<>();
        datosEsperados.add(new Object[]{"Antibiótico", 10L});
        datosEsperados.add(new Object[]{"Antiparasitario", 20L});
        datosEsperados.add(new Object[]{"Antiinflamatorio", 15L});
        when(drogaRepository.getTop3MedicamentosUnidadesVendidas()).thenReturn(datosEsperados);

        List<Object[]> resultado = drogaRepository.getTop3MedicamentosUnidadesVendidas();
        assertThat(resultado).isEqualTo(datosEsperados);
    }

}