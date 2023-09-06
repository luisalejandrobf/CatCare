package com.catcare.project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tratamiento_Droga {
    
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    private Tratamiento tratamiento;

    @ManyToOne
    private Droga droga;

}
