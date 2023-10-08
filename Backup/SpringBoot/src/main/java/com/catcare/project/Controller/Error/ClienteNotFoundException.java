package com.catcare.project.Controller.Error;

public class ClienteNotFoundException extends RuntimeException {
    private Long id;

    public ClienteNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
