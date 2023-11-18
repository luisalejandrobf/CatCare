package com.catcare.project.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.catcare.project.Entity.Administrador;
import com.catcare.project.Entity.Cliente;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO convert(Cliente cliente);
}