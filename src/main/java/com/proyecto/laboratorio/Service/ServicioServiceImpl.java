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
        if(verificarServicioExiste(servicio))
        {
           servicio= servicioRepository.save(servicio);
        }
        return servicio;
    }

    @Override
    public Servicio getServicioById(Long id) throws Exception {
        return servicioRepository.findById(id).orElseThrow(() -> new  Exception("El servicio no existe"));
    }

    @Override
    public Servicio getServicioByNombre(String nombre) throws Exception {
        return servicioRepository.findByNombre(nombre).orElseThrow(() -> new  Exception("El servicio no existe"));
    }

    @Override
    public Servicio updateServicio(Servicio servicio) throws Exception {
        Servicio encontrarServicio=getServicioById(servicio.getId());
        mapServicio(servicio,encontrarServicio);
        return servicioRepository.save(encontrarServicio);

    }

    @Override
    public void deleteServicio(Long id) throws Exception {
        Servicio servicio=getServicioById(id);
        servicioRepository.delete(servicio);
    }

    protected void mapServicio(Servicio from,Servicio to){
        to.setNombre(from.getNombre());
        to.setTipo(from.getTipo());
        to.setCosto(from.getCosto());
    }


    private boolean verificarServicioExiste(Servicio servicio) throws Exception {
        Optional<Servicio> servicioEncontrado=servicioRepository.findByNombre(servicio.getNombre());
        if(servicioEncontrado.isPresent())
        {
            throw  new Exception("Servicio ya esta presente");
        }
        return true;
    }
}
