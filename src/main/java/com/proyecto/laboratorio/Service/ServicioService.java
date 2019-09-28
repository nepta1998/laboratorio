package com.proyecto.laboratorio.Service;

import com.proyecto.laboratorio.model.entity.Servicio;

public interface ServicioService {
    public Iterable<Servicio> getAllServicios();

    public  Servicio createServicio(Servicio servicio) throws Exception;
    public  Servicio getServicioById(Long id) throws Exception;
    public  Servicio getServicioByNombre(String nombre) throws Exception;
    public  Servicio updateServicio(Servicio servicio) throws Exception;
    public  void deleteServicio(Long id) throws Exception;

}
