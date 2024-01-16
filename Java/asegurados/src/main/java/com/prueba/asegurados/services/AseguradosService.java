package com.prueba.asegurados.services;

import com.prueba.asegurados.entities.Asegurado;
import com.prueba.asegurados.repositories.AseguradosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AseguradosService {

    @Autowired
    AseguradosRepository aseguradosRepository;

    public List<Asegurado> asegurados(){
        List<Asegurado> asegurados = new ArrayList<>();
        aseguradosRepository.findAll().forEach(asegurados::add);
        return asegurados;
    }


    public Asegurado getOneByTipoNumero(int tipoIdentificacion, int numeroIdentificacion){
        Asegurado asegurado = null;
        asegurado = aseguradosRepository.findByTipoIdentificacionAndNumeroIdentificacion(tipoIdentificacion,numeroIdentificacion);
        return asegurado;
    }
}
