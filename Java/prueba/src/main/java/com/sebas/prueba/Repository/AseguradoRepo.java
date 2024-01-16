package com.sebas.prueba.Repository;

import com.sebas.prueba.Entity.Asegurado;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Repositorio que proporciona operaciones CRUD para la entidad Asegurado.
 * Extiende CrudRepository de Spring Data.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
public interface AseguradoRepo extends CrudRepository<Asegurado, Integer> {
    /**
     * Busca un asegurado por su tipo y número de identificación.
     *
     * @param tipoIdentificacion Tipo de identificación del asegurado.
     * @param numeroIdentificacion Número de identificación del asegurado.
     * @return Una instancia de Optional que contiene el asegurado si se encuentra, o vacío si no.
     */
    Optional<Asegurado> findByTipoIdentificacionAndNumeroIdentificacion(int tipoIdentificacion, int numeroIdentificacion);
}

