package com.catcare.project.Service;

import java.util.Collection;
import java.util.Optional;

import com.catcare.project.Entity.Cliente;

public interface ClienteService {
    
    public Cliente SearchById(Long id);

    public Collection<Cliente> SearchAll();

    public void deleteById(Long id);

    public Cliente SearchByCedula(String cedula);

    public void update(Cliente cliente);

    public void add(Cliente cliente);
    
}
