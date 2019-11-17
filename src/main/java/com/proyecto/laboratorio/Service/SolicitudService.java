package com.proyecto.laboratorio.Service;

import com.proyecto.laboratorio.model.entity.Fundacion;
import com.proyecto.laboratorio.model.entity.Solicitud;

import java.sql.Date;

public interface SolicitudService {

    public Iterable<Solicitud> getAllSolicitudes();
    public Iterable<Solicitud> getSolicitudesByStatus(char status);
    public Iterable<Solicitud> getSolicitudesByFecha(Date fecha1,Date fecha2);
    public Iterable<Solicitud> getSolicitudesByFechaAndFundacion(Date fecha1,Date fecha2,Fundacion fundacion);
    public Iterable<Solicitud> getSolicitudesByFundacion(Fundacion fundacion);
    public  Solicitud createSolicitud(Solicitud solicitud) throws Exception;
    public  Solicitud getSolicitudById(Long id) throws Exception;
    public  Solicitud updateSolicitud(Solicitud solicitud) throws Exception;
    public  void deleteSolicitud(Long id) throws Exception;
}
