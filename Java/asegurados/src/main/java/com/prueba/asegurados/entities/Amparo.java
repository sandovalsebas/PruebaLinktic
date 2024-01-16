package com.prueba.asegurados.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Amparo {

    public Amparo() { }

    @Id
    private int codigo;

    private String nombre;

}
