package com.catcare.project.Service;

import java.util.Collection;

import com.catcare.project.Entity.Administrador;

public interface AdministradorService {
    
    // Obtener todos los Administradores
    public Collection<Administrador> SearchAll();

    // Buscar un administrador por su ID
    public Administrador SearchById(Long id);

    // Agregar un nuevo administrador
    public void add(Administrador administrador);

    // Eliminar un administrador por su ID
    public void deleteById(Long id);

    // Actualizar los datos de un administrador
    public void update(Administrador administrador);

}
