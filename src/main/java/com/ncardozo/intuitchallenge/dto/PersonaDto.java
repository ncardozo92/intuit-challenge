package com.ncardozo.intuitchallenge.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

public class PersonaDto {
    private Long id;
    @NotBlank(message = "El campo nombres no puede ser un string vacío")
    @NotNull(message = "El campo nombres no puede ser nulo")
    private String nombres;
    @NotBlank(message = "El campo apellidos no puede ser un string vacío")
    @NotNull(message = "El campo apellidos no puede ser nulo")
    private String apellidos;

    private Date fechaNacimiento;
    @NotBlank(message = "El campo cuit no puede ser un string vacío")
    @NotNull(message = "El campo cuit no puede ser nulo")
    @Pattern(regexp = "[\\wñÑ]*", message = "El cuit debe ser un valor alfanumérico")
    private String cuit;
    @NotBlank(message = "El campo direccion no puede ser un string vacío")
    @NotNull(message = "El campo direccion no puede ser nulo")
    private String direccion;
    @Pattern(regexp = "[\\d]*", message = "El campo telefono debe ser numérico")
    private String telefono;
    //@Pattern(regexp = "[a-zA-Z]*@[a-zA-Z]")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
