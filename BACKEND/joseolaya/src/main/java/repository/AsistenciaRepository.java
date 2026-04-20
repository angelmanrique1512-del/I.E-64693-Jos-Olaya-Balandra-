package com.sistema.JOSEOLAYA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.JOSEOLAYA.model.Asistencia;

import java.time.LocalDate;
import java.util.Optional;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    Optional<Asistencia> findByDniAndFecha(String dni, LocalDate fecha);
}
