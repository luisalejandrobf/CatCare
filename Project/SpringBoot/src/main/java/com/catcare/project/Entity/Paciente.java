package com.catcare.project.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Paciente {

    @Id
    @GeneratedValue
    private Long id; 

    private String nombre;
    private String raza;
    private int edad;
    private double peso;
    private String enfermedad;
    private String estado;
    private String foto;


    // @JsonIgnore // Evitar retornar informacion referenciada. Se quiere mostrar la info del cliente relacionado, por eso no se pone.
    // Relacion con Cliente
    @ManyToOne
    private Cliente cliente;

    @JsonIgnore // Evitar retornar informacion referenciada
    // Relacion con Tratamiento. Se utiliza borrado en cascada respecto a los Tratamientos.
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.REMOVE)
    private List<Tratamiento> tratamientos = new ArrayList<>();

    // Constructor especifico sin ID o relaciones.
    public Paciente(String nombre, String raza, int edad, double peso, String enfermedad, String estado,
            String foto) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.enfermedad = enfermedad;
        this.estado = estado;
        this.foto = foto;
    }

    // Constructor vacío (implementado con Lombok)

    // Getters y Setters (implementado con Lombok)


}
