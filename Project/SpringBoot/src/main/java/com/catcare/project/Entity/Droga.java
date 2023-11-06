package com.catcare.project.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Droga {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String nombre;
    private float precioVenta;
    private float precioCompra;
    private int unidadesDisponibles;
    private int unidadesVendidas;

    @JsonIgnore // Evitar retornar informacion referenciada
    // Relacion con Tratamiento. Se utiliza borrado en cascada respecto a los Tratamientos.
    @OneToMany(mappedBy = "droga", cascade = CascadeType.REMOVE)
    private List<Tratamiento> tratamientos = new ArrayList<>();

    // Constructor especifico sin ID o relaciones.
    public Droga(String nombre, float precioVenta, float precioCompra, int unidadesDisponibles, int unidadesVendidas) {
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesVendidas = unidadesVendidas;
    }

    // Constructor vacío (implementado con Lombok)

    // Getters y Setters (implementado con Lombok)

}
