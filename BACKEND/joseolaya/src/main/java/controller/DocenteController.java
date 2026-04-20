package com.sistema.JOSEOLAYA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sistema.JOSEOLAYA.model.Docente;
import com.sistema.JOSEOLAYA.repository.DocenteRepository;

import java.util.List;

@RestController
@RequestMapping("/docentes")
@CrossOrigin
public class DocenteController {

    @Autowired
    private DocenteRepository repo;

    @GetMapping
    public List<Docente> listar() {
        return repo.findAll();
    }
}
