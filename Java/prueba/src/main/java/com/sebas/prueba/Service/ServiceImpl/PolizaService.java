package com.sebas.prueba.Service.ServiceImpl;

import com.sebas.prueba.Entity.*;
import com.sebas.prueba.Service.AmparoService;
import com.sebas.prueba.Service.AseguradoService;
import com.sebas.prueba.Service.PrimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

/**
 * Servicio que realiza el cálculo de una póliza de seguro.
 * Interactúa con los servicios AmparoService, AseguradoService y PrimaService.
 *
 * Realiza el cálculo teniendo en cuenta la edad del asegurado y los amparos asociados.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
@Service
public class PolizaService {

    @Autowired
    private AmparoService amparoService;

    @Autowired
    private AseguradoService aseguradoService;

    @Autowired
    private PrimaService primaService;

    /**
     * Calcula la póliza de seguro.
     *
     * @param tipo   Tipo de identificación del asegurado.
     * @param numero Número de identificación del asegurado.
     * @param valor  Valor asegurado.
     * @return Un objeto SalidaDTO con los resultados del cálculo.
     */
    public SalidaDTO calcularPoliza(int tipo, int numero, int valor) {
        SalidaDTO salidaDTO = new SalidaDTO();
        float valorTotal = 0;

        Optional<Asegurado> asegurado = aseguradoService.buscarPorTipoYNumero(tipo, numero);

        if (asegurado.isPresent()) {
            salidaDTO.setTipoIdentificacion(tipo);
            salidaDTO.setNumeroIdentificacion(numero);
            salidaDTO.setValorAsegurado(valor);

            List<Integer> amparos = asegurado.get().getListaAmparosAsList();
            List<Prima> list = new ArrayList<>();
            List<AmparoDTO> list2 = new ArrayList<>();

            for (int i : amparos) {
                list.addAll(primaService.buscarPorCodigoAmparo(i));
            }
            LocalDate fechaNacimiento = asegurado.get().getFechaNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Period periodo = Period.between(fechaNacimiento, LocalDate.now());
            int edad = periodo.getYears();

            for (Prima p : list) {
                if (p.getEdadMinima() < edad && p.getEdadMaxima() > edad) {
                    AmparoDTO amparoDTO = new AmparoDTO();
                    amparoDTO.setCodigoAmparo(p.getCodigoAmparo());

                    Optional<Amparo> amparo = amparoService.buscarPorCodigo(p.getCodigoAmparo());
                    if (amparo.isPresent()) {
                        amparoDTO.setNombreAmparo(amparo.get().getNombre());
                        amparoDTO.setValorPrima(p.getPorcentajePrima() * valor);
                        valorTotal += (p.getPorcentajePrima() * valor);
                    }
                    list2.add(amparoDTO);
                }
            }

            salidaDTO.setLiquidacion(list2.isEmpty() ? null : list2);
            salidaDTO.setValorTotal(valorTotal);
        }
        return salidaDTO;
    }
}