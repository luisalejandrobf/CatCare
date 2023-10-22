package com.catcare.project.controller;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.catcare.project.Controller.VeterinarioController;
import com.catcare.project.Entity.Veterinario;
import com.catcare.project.Service.VeterinarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.ArrayList;

@WebMvcTest(controllers = VeterinarioController.class)
@RunWith(SpringRunner.class)
public class VeterinarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VeterinarioService veterinarioService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void agregarVeterinarioTest() throws Exception {
        Veterinario vet = new Veterinario("123456789", "Dr. Cat", "password", "Feline Specialist", "photo.jpg", "Active");

        Mockito.doNothing().when(veterinarioService).add(any(Veterinario.class)); 

        ResultActions response = mockMvc.perform(
            post("/catcare/veterinarios/agregar")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(vet))
        );

        response.andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.nombre").value("Dr. Cat"));
    }

    @Test
    public void mostrarVeterinariosTest() throws Exception {
        List<Veterinario> vets = new ArrayList<>();
        vets.add(new Veterinario("123456789", "Dr. Cat", "password", "Feline Specialist", "photo.jpg", "Active"));
        vets.add(new Veterinario("987654321", "Dr. Dog", "password", "Canine Specialist", "photo2.jpg", "Active"));

        when(veterinarioService.SearchAll()).thenReturn(vets);

        ResultActions response = mockMvc.perform(get("/catcare/veterinarios/all"));

        response.andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.size()").value(2));
    }

    @Test
    public void mostrarInfoVeterinarioTest_notFound() throws Exception {
        when(veterinarioService.SearchById(anyLong())).thenReturn(null);

        ResultActions response = mockMvc.perform(get("/catcare/veterinarios/find").param("id", "1"));

        response.andExpect(status().isNotFound());
    }

    @Test
    public void eliminarVeterinarioTest() throws Exception {
        Veterinario vet = new Veterinario("123456789", "Dr. Cat", "password", "Feline Specialist", "photo.jpg", "Active");

        when(veterinarioService.SearchById(anyLong())).thenReturn(vet);
        Mockito.doNothing().when(veterinarioService).update(any(Veterinario.class));

        ResultActions response = mockMvc.perform(delete("/catcare/veterinarios/delete/1"));

        response.andExpect(status().isOk());
    }

    @Test
    public void actualizarVeterinarioTest() throws Exception {
        Veterinario vet = new Veterinario("123456789", "Dr. Cat", "password", "Feline Specialist", "photo.jpg", "Active");
        when(veterinarioService.SearchById(anyLong())).thenReturn(vet);
        Mockito.doNothing().when(veterinarioService).update(any(Veterinario.class)); // Use doNothing() for void methods
    
        vet.setNombre("Dr. Updated Cat");
        ResultActions response = mockMvc.perform(
            put("/catcare/veterinarios/update/1")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(vet))
        );
    
        response.andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.nombre").value("Dr. Updated Cat"));
    }
    
}