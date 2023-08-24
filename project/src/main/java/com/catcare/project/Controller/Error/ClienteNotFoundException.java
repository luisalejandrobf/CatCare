package com.catcare.project.Controller.Error;

public class ClienteNotFoundException extends RuntimeException {
    private int id;

    public ClienteNotFoundException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
