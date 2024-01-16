package com.prueba.asegurados.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "asegurados")
@Getter
public class Asegurado {

    public Asegurado(){ }

    public Asegurado(int id, int tipoIdentificacion, int numeroIdentificacion, String apellidos, String nombres, Integer sexo, Date fechaNacimiento) {
        this.id = id;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "tipoIdentificacion")
    private int tipoIdentificacion;

    @Column(name = "numeroIdentificacion")
    private int numeroIdentificacion;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "sexo")
    private int sexo;

    @Column(name = "fechaNacimiento")
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date fechaNacimiento;

}