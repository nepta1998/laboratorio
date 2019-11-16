package com.proyecto.laboratorio.model.entity;

import java.util.List;

public interface AgregarServicio {
    void agregarServicio(Servicio servicio);
    void eliminarServicio(Servicio servicio);
    List<Servicio>getAll();
    void deleteAll();
    ServicioIterator getServicioIterator();
}
