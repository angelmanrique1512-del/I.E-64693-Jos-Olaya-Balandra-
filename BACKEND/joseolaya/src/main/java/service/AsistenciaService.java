package com.sistema.JOSEOLAYA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.JOSEOLAYA.model.*;
import com.sistema.JOSEOLAYA.repository.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class AsistenciaService {

    @Autowired
    private DocenteRepository docenteRepo;

    @Autowired
    private AsistenciaRepository asistenciaRepo;

    public List<Map<String, Object>> listar() {

        List<Asistencia> lista = asistenciaRepo.findAll();
        List<Map<String, Object>> resultado = new ArrayList<>();

        for (Asistencia a : lista) {

            Optional<Docente> doc = docenteRepo.findById(a.getDni());

            if (doc.isPresent()) {
                Docente d = doc.get();

                Map<String, Object> map = new HashMap<>();
                map.put("dni", d.getDni());
                map.put("nombre", d.getNombre());
                map.put("apellidos", d.getApellidos());
                map.put("curso", d.getCurso());
                map.put("fecha", a.getFecha());
                map.put("hora_entrada", a.getHoraEntrada());
                map.put("estado", a.getEstado());

                resultado.add(map);
            }
        }

        return resultado;
    }

    public Map<String, String> registrar(String dni) {

        Optional<Docente> doc = docenteRepo.findById(dni);

        if (doc.isEmpty()) {
            return Map.of("mensaje", "Docente no existe");
        }

        LocalDate hoy = LocalDate.now();

        Optional<Asistencia> existe =
                asistenciaRepo.findByDniAndFecha(dni, hoy);

        if (existe.isPresent()) {
            return Map.of("mensaje", "Ya registró hoy");
        }

        Asistencia a = new Asistencia();
        a.setDni(dni);
        a.setFecha(hoy);
        a.setHoraEntrada(LocalTime.now());

        if (LocalTime.now().isBefore(LocalTime.of(7, 10))) {
            a.setEstado("Temprano");
        } else {
            a.setEstado("Tardanza");
        }

        asistenciaRepo.save(a);

        return Map.of("mensaje", "Registrado correctamente");
    }
}
