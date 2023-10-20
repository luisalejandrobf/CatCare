package com.catcare.project.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.catcare.project.Entity.Administrador;
import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Paciente;
import com.catcare.project.Entity.Tratamiento;
import com.catcare.project.Entity.Veterinario;

import jakarta.transaction.Transactional;

import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

    @Query("SELECT COUNT(t) FROM Tratamiento t WHERE t.fechaDeInicio >= DATEADD(MONTH, -1, CURRENT_DATE) AND t.fechaDeInicio <= CURRENT_DATE")
    Long countTratamientosLastMonth();

    @Query("SELECT COUNT(DISTINCT t.paciente.id) FROM Tratamiento t WHERE t.paciente.id IS NOT NULL")
    Long countMascotasEnTratamiento();
    
}
