package com.asistencia.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {

    @GetMapping
    public List<Map<String,Object>> listar(){
        return new ArrayList<>();
    }

    @PostMapping("/registrar")
    public Map<String,String> registrar(@RequestBody Map<String,String> body){
        Map<String,String> r = new HashMap<>();
        r.put("mensaje","Backend listo");
        return r;
    }
}