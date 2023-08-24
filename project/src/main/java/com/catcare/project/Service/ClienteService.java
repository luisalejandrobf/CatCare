package com.catcare.project.Service;

import java.util.Collection;

import com.catcare.project.Entity.Cliente;

public interface ClienteService {
    
    public Cliente SearchById(int id);

    public Collection<Cliente> SearchAll();

    public void deleteById(int id);

    public void update(Cliente cliente);

    public void add(Cliente cliente);
    
}
