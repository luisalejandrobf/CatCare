package com.catcare.project.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.catcare.project.Entity.Droga;
import com.catcare.project.Entity.Veterinario;

@Mapper
public interface DrogaMapper {
    DrogaMapper INSTANCE = Mappers.getMapper(DrogaMapper.class);
    
    DrogaDTO convert(Droga droga);
}
