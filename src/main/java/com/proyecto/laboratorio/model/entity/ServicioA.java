package com.proyecto.laboratorio.model.entity;

import java.util.List;

public interface ServicioA {
    void agregarServicio(Servicio servicio);
    void eliminarServicio(int posicion);
    List<Servicio>getAll();
    void deleteAll();
    ServicioIterator getServicioIterator();
}
