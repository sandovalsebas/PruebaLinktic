package com.prueba.asegurados.services;

import com.prueba.asegurados.entities.Prima;
import com.prueba.asegurados.repositories.PrimasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class PrimasService {

    @Autowired
    PrimasRepository primasRepository;

    public List<Prima> primas() {
        List<Prima> primas = new ArrayList<>();
        primasRepository.findAll().forEach(primas::add);
        return primas;
    }

}
