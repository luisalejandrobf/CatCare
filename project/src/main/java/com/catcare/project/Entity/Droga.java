package com.catcare.project.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Droga {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String nombre;
    private float precio;


    // Relacion con Tratamiento. Se utiliza borrado en cascada respecto a los Tratamientos.
    @OneToMany(mappedBy = "droga", cascade = CascadeType.REMOVE)
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }


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
