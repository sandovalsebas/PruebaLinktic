package com.sebas.prueba.Repository;

import com.sebas.prueba.Entity.Prima;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio que proporciona operaciones CRUD para la entidad Prima.
 * Extiende CrudRepository de Spring Data.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
public interface PrimaRepo extends CrudRepository<Prima, Integer> {
    // No se proporcionan métodos adicionales ya que se utilizan las operaciones CRUD estándar.
}
