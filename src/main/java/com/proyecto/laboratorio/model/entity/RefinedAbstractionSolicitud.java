package com.proyecto.laboratorio.model.entity;

public class RefinedAbstractionSolicitud implements AbstraccionSolicitud{

    ImplementorSolicitud implementacion=null;

    public RefinedAbstractionSolicitud(ImplementorSolicitud imp){
        this.implementacion=imp;
    }
    @Override
    public double contador_acumulador(Iterable<Solicitud> solicitudes) {
        return implementacion.contador_acumulador(solicitudes);
    }
}
