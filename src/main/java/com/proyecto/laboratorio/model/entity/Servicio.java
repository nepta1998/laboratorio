package com.proyecto.laboratorio.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private  Long id;

    @Column
    @NotBlank
    private String nombre;
    @Column
    @NotNull
    private char tipo;
    @Column
    @NotNull
    private double costo;

    //@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column
    @NotNull
    private Date fechai;

    //@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column
    @NotNull
    private Date fechaf;


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

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Date getFechai() {
        return fechai;
    }

    public void setFechai(Date fechai) {
        this.fechai = fechai;
    }

    public Date getFechaf() {
        return fechaf;
    }

    public void setFechaf(Date fechaf) {
        this.fechaf = fechaf;
    }
}
