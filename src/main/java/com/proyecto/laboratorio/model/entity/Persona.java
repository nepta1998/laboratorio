package com.proyecto.laboratorio.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Persona {

    @Id
    private String cedula;

    @Column
    private String nombre;

    @Column
    private char sexo;

    @Column
    private int edad;

    @Column
    private String telefono;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona that = (Persona) o;
        return getSexo() == that.getSexo() &&
                getEdad() == that.getEdad() &&
                getCedula().equals(that.getCedula()) &&
                getNombre().equals(that.getNombre()) &&
                getTelefono().equals(that.getTelefono());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCedula(), getNombre(), getSexo(), getEdad(), getTelefono());
    }

    @Override
    public String toString() {
        return "Beneficiario{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sexo=" + sexo +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
