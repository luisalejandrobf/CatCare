package com.catcare.project.Service;

import java.util.Collection;

import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Repository.ClienteRepository;
import com.catcare.project.Repository.PacienteRepository;

import org.hibernate.cache.spi.entry.CollectionCacheEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    ClienteRepository repo;

    // Uses the methods declared in ClienteRepository

    @Override
    public Cliente SearchById(Long id) {
       return  repo.findById(id).get();
    }


    @Override
     public Cliente SearchByCedula(String cedula) {
        
        Logger log = LoggerFactory.getLogger(getClass());

        log.info(cedula);

        return  repo.findByCedula(cedula);

    }
    

    @Override
    public Collection<Cliente> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Cliente cliente) {
        repo.save(cliente);
    }

    @Override
    public void add(Cliente cliente) {
        repo.save(cliente);
    }

}
