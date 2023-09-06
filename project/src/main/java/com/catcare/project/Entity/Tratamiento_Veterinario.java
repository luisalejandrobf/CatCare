package com.catcare.project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tratamiento_Veterinario {
    
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    private Tratamiento tratamiento;

    @ManyToOne
    private Veterinario veterinario;

    private String comentarios;

}
