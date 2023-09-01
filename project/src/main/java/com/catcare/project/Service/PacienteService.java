package com.catcare.project.Service;

import java.util.Collection;

import com.catcare.project.Entity.Paciente;

public interface PacienteService {
    
    public Paciente SearchById(Long id);

    public Collection<Paciente> SearchAll();

    public void deleteById(Long id);

    public void update(Paciente paciente);

    public void add(Paciente paciente);
    
}
