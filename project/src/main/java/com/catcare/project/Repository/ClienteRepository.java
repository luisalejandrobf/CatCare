package com.catcare.project.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Paciente;

import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {

    private Map<Integer, Cliente> data = new HashMap<>();

    public ClienteRepository() {
        data.put(1, new Cliente(1, "1234", "Luis Alejandro Bravo Ferreira", "luis.bravof@javeriana.edu.co", "3162858895"));
        data.put(2, new Cliente(2, "2323", "Felipe Garcia Castiblanco", "felipe.gar@javeriana.edu.co", "32424234334"));
        data.put(3, new Cliente(3, "3434", "Ana Maria Ortegon Sepulveda", "ana.ortegon@javeriana.edu.co", "43242423434"));
        data.put(4, new Cliente(4, "5678", "María García Pérez", "maria.garcia@example.com", "3112345678"));
        data.put(5, new Cliente(5, "3456", "Ana Martínez González", "ana.martinez@example.com", "3334567890"));
        data.put(6, new Cliente(6, "6789", "Carlos Sánchez Ruiz", "carlos.sanchez@example.com", "3445678901"));
        data.put(7, new Cliente(7, "2345", "Isabel López Ramírez", "isabel.lopez@example.com", "3556789012"));
        data.put(8, new Cliente(8, "7890", "Andrés Hernández Herrera", "andres.hernandez@example.com", "3667890123"));
    }

    public Cliente findById(int id) {
        return data.get(id);
    }

    public Cliente findByCedula(String cedula) {
        for (Cliente cliente : data.values()) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null; // Return null if cedula is not found
    }
    
    public Collection<Cliente> findAll() {
        return data.values();
    }

    public void deleteById(int id) {
        data.remove(id);
    }

    public void updateById(Cliente cliente) {
        data.put(cliente.getId(), cliente);
    }

    public void add(Cliente cliente) {
        int tam = data.size();
        int lastId = data.get(tam).getId();
        cliente.setId(lastId + 1);
        data.put(lastId + 1, cliente);
    }

    public int size() {
        return data.size();
    }

}
