package com.catcare.project.Service;

import java.util.Collection;

import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Veterinario;

public interface VeterinarioService {
    
    // Obtener todos los veterinarios
    public Collection<Veterinario> SearchAll();

    // Buscar un veterinario por su ID
    public Veterinario SearchById(Long id);

    // Agregar un nuevo veterinario
    public void add(Veterinario veterinario);

     // Eliminar un veterinario por su ID
     public void deleteById(Long id);

    // Actualizar los datos de un veterinario
    public void update(Veterinario veterinario);

}
