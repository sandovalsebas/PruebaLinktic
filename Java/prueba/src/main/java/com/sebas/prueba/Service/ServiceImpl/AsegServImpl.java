package com.sebas.prueba.Service.ServiceImpl;

import com.sebas.prueba.Entity.Asegurado;
import com.sebas.prueba.Repository.AseguradoRepo;
import com.sebas.prueba.Repository.PrimaRepo;
import com.sebas.prueba.Service.AseguradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio AseguradoService que interactúa con el repositorio AseguradoRepo y PrimaRepo.
 *
 * Proporciona métodos para listar asegurados y buscar asegurados por tipo y número de identificación.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
@Service
public class AsegServImpl implements AseguradoService {

    @Autowired
    private AseguradoRepo repo;

    @Autowired
    private PrimaRepo primaRepo;

    /**
     * Lista todos los asegurados.
     *
     * @return Lista de asegurados.
     */
    @Override
    public List<Asegurado> listarAsegurados() {
        return (List<Asegurado>) this.repo.findAll();
    }

    /**
     * Busca un asegurado por su tipo y número de identificación.
     *
     * @param tipo Tipo de identificación del asegurado.
     * @param numero Número de identificación del asegurado.
     * @return Una instancia de Optional que contiene el asegurado si se encuentra, o vacío si no.
     */
    @Override
    public Optional<Asegurado> buscarPorTipoYNumero(int tipo, int numero) {
        return this.repo.findByTipoIdentificacionAndNumeroIdentificacion(tipo, numero);
    }
}

