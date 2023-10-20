package com.catcare.project.repository;


import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.catcare.project.Entity.Paciente;
import com.catcare.project.Repository.PacienteRepository;


@DataJpaTest
@RunWith(SpringRunner.class)
public class PacienteRepositoryTest {
    
    @Autowired
    private PacienteRepository pacienteRepository;

    @BeforeEach
    public void init(){   
        pacienteRepository.save(new Paciente("Lola", "Siames", 2, 7.2, "Dolor de estómago", "Activo","https://www.elespectador.com/resizer/lZcP_cqKxjBwScJGInZnNF6Oghc=/arc-anglerfish-arc2-prod-elespectador/public/SQT6VSTKY5ALBBK4QFI22JCWNY.jpg"));
        pacienteRepository.save(new Paciente("Sam", "Maine Coon", 4, 22.9, "Alergia", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Layla", "Siames", 1, 6.7, "Gripe", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg"));
        pacienteRepository.save(new Paciente("Zeus", "Siames", 5, 11.8, "Fiebre", "Activo","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/220px-Cat_November_2010-1a.jpg"));
    }

    @Test
    public void PacienteRepository_save_Paciente(){

        //1.arrange (preparación)

        Paciente paciente = new Paciente("Greta", "Siames", 3, 7.5, "Gripe", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg");

        //2. act (Acto)

        Paciente savedPaciente = pacienteRepository.save(paciente);

        //3. assert (Verificación)
        Assertions.assertThat(savedPaciente).isNotNull();
    }

    @Test
    public void PacienteRepository_findAll_NotEmptyList(){

        Paciente paciente = new Paciente("Ofelia", "Egipcio", 4, 7.5, "Cancer", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg");
        Paciente paciente2 = new Paciente("Parmenides", "Siames", 8, 7.5, "Tos", "Activo","https://cdn.onemars.net/sites/nutro_es_NkyIN_B9cV/image/20_1615982101979.jpeg");
    
        pacienteRepository.save(paciente);
        pacienteRepository.save(paciente2);
        List<Paciente> pacientes = pacienteRepository.findAll();

        Assertions.assertThat(pacientes).isNotNull();
        Assertions.assertThat(pacientes.size()).isEqualTo(6);
        Assertions.assertThat(pacientes.size()).isGreaterThan(0);
    }

    @Test
    public void PacienteRepository_findById_FindWrongIndex(){

        Long Index = -1l;

        Optional<Paciente> paciente = pacienteRepository.findById(Index);
        
        Assertions.assertThat(paciente).isEmpty();
    }


    @Test
    public void PacienteRepository_deleteById_EmptyStudent(){
        Long index = 2l;
        pacienteRepository.deleteById(index);
        Assertions.assertThat(pacienteRepository.findById(index)).isEmpty();
    }

    @Test
    void PacienteRepository_updateByName_Paciente(){
        Long index = 3l;


    Paciente paciente = pacienteRepository.findById(index).orElse(null);
    Assertions.assertThat(paciente).isNotNull();

    paciente.setNombre("Modificado");
    Paciente updated = pacienteRepository.save(paciente);

    Assertions.assertThat(updated).isNotNull();
    Assertions.assertThat(updated.getNombre()).isEqualTo("Modificado");
    }

    @Test
    public void PacienteRepository_findAllIds_ShouldReturnAllIds() {

        List<Long> ids = pacienteRepository.findAllIds();

        Assertions.assertThat(ids).isNotNull();
        Assertions.assertThat(ids.size()).isEqualTo(4); 
    }

}
