package com.proyecto.laboratorio.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private  Long id;

    @Column
    private double presupuesto;

    @Column
    private  char status;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "servicio_solicitud",
    joinColumns = @JoinColumn(name = "solicitud_id"),
    inverseJoinColumns = @JoinColumn(name = "servicio_id"))
    private Set<Servicio> servicios;

    @ManyToOne
    @JoinColumn(name="beneficiario_cedula", nullable=false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="empleado_cedula", nullable=false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name="fundacion_Id", nullable=false)
    private Fundacion fundacion;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column
    private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = this.fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Set<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(Set<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Fundacion getFundacion() {
        return fundacion;
    }

    public void setFundacion(Fundacion fundacion) {
        this.fundacion = fundacion;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "id=" + id +
                ", presupuesto=" + presupuesto +
                ", status=" + status +
                ", servicios=" + servicios +
                ", persona=" + persona +
                ", empleado=" + empleado +
                ", fundacion=" + fundacion +
                ", fecha=" + fecha +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solicitud)) return false;
        Solicitud solicitud = (Solicitud) o;
        return getId() == solicitud.getId() &&
                Double.compare(solicitud.getPresupuesto(), getPresupuesto()) == 0 &&
                getStatus() == solicitud.getStatus() &&
                getServicios().equals(solicitud.getServicios()) &&
                getPersona().equals(solicitud.getPersona()) &&
                getEmpleado().equals(solicitud.getEmpleado()) &&
                getFundacion().equals(solicitud.getFundacion()) &&
                getFecha().equals(solicitud.getFecha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPresupuesto(), getStatus(), getServicios(), getPersona(), getEmpleado(), getFundacion(), getFecha());
    }
}
