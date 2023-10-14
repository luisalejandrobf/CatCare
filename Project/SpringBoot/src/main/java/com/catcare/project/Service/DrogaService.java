package com.catcare.project.Service;

import java.util.Collection;
import java.util.Optional;

import com.catcare.project.Entity.Droga;

public interface DrogaService {

    // Buscar una droga por su ID
    public Droga SearchById(Long id);

    // Obtener todas las drogas
    public Collection<Droga> SearchAll();

    // Eliminar una droga por su ID
    public void deleteById(Long id);

    // Actualizar los datos de una droga
    public void update(Droga droga);

    // Agregar una nueva droga
    public void add(Droga droga);

}
