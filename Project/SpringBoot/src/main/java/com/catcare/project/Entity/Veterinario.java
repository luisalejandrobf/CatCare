package com.catcare.project.Entity;

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
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veterinario {

    @Id
    @GeneratedValue
    private Long id;
    private String cedula;
    private String nombre;
    //@Transient // No se muestra en H2
    private String contrasena;
    private String especialidad;
    private String foto;
    private String estado;

    @JsonIgnore // Evitar retornar informacion referenciada
    // Relacion con Tratamiento. Se utiliza borrado en cascada respecto a los
    // Tratamientos.
    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.REMOVE)
    private List<Tratamiento> tratamientos = new ArrayList<>();

    // Constructor especifico sin ID o relaciones.
    public Veterinario(String cedula, String nombre, String contrasena, String especialidad, String foto, String estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.foto = foto;
        this.estado = estado;
    }

    // Constructor vacío (implementado con Lombok)

    // Getters y Setters (implementado con Lombok)

}
