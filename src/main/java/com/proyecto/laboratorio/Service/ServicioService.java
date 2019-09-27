package com.proyecto.laboratorio.Service;

import com.proyecto.laboratorio.model.entity.Servicio;

public interface ServicioService {
    public Iterable<Servicio> getAllServicios();

    public  Servicio createServicio(Servicio servicio) throws Exception;
    public  Servicio getServicioById(Long id) throws Exception;
}
