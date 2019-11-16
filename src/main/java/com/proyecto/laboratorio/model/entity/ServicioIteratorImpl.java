package com.proyecto.laboratorio.model.entity;

import java.util.List;

public class ServicioIteratorImpl implements ServicioIterator{

    public List servicioList;
    int posicion;
    Servicio servicio;
    public  ServicioIteratorImpl(List servicioList)
    {
        this.servicioList=servicioList;
    }
    @Override
    public Servicio nextServicio() {
        System.out.println("psosicion:"+posicion);
        servicio=(Servicio)servicioList.get(posicion);
        posicion++;
        return servicio;
    }

    @Override
    public boolean isLastServicio() {
        if (posicion<servicioList.size())
        {
            return false;
        }
        return true;
    }
}
