package com.catcare.project.Controller.Error;

public class PacienteNotFoundException extends RuntimeException {
    private int id;

    public PacienteNotFoundException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
