package com.prueba.asegurados.controllers;

import com.prueba.asegurados.entities.Asegurado;
import com.prueba.asegurados.services.AseguradosService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/asegurados")
public class AseguradoController {
    @Autowired
    private AseguradosService aseguradosService;

    @GetMapping("/")
    public String hola(){
        return "Hola";
    }

    @GetMapping("/list")
    public List<Asegurado> list(){
        return new ArrayList<>(aseguradosService.asegurados());
    }
}
