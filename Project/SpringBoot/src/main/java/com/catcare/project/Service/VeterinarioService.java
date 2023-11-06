package com.catcare.project.Service;

import java.util.Collection;

import com.catcare.project.Entity.Administrador;
import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Veterinario;

public interface VeterinarioService {

    // Obtener todos los veterinarios
    public Collection<Veterinario> SearchAll();

    // Buscar un veterinario por su ID
    public Veterinario SearchById(Long id);

    // Buscar un veterinario por su número de cédula
    public Veterinario findByCedula(String cedula);

    // Agregar un nuevo veterinario
    public void add(Veterinario veterinario);

    // Eliminar un veterinario por su ID
    public void deleteById(Long id);

    // Actualizar los datos de un veterinario
    public void update(Veterinario veterinario);

    // Devuelve la cantidad de veterinarios activos
    public Long countVeterinariosActivos();

    // Devuelve la cantidad de veterinarios activos
    public Long countVeterinariosInactivos();

}
