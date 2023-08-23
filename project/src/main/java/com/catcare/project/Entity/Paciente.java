package com.catcare.project.Entity;

public class Paciente {
    // Atributos
    private int id; // Nuevo atributo de ID
    private String nombre;
    private String raza;
    private int edad;
    private double peso;
    private String enfermedad;
    private String estado;

    // Constructor
    public Paciente(int id, String nombre, String raza, int edad, double peso, String enfermedad, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.enfermedad = enfermedad;

        // Enfermedad vacia por defecto
        if (enfermedad.isEmpty()) {
            this.enfermedad = "Sin enfermedad registrada";
        }

        this.estado = estado;
    }

    // Métodos getters y setters

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método para mostrar información de la mascota
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Enfermedad: " + enfermedad);
        System.out.println("Estado: " + estado);
    }

}
