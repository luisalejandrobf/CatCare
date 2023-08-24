package com.catcare.project.Service;

import java.util.Collection;

import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Repository.ClienteRepository;
import com.catcare.project.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    // Autowires from mascota repo

    @Autowired
    ClienteRepository clienteRepository;

    // Uses the methods declared in ClienteRepository

    @Override
    public Cliente SearchById(int id) {
       return  clienteRepository.findById(id);
    }

    @Override
    public Collection<Cliente> SearchAll() {
        return clienteRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void update(Cliente cliente) {
        clienteRepository.updateById(cliente);
    }

    @Override
    public void add(Cliente cliente) {
        clienteRepository.add(cliente);
    }

}
