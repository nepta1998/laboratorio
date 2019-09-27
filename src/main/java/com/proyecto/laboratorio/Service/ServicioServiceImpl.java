package com.proyecto.laboratorio.Service;

import com.proyecto.laboratorio.Repository.ServicioRepository;
import com.proyecto.laboratorio.model.entity.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioServiceImpl implements ServicioService{

    @Autowired
    ServicioRepository servicioRepository;

    @Override
    public Iterable<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }
}
