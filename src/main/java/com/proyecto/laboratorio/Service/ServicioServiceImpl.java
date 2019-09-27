package com.proyecto.laboratorio.Service;

import com.proyecto.laboratorio.Repository.ServicioRepository;
import com.proyecto.laboratorio.model.entity.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioServiceImpl implements ServicioService{

    @Autowired
    ServicioRepository servicioRepository;

    @Override
    public Iterable<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio createServicio(Servicio servicio) throws Exception {
        if(verificarUsuarioExiste(servicio))
        {
           servicio= servicioRepository.save(servicio);
        }
        return servicio;
    }

    @Override
    public Servicio getServicioById(Long id) throws Exception {
        return servicioRepository.findById(id).orElseThrow(() -> new  Exception("El servicio no existe"));
    }


    private boolean verificarUsuarioExiste(Servicio servicio) throws Exception {
        Optional<Servicio> servicioEncontrado=servicioRepository.findByNombre(servicio.getNombre());
        if(servicioEncontrado.isPresent())
        {
            throw  new Exception("Servicio ya esta presente");
        }
        return true;
    }
}
