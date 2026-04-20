package com.sistema.JOSEOLAYA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sistema.JOSEOLAYA.service.AsistenciaService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/asistencia")
@CrossOrigin
public class AsistenciaController {

    @Autowired
    private AsistenciaService service;

    @GetMapping
    public List<Map<String, Object>> listar() {
        return service.listar();
    }

    @PostMapping("/registrar")
    public Map<String, String> registrar(@RequestBody Map<String, String> body) {
        return service.registrar(body.get("dni"));
    }
}
