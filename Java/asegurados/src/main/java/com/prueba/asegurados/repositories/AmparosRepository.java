package com.prueba.asegurados.repositories;

import com.prueba.asegurados.entities.Amparo;
import com.prueba.asegurados.entities.Asegurado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmparosRepository extends JpaRepository<Amparo, Integer> {
    Amparo findByCodigo(int codigo);
}
