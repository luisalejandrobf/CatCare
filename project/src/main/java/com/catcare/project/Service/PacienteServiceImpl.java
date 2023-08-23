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
    PacienteRepository pacienteRepository;

    // Uses the methods declared in PacienteRepository

    @Override
    public Paciente SearchById(int id) {
       return  pacienteRepository.findById(id);
    }

    @Override
    public Collection<Paciente> SearchAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public void update(Paciente paciente) {
        pacienteRepository.updateById(paciente);
    }

    @Override
    public void add(Paciente paciente) {
        pacienteRepository.add(paciente);
    }

}
