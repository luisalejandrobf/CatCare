package com.catcare.project.DTOs;

import lombok.Data;

@Data
public class DrogaDTO {
    private Long id;
    private String nombre;
    private int unidadesVendidas;
    private int unidadesDisponibles;
}