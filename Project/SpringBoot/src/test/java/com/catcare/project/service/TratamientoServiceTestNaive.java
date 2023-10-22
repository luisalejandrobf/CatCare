package com.catcare.project.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.catcare.project.Entity.Droga;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Entity.Tratamiento;
import com.catcare.project.Entity.Veterinario;
import com.catcare.project.Repository.DrogaRepository;
import com.catcare.project.Repository.PacienteRepository;
import com.catcare.project.Repository.VeterinarioRepository;
import com.catcare.project.Service.TratamientoService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class TratamientoServiceTestNaive {

    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DrogaRepository drogaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    private Paciente pacienteTest;
    private Droga drogaTest;
    private Veterinario veterinarioTest;
    private List<Tratamiento> tratamientosPreCargados = new ArrayList<>();

    @BeforeEach
    public void init() {
        pacienteTest = new Paciente();
        pacienteTest.setNombre("Snowball"); 
        pacienteRepository.save(pacienteTest);
    
        drogaTest = new Droga();
        drogaTest.setNombre("Antibiótico"); 
        drogaRepository.save(drogaTest);
    
        veterinarioTest = new Veterinario();
        veterinarioTest.setNombre("Dr. Smith"); 
        veterinarioRepository.save(veterinarioTest);
    
        Tratamiento tratamiento1 = new Tratamiento();
        tratamiento1.setPaciente(pacienteTest);
        tratamiento1.setDroga(drogaTest);
        tratamiento1.setVeterinario(veterinarioTest);
        tratamiento1.setFechaDeInicio(new Date(System.currentTimeMillis())); 
        tratamientoService.add(tratamiento1);
        tratamientosPreCargados.add(tratamiento1);
    
        Tratamiento tratamiento2 = new Tratamiento();
        tratamiento2.setPaciente(pacienteTest);
        tratamiento2.setDroga(drogaTest);
        tratamiento2.setVeterinario(veterinarioTest);
        tratamiento2.setFechaDeInicio(new Date(System.currentTimeMillis()));
        tratamientoService.add(tratamiento2);
        tratamientosPreCargados.add(tratamiento2);
    }

    @Test
    public void TratamientoService_crearTratamiento_Tratamiento() {
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setPaciente(pacienteTest);
        tratamiento.setDroga(drogaTest);
        tratamiento.setVeterinario(veterinarioTest);
        tratamiento.setFechaDeInicio(new Date(System.currentTimeMillis()));

        Tratamiento tratamientoCreado = tratamientoService.add(tratamiento);
    
        Assertions.assertThat(tratamientoCreado).isNotNull();
        Assertions.assertThat(tratamientoCreado.getPaciente()).isEqualTo(pacienteTest);
        Assertions.assertThat(tratamientoCreado.getDroga()).isEqualTo(drogaTest);
        Assertions.assertThat(tratamientoCreado.getVeterinario()).isEqualTo(veterinarioTest);
    }

    @Test
    public void TratamientoService_eliminarTratamientoPorId_Tratamiento() {
        Long tratamientoId = tratamientosPreCargados.get(0).getId(); 
        tratamientoService.deleteById(tratamientoId);
    
        Tratamiento tratamientoEliminado = tratamientoService.SearchById(tratamientoId);
        Assertions.assertThat(tratamientoEliminado).isNull();
    }

    @Test
    public void TratamientoService_actualizarTratamiento_Tratamiento() {
        Tratamiento tratamiento = tratamientoService.SearchById(tratamientosPreCargados.get(0).getId()); 
        Droga nuevaDroga = new Droga();
        nuevaDroga.setNombre("Nueva Droga");
        drogaRepository.save(nuevaDroga); 
        tratamiento.setDroga(nuevaDroga);
        tratamientoService.update(tratamiento);
    
        Tratamiento tratamientoActualizado = tratamientoService.SearchById(tratamiento.getId());
        Assertions.assertThat(tratamientoActualizado).isNotNull();
        Assertions.assertThat(tratamientoActualizado.getDroga().getNombre()).isEqualTo("Nueva Droga");
    }

    @Test
    public void TratamientoService_contarTratamientosUltimoMes_Cantidad() {
        Long cantidad = tratamientoService.countTratamientosLastMonth();
        Assertions.assertThat(cantidad).isEqualTo(2L); 
    }

    @Test
    public void TratamientoService_contarMascotasEnTratamiento_Cantidad() {
        Long cantidad = tratamientoService.countMascotasEnTratamiento();
        Assertions.assertThat(cantidad).isEqualTo(1L); 
    }

    @Test
    public void TratamientoService_findAll_TratamientoList(){
        Collection<Tratamiento> tratamientos = tratamientoService.SearchAll();

        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos.size()).isEqualTo(2); 
    }
}
