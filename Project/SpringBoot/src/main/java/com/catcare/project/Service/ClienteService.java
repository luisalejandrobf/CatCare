package com.catcare.project.Service;

import java.util.Collection;
import java.util.Optional;

import com.catcare.project.Entity.Cliente;

public interface ClienteService {

  
    // Buscar un cliente por su ID
    public Cliente SearchById(Long id);

    // Obtener todos los clientes
    public Collection<Cliente> SearchAll();

    // Eliminar un cliente por su ID
    public void deleteById(Long id);

    // Buscar un cliente por su número de cédula
    public Cliente SearchByCedula(String cedula);

    // Actualizar los datos de un cliente
    public void update(Cliente cliente);

    public Cliente getByCedula(String cedula);

    // Agregar un nuevo cliente
    public Cliente add(Cliente cliente);

}
