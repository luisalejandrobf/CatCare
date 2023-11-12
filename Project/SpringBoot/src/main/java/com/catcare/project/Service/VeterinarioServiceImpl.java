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
import com.catcare.project.Repository.VeterinarioRepository;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    @Autowired
    VeterinarioRepository repo;

    @Override
    public Collection<Veterinario> SearchAll() {
        return repo.findAll();
    }

    @Override
    public Veterinario SearchById(Long id) {
        // Se tuvo que utilizar optional para que JPA no retorne
        // java.util.NoSuchElementException: No value present.
        // Si es vacio, retorna nulo y el controlador gestiona el error.
        Optional<Veterinario> optionalVeterinario = repo.findById(id);
        return optionalVeterinario.orElse(null);
    }

    @Override
     public Veterinario findByCedula(String cedula) {
        // Busca un cliente por su número de cédula utilizando el método personalizado findByCedula de repo.
        Logger log = LoggerFactory.getLogger(getClass());
        log.info(cedula);

        return  repo.findByCedula(cedula);
    }

    @Override
    public Veterinario add(Veterinario veterinario) {
        // Agrega un nuevo veterinario a la base de datos utilizando el método de repo.
       return  repo.save(veterinario);
    }

    @Override
    public void deleteById(Long id) {
        // Elimina un veterinario de la base de datos por su ID utilizando el método de
        // repo.
        repo.deleteById(id);
    }

    @Override
    public void update(Veterinario veterinario) {
        // Actualiza los datos de un veterinario en la base de datos utilizando el
        // método de repo.
        repo.save(veterinario);
    }

    // Devuelve la cantidad de veterinarios activos
    @Override
    public Long countVeterinariosActivos() {
        return repo.countVeterinariosActivos();
    }

    // Devuelve la cantidad de veterinarios inactivos
    @Override
    public Long countVeterinariosInactivos() {
        return repo.countVeterinariosInactivos();
    }

}
