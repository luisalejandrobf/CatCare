package com.catcare.project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
public class Administrador {

    // User role
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private UserEntity user;
    
    @Id
    @GeneratedValue
    private Long id; // Identificador único del administrador
    private String cedula;

    private String usuario; // Nombre de usuario del administrador
    //@Transient // No se muestra en H2
    private String contrasena; // Contraseña del administrador

    // Constructor especifico sin ID o relaciones.
    // Constructor que recibe el nombre de usuario y la contraseña
    public Administrador(String cedula, String usuario, String contrasena) {
        this.cedula = cedula;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Constructor vacío (implementado con Lombok)

    // Getters y Setters (implementado con Lombok)

}
