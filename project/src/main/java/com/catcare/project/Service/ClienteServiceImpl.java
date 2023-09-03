package com.catcare.project.Service;

import java.util.Collection;
import java.util.Optional;

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
        // Se tuvo que utilizar optional para que JPA no retorne java.util.NoSuchElementException: No value present.
        // Si es vacio, retorna nulo y el controlador gestiona el error.
       Optional<Cliente> optionalCliente = repo.findById(id);
       return optionalCliente.orElse(null);
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
