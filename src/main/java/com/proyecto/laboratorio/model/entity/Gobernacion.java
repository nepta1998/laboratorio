package com.proyecto.laboratorio.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Gobernacion {

    @Id
    @Column
    private String estado;
    @Column
    private double partidaAnual;

    @OneToMany(mappedBy="gobernacion")
    private Set<Fundacion> fundacion;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPartidaAnual() {
        return partidaAnual;
    }

    public void setPartidaAnual(double partidaAnual) {
        this.partidaAnual = partidaAnual;
    }
}
