package com.catcare.project.Service;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catcare.project.Entity.Tratamiento;
import com.catcare.project.Repository.TratamientoRepository;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    TratamientoRepository repo;

    @Override
    public Collection<Tratamiento> SearchAll() {
        return repo.findAll();
    }

    @Override
    public Tratamiento SearchById(Long id) {
        // Se tuvo que utilizar optional para que JPA no retorne
        // java.util.NoSuchElementException: No value present.
        // Si es vacio, retorna nulo y el controlador gestiona el error.
        Optional<Tratamiento> optionalTratamiento = repo.findById(id);
        return optionalTratamiento.orElse(null);
    }

    @Override
    public Tratamiento add(Tratamiento tratamiento) {
        // Agrega un nuevo tratamiento a la base de datos utilizando el método de repo.
        return repo.save(tratamiento);
    }

    @Override
    public void deleteById(Long id) {
        // Elimina un tratamiento de la base de datos por su ID utilizando el método de
        // repo.
        repo.deleteById(id);
    }

    @Override
    public void update(Tratamiento tratamiento) {
        // Actualiza los datos de un tratamiento en la base de datos utilizando el
        // método de repo.
        repo.save(tratamiento);
    }

    // Devuelve la cantidad de tratamientos administrados en el último mes
    @Override
    public Long countTratamientosLastMonth() {
        return repo.countTratamientosLastMonth();
    }

}
