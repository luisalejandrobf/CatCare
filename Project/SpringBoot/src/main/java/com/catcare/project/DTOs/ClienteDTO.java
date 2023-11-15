package com.catcare.project.DTOs;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long id; // Identificador único del cliente
    private String cedula; // Número de cédula del cliente
    private String nombre; // Nombre del cliente
}