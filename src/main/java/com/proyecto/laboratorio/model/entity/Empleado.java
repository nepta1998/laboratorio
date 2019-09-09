package com.proyecto.laboratorio.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Empleado{

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

    @Column
    private String contraseña;

    @ManyToOne
    @JoinColumn(name="fundacion_Id", nullable=false)
    private Fundacion Fundacion;

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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public com.proyecto.laboratorio.model.entity.Fundacion getFundacion() {
        return Fundacion;
    }

    public void setFundacion(com.proyecto.laboratorio.model.entity.Fundacion fundacion) {
        Fundacion = fundacion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sexo=" + sexo +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", Fundacion=" + Fundacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empleado)) return false;
        Empleado empleado = (Empleado) o;
        return getSexo() == empleado.getSexo() &&
                getEdad() == empleado.getEdad() &&
                getCedula().equals(empleado.getCedula()) &&
                getNombre().equals(empleado.getNombre()) &&
                getTelefono().equals(empleado.getTelefono()) &&
                getContraseña().equals(empleado.getContraseña()) &&
                getFundacion().equals(empleado.getFundacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCedula(), getNombre(), getSexo(), getEdad(), getTelefono(), getContraseña(), getFundacion());
    }
}
