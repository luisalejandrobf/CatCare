package com.catcare.project.Service;

import java.util.Collection;

import com.catcare.project.Entity.Paciente;
import com.catcare.project.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {
    
    // Autowires from mascota repo

    @Autowired
    PacienteRepository repo;

    // Uses the methods declared in PacienteRepository

    @Override
    public Paciente SearchById(Long id) {
       return  repo.findById(id).get();
    }

    @Override
    public Collection<Paciente> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Paciente paciente) {
        repo.save(paciente);
    }

    @Override
    public void add(Paciente paciente) {
        repo.save(paciente);
    }

}
