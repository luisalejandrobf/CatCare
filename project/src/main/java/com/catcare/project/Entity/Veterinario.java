package com.catcare.project.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Veterinario {

    @Id
    @GeneratedValue
    private Long id;
    
    private String cedula;
    private String contrasena;
    private String especialidad;
    private String foto;
    private int numeroAtencionesMedicas;

    // Relacion con Veterinarios
    @ManyToMany
    @JoinTable(name="Tratamiento_Veterinario", joinColumns = @JoinColumn(name="veterinario_id"), inverseJoinColumns = @JoinColumn(name="tratamiento_id"))
    private List<Tratamiento> tratamientos = new ArrayList<>();


    public Veterinario(String cedula, String contrasena, String especialidad, String foto,
            int numeroAtencionesMedicas) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.foto = foto;
        this.numeroAtencionesMedicas = numeroAtencionesMedicas;
    }

    public Veterinario() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public int getNumeroAtencionesMedicas() {
        return numeroAtencionesMedicas;
    }
    public void setNumeroAtencionesMedicas(int numeroAtencionesMedicas) {
        this.numeroAtencionesMedicas = numeroAtencionesMedicas;
    }

    
    
}
