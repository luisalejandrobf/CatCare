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
    private String Plazo;


    // Relacion con Paciente
    @ManyToOne
    private Paciente paciente;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


    // Relacion con Drogas
    @ManyToMany
    @JoinTable(name="Tratamiento_Droga", joinColumns = @JoinColumn(name="tratamiento_id"), inverseJoinColumns = @JoinColumn(name="droga_id"))
    private List<Droga> drogas = new ArrayList<>();

    // Relacion con Veterinarios
    @ManyToMany
    @JoinTable(name="Tratamiento_Veterinario", joinColumns = @JoinColumn(name="tratamiento_id"), inverseJoinColumns = @JoinColumn(name="veterinario_id"))
    private List<Veterinario> veterinarios = new ArrayList<>();



    
    public Tratamiento(Date fechaDeInicio, String plazo) {
        this.fechaDeInicio = fechaDeInicio;
        Plazo = plazo;
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
    public String getPlazo() {
        return Plazo;
    }
    public void setPlazo(String plazo) {
        Plazo = plazo;
    }

    


}
