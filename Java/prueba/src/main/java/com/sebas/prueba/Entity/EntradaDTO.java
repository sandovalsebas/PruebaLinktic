package com.sebas.prueba.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa un Data Transfer Object (DTO) para los datos de entrada del seguro.
 * Contiene información sobre el tipo de identificación, número de identificación y valor asegurado.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
@Getter
@Setter
public class EntradaDTO {

    private int tipoIdentificacion;
    private int numeroIdentificacion;
    private int valorAsegurado;
}

