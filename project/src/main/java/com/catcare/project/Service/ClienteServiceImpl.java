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
        // Busca un cliente por su número de cédula utilizando el método personalizado findByCedula de repo.
        Logger log = LoggerFactory.getLogger(getClass());
        log.info(cedula);

        return  repo.findByCedula(cedula);

    }
    

    @Override
    public Collection<Cliente> SearchAll() {
        // Obtiene una colección de todos los clientes almacenados en la base de datos utilizando repo.
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        // Elimina un cliente de la base de datos por su ID utilizando el método de repo.
        repo.deleteById(id);
    }

    @Override
    public void update(Cliente cliente) {
        // Actualiza los datos de un cliente en la base de datos utilizando el método de repo.
        repo.save(cliente);
    }

    @Override
    public void add(Cliente cliente) {
        // Agrega un nuevo cliente a la base de datos utilizando el método de repo.
        repo.save(cliente);
    }

}
