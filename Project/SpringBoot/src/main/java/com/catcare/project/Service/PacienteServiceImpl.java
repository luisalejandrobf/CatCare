package com.catcare.project.Service;

import java.util.Collection;
import java.util.Optional;

import com.catcare.project.Entity.Paciente;
import com.catcare.project.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    PacienteRepository repo;

    // Uses the methods declared in PacienteRepository

    @Override
    public Paciente SearchById(Long id) {
        // Se tuvo que utilizar optional para que JPA no retorne java.util.NoSuchElementException: No value present.
        // Si es vacio, retorna nulo y el controlador gestiona el error.
       Optional<Paciente> optionalPaciente = repo.findById(id);
       return optionalPaciente.orElse(null);
    }

    @Override
    public Collection<Paciente> SearchAll() {
        // Obtiene una colección de todos los pacientes.
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        // Elimina un paciente por su ID.
        repo.deleteById(id);
    }

    @Override
    public void update(Paciente paciente) {
        // Actualiza la información de un paciente en el repositorio.
        repo.save(paciente);
    }

    @Override
    public void add(Paciente paciente) {
        // Agrega un nuevo paciente al repositorio.
        repo.save(paciente);
    }

}
