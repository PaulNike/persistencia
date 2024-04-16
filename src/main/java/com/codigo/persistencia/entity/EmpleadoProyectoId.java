package com.codigo.persistencia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoProyectoId implements Serializable {
    @Column(name = "empleado_id")
    private Long empleadoId;

    @Column(name = "proyecto_id")
    private Long proyectoId;

}
