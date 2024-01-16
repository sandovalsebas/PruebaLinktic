package com.sebas.prueba.Service.ServiceImpl;

import com.sebas.prueba.Entity.Amparo;
import com.sebas.prueba.Repository.AmparoRepo;
import com.sebas.prueba.Service.AmparoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio AmparoService que interactúa con el repositorio AmparoRepo.
 *
 * Proporciona métodos para listar amparos y buscar amparos por código.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
@Service
public class AmparoServImpl implements AmparoService {

    @Autowired
    private AmparoRepo repo;

    /**
     * Lista todos los amparos.
     *
     * @return Lista de amparos.
     */
    @Override
    public List<Amparo> listarAmparos() {
        return (List<Amparo>) this.repo.findAll();
    }

    /**
     * Busca un amparo por su código.
     *
     * @param codigo Código del amparo.
     * @return Una instancia de Optional que contiene el amparo si se encuentra, o vacío si no.
     */
    @Override
    public Optional<Amparo> buscarPorCodigo(int codigo) {
        return this.repo.findByCodigo(codigo);
    }
}
