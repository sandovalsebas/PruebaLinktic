package com.sebas.prueba.Service;

import com.sebas.prueba.Entity.Asegurado;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define operaciones de servicio para la entidad Asegurado.
 * Proporciona métodos para listar todos los asegurados y buscar un asegurado por su tipo y número de identificación.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
public interface AseguradoService {

    /**
     * Obtiene una lista de todos los asegurados disponibles.
     *
     * @return Lista de asegurados.
     */
    List<Asegurado> listarAsegurados();

    /**
     * Busca un asegurado por su tipo y número de identificación.
     *
     * @param tipo   Tipo de identificación del asegurado.
     * @param numero Número de identificación del asegurado.
     * @return Una instancia de Optional que contiene el asegurado si se encuentra, o vacío si no.
     */
    Optional<Asegurado> buscarPorTipoYNumero(int tipo, int numero);
}
