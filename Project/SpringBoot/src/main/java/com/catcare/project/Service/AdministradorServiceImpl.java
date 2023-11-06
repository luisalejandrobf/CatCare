package com.catcare.project.Service;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catcare.project.Entity.Administrador;
import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Veterinario;
import com.catcare.project.Repository.AdministradorRepository;
import com.catcare.project.Repository.VeterinarioRepository;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    AdministradorRepository repo;

    @Override
    public Collection<Administrador> SearchAll() {
        return repo.findAll();
    }
    
    @Override
    public Administrador SearchById(Long id) {
        // Se tuvo que utilizar optional para que JPA no retorne java.util.NoSuchElementException: No value present.
        // Si es vacio, retorna nulo y el controlador gestiona el error.
       Optional<Administrador> optionalAdministrador = repo.findById(id);
       return optionalAdministrador.orElse(null);
    }

    @Override
     public Administrador findByCedula(String cedula) {
        // Busca un cliente por su número de cédula utilizando el método personalizado findByCedula de repo.
        Logger log = LoggerFactory.getLogger(getClass());
        log.info(cedula);

        return  repo.findByCedula(cedula);
    }

    @Override
    public void add(Administrador administrador) {
        // Agrega un nuevo administrador a la base de datos utilizando el método de repo.
        repo.save(administrador);
    }

    @Override
    public void deleteById(Long id) {
        // Elimina un administrador de la base de datos por su ID utilizando el método de repo.
        repo.deleteById(id);
    }

    @Override
    public void update(Administrador administrador) {
        // Actualiza los datos de un administrador en la base de datos utilizando el método de repo.
        repo.save(administrador);
    }

}
