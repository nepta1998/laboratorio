package com.proyecto.laboratorio.Service;

import com.proyecto.laboratorio.Repository.SolicitudRepository;
import com.proyecto.laboratorio.model.entity.Empleado;
import com.proyecto.laboratorio.model.entity.Fundacion;
import com.proyecto.laboratorio.model.entity.Solicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class SolicitudServiceImpl implements SolicitudService{
    @Autowired
    SolicitudRepository solicitudRepository;
    @Override
    public Iterable<Solicitud> getAllSolicitudes() {
        return solicitudRepository.findAll();
    }

    @Override
    public Iterable<Solicitud> getSolicitudesByStatus(char status) {
        return solicitudRepository.findByStatus(status);
    }

    @Override
    public Iterable<Solicitud> getSolicitudesByFecha(Date fecha1, Date fecha2) {
        return solicitudRepository.findByFechaBetween(fecha1,fecha2);
    }

    @Override
    public Iterable<Solicitud> getSolicitudesByFechaAndFundacion(Date fecha1, Date fecha2, Fundacion fundacion) {
        return solicitudRepository.findByFechaBetweenAndFundacion(fecha1,fecha2,fundacion);
    }

    @Override
    public Iterable<Solicitud> getSolicitudesByFundacion(Fundacion fundacion) {
        return solicitudRepository.findByFundacion(fundacion);
    }

    @Override
    public Iterable<Solicitud> getSolicitudesByEmpleado(Empleado empleado) {
        return solicitudRepository.findByEmpleado(empleado);
    }

    @Override
    public Solicitud createSolicitud(Solicitud solicitud) throws Exception {
        if(verificarSolicitudExiste(solicitud))
        {
            solicitud= solicitudRepository.save(solicitud);
        }
        return solicitud;
    }

    @Override
    public Solicitud getSolicitudById(Long id) throws Exception {
        return solicitudRepository.findById(id).orElseThrow(() -> new  Exception("la solicitud no existe"));
    }

    @Override
    public Solicitud updateSolicitud(Solicitud solicitud) throws Exception {
        Solicitud encontrarSolicitud=getSolicitudById(solicitud.getId());
        mapSolicitud(solicitud,encontrarSolicitud);
        return solicitudRepository.save(encontrarSolicitud);
    }

    @Override
    public void deleteSolicitud(Long id) throws Exception {
        Solicitud solicitud=getSolicitudById(id);
        solicitudRepository.delete(solicitud);

    }

    protected void mapSolicitud(Solicitud from,Solicitud to){
        to.setPresupuesto(from.getPresupuesto());
        to.setStatus(from.getStatus());
        to.setEmpleado(from.getEmpleado());
        to.setPrioridad(from.getPrioridad());
        to.setFecha(from.getFecha());
        to.setPersona(from.getPersona());
        to.setFundacion(from.getFundacion());
        to.setServicios(from.getServicios());
    }


    private boolean verificarSolicitudExiste(Solicitud solicitud) throws Exception {
        Optional<Solicitud> servicioEncontrado=solicitudRepository.findById(solicitud.getId());
        if(servicioEncontrado.isPresent())
        {
            throw  new Exception("Solicitud ya esta presente");
        }
        return true;
    }
}
