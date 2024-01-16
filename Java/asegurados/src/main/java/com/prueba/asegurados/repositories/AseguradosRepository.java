package com.prueba.asegurados.repositories;

import com.prueba.asegurados.entities.Asegurado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AseguradosRepository extends JpaRepository<Asegurado, Integer> {
    Asegurado findByTipoIdentificacionAndNumeroIdentificacion(int tipoIdentificacion, int numeroIdentificacion);
    Asegurado findById(int id);

}
