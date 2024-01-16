package com.prueba.asegurados.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Data
@Entity
@IdClass(AseguradosAmparosId.class)
public class AseguradosAmparos {

    public AseguradosAmparos() { }

    @Id
    private int aseguradoId;

    @Id
    private int codigoAmparo;
}
