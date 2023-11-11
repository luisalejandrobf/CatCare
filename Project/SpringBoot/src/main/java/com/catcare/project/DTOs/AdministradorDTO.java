package com.catcare.project.DTOs;

import lombok.Data;

@Data
public class AdministradorDTO {
    private Long id; // Identificador único del administrador
    private String cedula;
    private String usuario; // Nombre de usuario del administrador
}