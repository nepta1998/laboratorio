package com.proyecto.laboratorio.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Fundacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private  Long id;

    @Column
    private String nombre;
    @Column
    private double porcentaje;

    @ManyToOne
    @JoinColumn(name="gobernacion_Id", nullable=false)
    private Gobernacion gobernacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPresupuesto() {
        return porcentaje;
    }

    public void setPresupuesto(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Gobernacion getGobernacion() {
        return gobernacion;
    }

    public void setGobernacion(Gobernacion gobernacion) {
        this.gobernacion = gobernacion;
    }
}
