package com.catcare.project.Service;

import java.util.Collection;

import com.catcare.project.Entity.Mascota;

public interface MascotaService {
    
    public Mascota SearchById(int id);

    public Collection<Mascota> SearchAll();

    
}
