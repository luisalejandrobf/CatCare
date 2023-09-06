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

@Entity
public class Droga {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String nombre;
    private float precio;


    // Relacion con Tratamientos
    @ManyToMany
    @JoinTable(name="Tratamiento_Droga", joinColumns = @JoinColumn(name="droga_id"), inverseJoinColumns = @JoinColumn(name="tratamiento_id"))
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public Droga(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Droga() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    

}
