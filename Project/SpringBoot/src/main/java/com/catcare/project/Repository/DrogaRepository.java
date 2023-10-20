package com.catcare.project.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.catcare.project.Entity.Administrador;
import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Droga;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Entity.Tratamiento;
import com.catcare.project.Entity.Veterinario;

import jakarta.transaction.Transactional;

import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DrogaRepository extends JpaRepository<Droga, Long> {

    @Query("SELECT d.id FROM Droga d")
    List<Long> findAllIds();

    @Query("SELECT t.droga.nombre, COUNT(t) FROM Tratamiento t WHERE t.fechaDeInicio >= DATEADD(MONTH, -1, CURRENT_DATE) AND t.fechaDeInicio <= CURRENT_DATE GROUP BY t.droga.nombre")
    List<Object[]> getDrogaCantidadLastMonth();

    @Query("SELECT SUM(d.unidadesVendidas * d.precioVenta) FROM Droga d")
    Float calcularVentasTotales();

    @Query("SELECT SUM((d.precioVenta - d.precioCompra) * d.unidadesVendidas) FROM Droga d")
    Float calcularGananciasTotales();

    @Query(value = "SELECT d.nombre, COUNT(t.droga) as cantidad " +
                   "FROM Tratamiento t JOIN t.droga d " +
                   "GROUP BY d.nombre " +
                   "ORDER BY cantidad DESC " +
                   "LIMIT 3")
    List<Object[]> getTop3MedicamentosUnidadesVendidas();

}
