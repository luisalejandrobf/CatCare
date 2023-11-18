package com.catcare.project.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.catcare.project.Entity.Veterinario;

@Mapper
public interface VeterinarioMapper {
    VeterinarioMapper INSTANCE = Mappers.getMapper(VeterinarioMapper.class);
    
    VeterinarioDTO convert(Veterinario administrador);
}
