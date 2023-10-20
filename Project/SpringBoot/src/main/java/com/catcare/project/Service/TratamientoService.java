package com.catcare.project.Service;

import java.util.Collection;

import com.catcare.project.Entity.Tratamiento;

public interface TratamientoService {
    
    // Obtener todos los tratamientos
    public Collection<Tratamiento> SearchAll();

    // Buscar un tratamiento por su ID
    public Tratamiento SearchById(Long id);

    // Agregar un nuevo veterinario
    public Tratamiento add(Tratamiento tratamiento);

     // Eliminar un tratamiento por su ID
     public void deleteById(Long id);

    // Actualizar los datos de un tratamiento
    public void update(Tratamiento tratamiento);

    // Devuelve la cantidad de tratamientos administrados en el último mes
    public Long countTratamientosLastMonth();

    // Devuelve la cantidad de mascotas Activas
    public Long countMascotasEnTratamiento();


}
