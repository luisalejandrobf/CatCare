package com.catcare.project.Entity;

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
public class Veterinario {

    @Id
    @GeneratedValue
    private Long id;
    
    private String cedula;
    private String nombre;
    private String contrasena;
    private String especialidad;
    private String foto;
    private int numeroAtencionesMedicas;

    // Relacion con Tratamiento. Se utiliza borrado en cascada respecto a los Tratamientos.
    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.REMOVE)
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }



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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
