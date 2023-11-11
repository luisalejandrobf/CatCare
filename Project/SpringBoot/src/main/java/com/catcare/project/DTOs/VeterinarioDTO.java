package com.catcare.project.DTOs;

import lombok.Data;

@Data
public class VeterinarioDTO {
    private Long id;
    private String cedula;
    private String nombre;
    private String especialidad;
    private String foto;
    private String estado;
}