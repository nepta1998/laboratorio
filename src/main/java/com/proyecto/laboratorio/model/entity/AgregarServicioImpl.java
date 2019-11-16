package com.proyecto.laboratorio.model.entity;

import java.util.ArrayList;
import java.util.List;

public class AgregarServicioImpl implements  AgregarServicio {
    List serviciolist;
    private static AgregarServicio instancia=null;


    private AgregarServicioImpl()
    {
        serviciolist=new ArrayList();
    }

    public static AgregarServicio Instance()
    {
        if(instancia==null)
        {
            instancia=new AgregarServicioImpl();
        }
        return instancia;
    }

    @Override
    public void agregarServicio(Servicio servicio) {
        serviciolist.add(servicio);
    }

    @Override
    public void eliminarServicio(Servicio servicio) {
            serviciolist.remove(servicio);
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
