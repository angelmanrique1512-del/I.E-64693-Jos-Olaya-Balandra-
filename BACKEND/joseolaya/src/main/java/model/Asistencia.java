package com.sistema.JOSEOLAYA.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Asistencia")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsistencia;

    private String dni;
    private LocalDate fecha;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private String estado;

    public Integer getIdAsistencia() { return idAsistencia; }
    public void setIdAsistencia(Integer idAsistencia) { this.idAsistencia = idAsistencia; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(LocalTime horaEntrada) { this.horaEntrada = horaEntrada; }

    public LocalTime getHoraSalida() { return horaSalida; }
    public void setHoraSalida(LocalTime horaSalida) { this.horaSalida = horaSalida; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
