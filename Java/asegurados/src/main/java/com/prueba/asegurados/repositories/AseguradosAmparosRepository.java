package com.prueba.asegurados.repositories;

import com.prueba.asegurados.entities.AseguradosAmparos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AseguradosAmparosRepository extends JpaRepository<AseguradosAmparos, Integer> {

    AseguradosAmparos findByAseguradoIdAndCodigoAmparo(int aseguradoId, int codigoAmparo);

}
