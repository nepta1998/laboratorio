package com.proyecto.laboratorio.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Solicitud implements ImplementorSolicitud{

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    //@GenericGenerator(name = "native",strategy = "native")
    private  Long id;

    @Column
    private double presupuesto;

    @Column
    private  char status;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "servicio_solicitud",
    joinColumns = @JoinColumn(name = "solicitud_id"),
    inverseJoinColumns = @JoinColumn(name = "servicio_id"))
    private List<Servicio> servicios;

    @ManyToOne
    @JoinColumn(name="beneficiario_cedula", nullable=false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="empleado_cedula", nullable=false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name="fundacion_Id", nullable=false)
    private Fundacion fundacion;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @Column
    private Date fecha;

    @Column
    private  short prioridad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
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

    public short getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(short prioridad) {
        this.prioridad = prioridad;
    }

    /*public Long totalSolicitudes(Iterable<Solicitud> solicitudes)
    {
        Long contador=new Long(0);
        for (Object i:solicitudes) {
            contador++;
        }
        return contador;
    }*/
    public double contador_acumulador(Iterable<Solicitud> solicitudes)
    {
        double contador=0;
        for (Object i:solicitudes) {
            contador++;
        }
        return contador;
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
                ", prioridad=" + prioridad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solicitud)) return false;
        Solicitud solicitud = (Solicitud) o;
        return Double.compare(solicitud.getPresupuesto(), getPresupuesto()) == 0 &&
                getStatus() == solicitud.getStatus() &&
                getPrioridad() == solicitud.getPrioridad() &&
                getId().equals(solicitud.getId()) &&
                getServicios().equals(solicitud.getServicios()) &&
                getPersona().equals(solicitud.getPersona()) &&
                getEmpleado().equals(solicitud.getEmpleado()) &&
                getFundacion().equals(solicitud.getFundacion()) &&
                getFecha().equals(solicitud.getFecha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPresupuesto(), getStatus(), getServicios(), getPersona(), getEmpleado(), getFundacion(), getFecha(), getPrioridad());
    }
}
