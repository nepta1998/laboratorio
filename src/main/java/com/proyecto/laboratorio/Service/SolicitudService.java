package com.proyecto.laboratorio.Service;

import com.proyecto.laboratorio.model.entity.Solicitud;

public interface SolicitudService {

    public Iterable<Solicitud> getAllSolicitudes();
    public Iterable<Solicitud> getSolicitudesByStatus(char status);
    public  Solicitud createSolicitud(Solicitud solicitud) throws Exception;
    public  Solicitud getSolicitudById(Long id) throws Exception;
    public  Solicitud updateSolicitud(Solicitud solicitud) throws Exception;
    public  void deleteSolicitud(Long id) throws Exception;
}
