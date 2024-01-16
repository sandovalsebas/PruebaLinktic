package com.sebas.prueba.Service;

import com.sebas.prueba.Entity.Amparo;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define operaciones de servicio para la entidad Amparo.
 * Proporciona métodos para listar todos los amparos y buscar un amparo por su código.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
public interface AmparoService {

    /**
     * Obtiene una lista de todos los amparos disponibles.
     *
     * @return Lista de amparos.
     */
    List<Amparo> listarAmparos();

    /**
     * Busca un amparo por su código.
     *
     * @param codigo Código del amparo.
     * @return Una instancia de Optional que contiene el amparo si se encuentra, o vacío si no.
     */
    Optional<Amparo> buscarPorCodigo(int codigo);
}

