package com.sebas.prueba.Service.ServiceImpl;

import com.sebas.prueba.Entity.Prima;
import com.sebas.prueba.Repository.PrimaRepo;
import com.sebas.prueba.Service.PrimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del servicio PrimaService que interactúa con el repositorio PrimaRepo.
 *
 * Proporciona métodos para listar primas y buscar primas por código de amparo.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
@Service
public class PrimaServImpl implements PrimaService {

    @Autowired
    private PrimaRepo repo;

    /**
     * Lista todas las primas.
     *
     * @return Lista de primas.
     */
    @Override
    public List<Prima> listarPrimas() {
        return (List<Prima>) this.repo.findAll();
    }

    /**
     * Busca primas por el código de amparo.
     *
     * @param codigoAmparo Código del amparo.
     * @return Lista de primas asociadas al código de amparo.
     */
    @Override
    public List<Prima> buscarPorCodigoAmparo(int codigoAmparo) {
        List<Prima> list = new ArrayList<>();
        for(Prima p : listarPrimas()){
            if(codigoAmparo == p.getCodigoAmparo()){
                list.add(p);
            }
        }
        return list;
    }
}
