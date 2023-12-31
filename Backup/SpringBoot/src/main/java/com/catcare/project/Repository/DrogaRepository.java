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
}
