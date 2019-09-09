package com.proyecto.laboratorio.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Fundacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private  long id;

    @Column
    private String nombre;
    @Column
    private double presupuesto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fundacion)) return false;
        Fundacion fundacion = (Fundacion) o;
        return getId() == fundacion.getId() &&
                Double.compare(fundacion.getPresupuesto(), getPresupuesto()) == 0 &&
                getNombre().equals(fundacion.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getPresupuesto());
    }

    @Override
    public String toString() {
        return "fundacion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", presupuesto=" + presupuesto +
                '}';
    }
}
