package com.catcare.project.Service;

import java.util.Collection;

import com.catcare.project.Entity.Paciente;

public interface PacienteService {
    
    public Paciente SearchById(int id);

    public Collection<Paciente> SearchAll();

    public void deleteById(int id);

    public void update(Paciente paciente);

    public void add(Paciente paciente);
    
}
