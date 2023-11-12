package com.catcare.project.Service;

import java.util.Collection;

import com.catcare.project.Entity.Administrador;
import com.catcare.project.Entity.Cliente;

public interface AdministradorService {
    
    // Obtener todos los Administradores
    public Collection<Administrador> SearchAll();

    // Buscar un administrador por su ID
    public Administrador SearchById(Long id);

    // Buscar un administrador por su número de cédula
    public Administrador findByCedula(String cedula);

    // Agregar un nuevo administrador
    public Administrador add(Administrador administrador);

    // Eliminar un administrador por su ID
    public void deleteById(Long id);

    // Actualizar los datos de un administrador
    public void update(Administrador administrador);

}
