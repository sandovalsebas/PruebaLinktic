package com.sebas.prueba.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sebas.prueba.Entity.*;
import com.sebas.prueba.Service.ServiceImpl.AmparoServImpl;
import com.sebas.prueba.Service.ServiceImpl.AsegServImpl;
import com.sebas.prueba.Service.ServiceImpl.PolizaService;
import com.sebas.prueba.Service.ServiceImpl.PrimaServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Clase controladora responsable de manejar operaciones relacionadas con seguros.
 * Esta clase define puntos finales REST para buscar, liquidar y listar entidades relacionadas con seguros.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
@RestController
@RequestMapping("")
public class Control {

    @Autowired
    private AsegServImpl asegServ;

    @Autowired
    private PrimaServImpl primaServ;

    @Autowired
    private AmparoServImpl amparoServ;

    @Autowired
    private PolizaService polizaService;

    /**
     * Recupera a una persona asegurada según el tipo y número de identificación proporcionados.
     *
     * @param tipoIdentificacion El tipo de identificación.
     * @param numeroIdentificacion El número de identificación.
     * @return ResponseEntity con la persona asegurada si se encuentra, o un estado no encontrado.
     */
    @GetMapping("/buscarAsegurado/{tipoIdentificacion}/{numeroIdentificacion}")
    public ResponseEntity<?> buscarAseguradoPorTipoYNumero(
            @PathVariable int tipoIdentificacion,
            @PathVariable int numeroIdentificacion) {
        Optional<Asegurado> asegurado = asegServ.buscarPorTipoYNumero(tipoIdentificacion, numeroIdentificacion);

        if (asegurado.isPresent()) {
            return ResponseEntity.ok(asegurado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Calcula la póliza de seguro y devuelve el resultado en formato JSON.
     *
     * @param entradaDTO Los datos de entrada para el cálculo del seguro.
     * @return ResponseEntity con los detalles de la póliza de seguro en formato JSON.
     */
    @GetMapping("/liquidar")
    public ResponseEntity<?> liquidar(@RequestBody EntradaDTO entradaDTO) {
        if (entradaDTO.getTipoIdentificacion() > 0 &&
                entradaDTO.getNumeroIdentificacion() > 0 &&
                entradaDTO.getValorAsegurado() > 0) {
            if (asegServ.buscarPorTipoYNumero(entradaDTO.getTipoIdentificacion(), entradaDTO.getNumeroIdentificacion()).isPresent()) {
                SalidaDTO salidaDTO = polizaService.calcularPoliza(
                        entradaDTO.getTipoIdentificacion(),
                        entradaDTO.getNumeroIdentificacion(),
                        entradaDTO.getValorAsegurado()
                );

                try {
                    return ResponseEntity.ok(salidaDTO.toJSON());
                } catch (JsonProcessingException e) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la liquidación");
                }
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la liquidación");
    }

    /**
     * Recupera una lista de personas aseguradas.
     *
     * @return ResponseEntity con la lista de personas aseguradas.
     */
    @GetMapping("/listarAsegurados")
    public ResponseEntity<?> listarAsegurados() {
        List<Asegurado> listaAsegurados = this.asegServ.listarAsegurados();
        return ResponseEntity.ok(listaAsegurados);
    }

    /**
     * Recupera una lista de primas de seguros.
     *
     * @return ResponseEntity con la lista de primas de seguros.
     */
    @GetMapping("/listarPrimas")
    public ResponseEntity<?> listarPrimas() {
        List<Prima> listaPrimas = this.primaServ.listarPrimas();
        return ResponseEntity.ok(listaPrimas);
    }

    /**
     * Recupera una lista de coberturas de seguros.
     *
     * @return ResponseEntity con la lista de coberturas de seguros.
     */
    @GetMapping("/listarAmparos")
    public ResponseEntity<?> listarAmparos() {
        List<Amparo> listaAmparos = this.amparoServ.listarAmparos();
        return ResponseEntity.ok(listaAmparos);
    }
}
