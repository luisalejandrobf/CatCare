package com.catcare.project.Entity;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Cliente {

    @Id
    @GeneratedValue
    private Long id; // Identificador único del cliente
    private String cedula; // Número de cédula del cliente
    private String nombre; // Nombre del cliente
    private String correo; // Correo electrónico del cliente
    private String celular; // Número de celular del cliente
    private String foto; // Ruta o enlace a la foto del cliente


    @JsonIgnore // Evitar retornar informacion referenciada
    // Relación con Paciente. Se utiliza borrado en cascada respecto a los pacientes.
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
    private List<Paciente> pacientes = new ArrayList<>();

    // Constructor especifico sin ID o relaciones.
    // Constructor que recibe los datos del cliente
    public Cliente(String cedula, String nombre, String correo, String celular, String foto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.foto = foto;
    }

    // Constructor vacío (implementado con Lombok)

    // Getters y Setters (implementado con Lombok)

}
