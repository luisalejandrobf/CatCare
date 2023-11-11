package com.catcare.project.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.catcare.project.Entity.Administrador;

@Mapper
public interface AdministradorMapper {
    AdministradorMapper INSTANCE = Mappers.getMapper(AdministradorMapper.class);
    
    AdministradorDTO convert(Administrador administrador);
}
