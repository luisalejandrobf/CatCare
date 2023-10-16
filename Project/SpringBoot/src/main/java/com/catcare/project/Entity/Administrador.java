package com.catcare.project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Administrador {
    
    @Id
    @GeneratedValue
    private Long id; // Identificador único del administrador
    private String cedula;
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    private String usuario; // Nombre de usuario del administrador
    private String contrasena; // Contraseña del administrador


    // Constructor que recibe el nombre de usuario y la contraseña
    public Administrador(String cedula,String usuario, String contrasena) {
        this.cedula = cedula;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Constructor vacío
    public Administrador() {
    }

    // Getters y Setters del administrador
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
