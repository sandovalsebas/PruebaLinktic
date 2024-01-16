package com.sebas.prueba.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa un Data Transfer Object (DTO) para los amparos de seguro.
 * Contiene información simplificada sobre el código, nombre y valor de la prima del amparo.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
@Getter
@Setter
public class AmparoDTO {
    private int codigoAmparo;
    private String nombreAmparo;
    private float valorPrima;
}

