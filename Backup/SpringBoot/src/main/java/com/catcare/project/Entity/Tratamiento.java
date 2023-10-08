package com.catcare.project.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Tratamiento {


    @Id
    @GeneratedValue
    private Long id;
    
    private Date fechaDeInicio;


    // Relacion con Paciente
    @ManyToOne
    private Paciente paciente;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


    // Relacion con Droga
    @ManyToOne
    private Droga droga;

    public Droga getDroga() {
        return droga;
    }

    public void setDroga(Droga droga) {
        this.droga = droga;
    }


    // Relacion con Veterinario
    @ManyToOne
    private Veterinario veterinario;

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }



    public Tratamiento() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }
    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

}
