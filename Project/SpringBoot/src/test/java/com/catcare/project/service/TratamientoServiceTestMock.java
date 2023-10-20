package com.catcare.project.service;

import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.catcare.project.Entity.Droga;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Entity.Tratamiento;
import com.catcare.project.Entity.Veterinario;
import com.catcare.project.Repository.TratamientoRepository;
import com.catcare.project.Service.TratamientoServiceImpl;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class TratamientoServiceTestMock {

    @Mock
    private TratamientoRepository tratamientoRepository;

    @InjectMocks
    private TratamientoServiceImpl tratamientoService;

    private Tratamiento tratamiento;

    @BeforeEach
    public void init() {
        Paciente paciente = new Paciente();
        paciente.setNombre("Snowball");

        Droga droga = new Droga();
        droga.setNombre("Antibiótico");

        Veterinario veterinario = new Veterinario();
        veterinario.setNombre("Dr. Smith");

        tratamiento = new Tratamiento();
        tratamiento.setPaciente(paciente);
        tratamiento.setDroga(droga);
        tratamiento.setVeterinario(veterinario);

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        tratamiento.setFechaDeInicio(sqlDate);
    }

    @Test
    public void TratamientoService_createTratamiento_Tratamiento() {
        when(tratamientoRepository.save(any(Tratamiento.class))).thenReturn(tratamiento);

        Tratamiento newTratamiento = tratamientoService.add(tratamiento);

        Assertions.assertThat(newTratamiento).isNotNull();
        Assertions.assertThat(newTratamiento.getPaciente().getNombre()).isEqualTo("Snowball");
        Assertions.assertThat(newTratamiento.getDroga().getNombre()).isEqualTo("Antibiótico");
        Assertions.assertThat(newTratamiento.getVeterinario().getNombre()).isEqualTo("Dr. Smith");
    }

    @Test
    public void TratamientoService_findAll_TratamientoList() {
        when(tratamientoRepository.findAll()).thenReturn(List.of(tratamiento, tratamiento));

        Collection<Tratamiento> tratamientos = tratamientoService.SearchAll();

        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos.size()).isEqualTo(2);
    }

    @Test
    public void TratamientoService_findById_Tratamiento() {
        Long tratamientoId = 1L;
        when(tratamientoRepository.findById(tratamientoId)).thenReturn(Optional.of(tratamiento));

        Tratamiento foundTratamiento = tratamientoService.SearchById(tratamientoId);

        Assertions.assertThat(foundTratamiento).isNotNull();
        Assertions.assertThat(foundTratamiento.getPaciente().getNombre()).isEqualTo("Snowball");
    }

    @Test
    public void TratamientoService_updateTratamiento_Tratamiento() {
        when(tratamientoRepository.save(any(Tratamiento.class))).thenReturn(tratamiento);

        tratamiento.getPaciente().setNombre("Updated Name");
        tratamientoService.update(tratamiento);

        verify(tratamientoRepository).save(tratamiento);
        Assertions.assertThat(tratamiento.getPaciente().getNombre()).isEqualTo("Updated Name");
    }

    @Test
    public void TratamientoService_deleteTratamientoById() {
        Long tratamientoId = 2L;

        tratamientoService.deleteById(tratamientoId);

        verify(tratamientoRepository).deleteById(tratamientoId);
    }
}
