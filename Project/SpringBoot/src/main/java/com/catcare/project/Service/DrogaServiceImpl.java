package com.catcare.project.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.catcare.project.Entity.Droga;
import com.catcare.project.Repository.DrogaRepository;

import org.hibernate.cache.spi.entry.CollectionCacheEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrogaServiceImpl implements DrogaService {

    @Autowired
    DrogaRepository repo;

    @Override
    public Droga SearchById(Long id) {
        // Se tuvo que utilizar optional para que JPA no retorne
        // java.util.NoSuchElementException: No value present.
        // Si es vacio, retorna nulo y el controlador gestiona el error.
        Optional<Droga> optionalDroga = repo.findById(id);
        return optionalDroga.orElse(null);
    }

    @Override
    public Collection<Droga> SearchAll() {
        // Obtiene una colección de todas las drogas almacenados en la base de datos
        // utilizando repo.
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        // Elimina una droga de la base de datos por su ID utilizando el método de repo.
        repo.deleteById(id);
    }

    @Override
    public void update(Droga droga) {
        // Actualiza los datos de una droga en la base de datos utilizando el método de
        // repo.
        repo.save(droga);
    }

    @Override
    public void add(Droga droga) {
        // Agrega una nueva droga a la base de datos utilizando el método de repo.
        repo.save(droga);
    }

    // Cantidad de tratamientos por tipo de medicamento administrado en el último mes (tabla medicamento - cantidad)
    @Override
    public List<Object[]> getDrogaCantidadLastMonth(){
        return repo.getDrogaCantidadLastMonth();
    }

    // Ventas totales de la veterinaria
    @Override
    public Float calcularVentasTotales(){
        return repo.calcularVentasTotales();
    }

    // Ganancias totales de la veterinaria
    @Override
    public Float calcularGananciasTotales(){
        return repo.calcularGananciasTotales();
    }

    // Top 3 tratamientos con más unidades vendidas
    @Override
    public List<Object[]> getTop3MedicamentosUnidadesVendidas(){
        return repo.getTop3MedicamentosUnidadesVendidas();
    }

}
