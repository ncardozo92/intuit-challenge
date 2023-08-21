package com.ncardozo.intuitchallenge.entity;

import java.util.List;

public class ErrorDto {
    private String mensaje;
    private List<String> detalles;

    public ErrorDto(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<String> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<String> detalles) {
        this.detalles = detalles;
    }

    public void addDetalle(String d){
        this.detalles.add(d);
    }
}
