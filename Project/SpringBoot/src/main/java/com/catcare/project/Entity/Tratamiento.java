package com.catcare.project.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tratamiento {


    @Id
    @GeneratedValue
    private Long id;
    
    private Date fechaDeInicio;

    // @JsonIgnore // Evitar retornar informacion referenciada
    // Relacion con Paciente
    @ManyToOne
    private Paciente paciente;

    // @JsonIgnore // Evitar retornar informacion referenciada
    // Relacion con Droga
    @ManyToOne
    private Droga droga;

    // @JsonIgnore // Evitar retornar informacion referenciada
    // Relacion con Veterinario
    @ManyToOne
    private Veterinario veterinario;

    // Constructor vacío (implementado con Lombok)

    // Getters y Setters (implementado con Lombok)

}
