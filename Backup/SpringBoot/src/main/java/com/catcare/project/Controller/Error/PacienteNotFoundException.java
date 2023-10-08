package com.catcare.project.Controller.Error;

public class PacienteNotFoundException extends RuntimeException {
    private Long id;

    public PacienteNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
