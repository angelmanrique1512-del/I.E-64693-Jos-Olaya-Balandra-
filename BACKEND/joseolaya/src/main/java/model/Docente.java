package com.sistema.JOSEOLAYA.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Docente")
public class Docente {

    @Id
    private String dni;

    private String nombre;
    private String apellidos;
    private String curso;

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
}
