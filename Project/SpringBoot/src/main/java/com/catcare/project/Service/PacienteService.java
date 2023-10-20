package com.catcare.project.Service;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import com.catcare.project.Entity.Paciente;

public interface PacienteService {

    // Busca un paciente por su ID.
    public Paciente SearchById(Long id);

    // Obtiene una colección de todos los pacientes.
    public Collection<Paciente> SearchAll();

    // Elimina un paciente por su ID.
    public void deleteById(Long id);

    // Actualiza la información de un paciente.
    public void update(Paciente paciente);

    // Agrega un nuevo paciente.
    public void add(Paciente paciente);
    
    // Devuelve la cantidad total de mascotas de la veterinaria
    public Long countTotalMascotas();
    
}
