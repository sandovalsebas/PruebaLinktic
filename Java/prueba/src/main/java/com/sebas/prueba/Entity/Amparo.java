package com.sebas.prueba.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa un amparo de seguro.
 * Contiene información sobre el código y el nombre del amparo.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
@Entity
@Table(name = "Amparos")
@Setter
@Getter
public class Amparo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "nombre")
    private String nombre;
}

