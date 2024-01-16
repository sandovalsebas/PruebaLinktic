package com.sebas.prueba.Repository;

import com.sebas.prueba.Entity.Amparo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Repositorio que proporciona operaciones CRUD para la entidad Amparo.
 * Extiende CrudRepository de Spring Data.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
public interface AmparoRepo extends CrudRepository<Amparo, Integer> {
    /**
     * Busca un amparo por su código.
     *
     * @param codigo Código del amparo.
     * @return Una instancia de Optional que contiene el amparo si se encuentra, o vacío si no.
     */
    Optional<Amparo> findByCodigo(int codigo);
}

