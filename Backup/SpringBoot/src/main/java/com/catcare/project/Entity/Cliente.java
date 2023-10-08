package com.catcare.project.Entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Long id; // Identificador único del cliente
    private String cedula; // Número de cédula del cliente
    private String nombre; // Nombre del cliente
    private String correo; // Correo electrónico del cliente
    private String celular; // Número de celular del cliente
    private String foto; // Ruta o enlace a la foto del cliente


    // Relación con Paciente. Se utiliza borrado en cascada respecto a los pacientes.
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
    private List<Paciente> pacientes = new ArrayList<>();


    // Constructor que recibe los datos del cliente
    public Cliente(String cedula, String nombre, String correo, String celular, String foto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.foto = foto;
    }

    // Constructor vacío
    public Cliente(){

    }

    //Getters y Setters del cliente
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
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public List<Paciente> getPacientes() {
        return pacientes;
    }
    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

}
