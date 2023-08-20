package com.catcare.project.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catcare.project.Entity.Mascota;
import com.catcare.project.Repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {
    
    // Autowires from mascota repo

    @Autowired
    MascotaRepository mascotaRepository;

    // Uses the methods declared in MascotaRepository

    @Override
    public Mascota SearchById(int id) {
       return  mascotaRepository.findById(id);
    }

    @Override
    public Collection<Mascota> SearchAll() {
        return mascotaRepository.findAll();
    }

}
