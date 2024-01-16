package com.sebas.prueba.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa una prima de seguro.
 * Contiene información sobre el código del amparo asociado, edad mínima y máxima, y el porcentaje de la prima.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
@Entity
@Table(name = "Primas")
@Setter
@Getter
public class Prima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codigoAmparo")
    private int codigoAmparo;

    @Column(name = "edadMinima")
    private int edadMinima;

    @Column(name = "edadMaxima")
    private int edadMaxima;

    @Column(name = "porcentajePrima")
    private float porcentajePrima;
}
