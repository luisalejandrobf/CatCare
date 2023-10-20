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
    public void TratamientoService_createTratamiento_Tratamiento(){
 
        Tratamiento tratamiento = new Tratamiento();

        tratamientoService.add(tratamiento);
        
        Tratamiento newTratamiento = tratamientoService.SearchById(tratamiento.getId()); 

        Assertions.assertThat(newTratamiento).isNotNull();
    }

    @Test
    public void TratamientoService_findAll_TratamientoList(){
        Collection<Tratamiento> tratamientos = tratamientoService.SearchAll();

        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos.size()).isEqualTo(2);
    }
}
