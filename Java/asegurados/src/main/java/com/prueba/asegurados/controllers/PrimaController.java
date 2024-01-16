package com.prueba.asegurados.controllers;

import com.prueba.asegurados.entities.Prima;
import com.prueba.asegurados.services.PrimasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/prima")
public class PrimaController {
    @Autowired
    private PrimasService primasService;

    @GetMapping("/")
    public String hola(){
        return "Hola";
    }

    @GetMapping("/list")
    public ResponseEntity<List<Prima>> list(){
        List<Prima> list = primasService.primas();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
