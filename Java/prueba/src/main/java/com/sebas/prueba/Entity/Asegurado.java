package com.sebas.prueba.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que representa a una persona asegurada.
 * Contiene información detallada sobre la persona, incluidos los amparos a los que está suscrita.
 *
 * @author Sebastian Sandoval
 * @version 1.0
 */
@Entity
@Table(name = "Asegurados")
@Setter
@Getter
public class Asegurado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;

    @Column(name = "listaAmparos")
    private String listaAmparos;

    @JsonIgnore
    public List<Integer> getListaAmparosAsList() {
        if (listaAmparos != null && !listaAmparos.isEmpty()) {
            return Arrays.stream(listaAmparos.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }
}
