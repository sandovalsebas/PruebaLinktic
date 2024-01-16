package com.sebas.prueba.Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que representa un Data Transfer Object (DTO) para los resultados de la liquidación del seguro.
 * Contiene información sobre el tipo y número de identificación, valor asegurado, detalles de liquidación y valor total.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
@Getter
@Setter
public class SalidaDTO {

    public SalidaDTO() {
        this.liquidacion = null;
    }

    private int tipoIdentificacion;
    private int numeroIdentificacion;
    private int valorAsegurado;
    private List<AmparoDTO> liquidacion;
    private float valorTotal;

    /**
     * Convierte el objeto SalidaDTO a una representación JSON.
     *
     * @return JSON en formato de cadena.
     * @throws JsonProcessingException Si hay un error al procesar el objeto a JSON.
     */
    public String toJSON() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<SalidaDTO> listaSalidaDTO = Collections.singletonList(this);
        return mapper.writeValueAsString(listaSalidaDTO);
    }
}
