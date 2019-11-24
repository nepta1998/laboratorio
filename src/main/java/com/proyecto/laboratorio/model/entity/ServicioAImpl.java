package com.proyecto.laboratorio.model.entity;

import java.util.ArrayList;
import java.util.List;

public class ServicioAImpl implements ServicioA {
    List serviciolist;
    private static ServicioA instancia=null;


    private ServicioAImpl()
    {
        serviciolist=new ArrayList();
    }

    public static ServicioA Instance()
    {
        if(instancia==null)
        {
            instancia=new ServicioAImpl();
        }
        return instancia;
    }

    @Override
    public void agregarServicio(Servicio servicio) {
        serviciolist.add(servicio);
    }

    @Override
    public void eliminarServicio(int posicion) {
            serviciolist.remove(posicion);
    }

    @Override
    public List<Servicio> getAll() {
        return serviciolist;
    }

    @Override
    public void deleteAll() {
        serviciolist.clear();
    }

    @Override
    public ServicioIterator getServicioIterator() {
        return  new ServicioIteratorImpl(serviciolist);
    }




}
