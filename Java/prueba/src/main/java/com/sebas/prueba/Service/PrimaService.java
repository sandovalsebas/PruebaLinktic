package com.sebas.prueba.Service;

import com.sebas.prueba.Entity.Prima;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define operaciones de servicio para la entidad Prima.
 * Proporciona métodos para listar todas las primas y buscar primas por código de amparo.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
public interface PrimaService {

    /**
     * Obtiene una lista de todas las primas disponibles.
     *
     * @return Lista de primas.
     */
    List<Prima> listarPrimas();

    /**
     * Busca primas por el código de amparo.
     *
     * @param codigoAmparo Código del amparo.
     * @return Lista de primas asociadas al código de amparo.
     */
    List<Prima> buscarPorCodigoAmparo(int codigoAmparo);
}

