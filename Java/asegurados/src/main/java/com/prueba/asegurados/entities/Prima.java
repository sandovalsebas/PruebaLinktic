package com.prueba.asegurados.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "primas")
@Getter
public class Prima {

    public Prima() {
    }

    public Prima(Integer codigoAmparo, Integer edadMinima, Integer edadMaxima, float porcentajePrima) {
        this.codigoAmparo = codigoAmparo;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.porcentajePrima = porcentajePrima;
    }

    @Id
    private Integer codigoAmparo;

    @Column(name = "edadMinima")
    private Integer edadMinima;

    @Column(name = "edadMaxima")
    private Integer edadMaxima;

    @Column(name = "porcentajePrima")
    private Float porcentajePrima;
}
