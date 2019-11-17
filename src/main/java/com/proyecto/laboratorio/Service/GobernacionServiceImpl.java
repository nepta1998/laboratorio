package com.proyecto.laboratorio.Service;

import com.proyecto.laboratorio.Repository.GobernacionRepository;
import com.proyecto.laboratorio.model.entity.Gobernacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GobernacionServiceImpl implements GobernacionService {

    @Autowired
    GobernacionRepository gobernacionRepository;
    @Override
    public Iterable<Gobernacion> getAllGobenaciones() {
        return gobernacionRepository.findAll();
    }

    @Override
    public Gobernacion getGobernacionById(String estado) throws Exception {
        return gobernacionRepository.findById(estado).orElseThrow(() -> new  Exception("la fgobernacion no existe"));
    }

    @Override
    public Gobernacion updateGobernacion(Gobernacion gobernacion) throws Exception {
        Gobernacion encontrarGobernacion=getGobernacionById(gobernacion.getEstado());
        mapGobernacion(gobernacion,encontrarGobernacion);
        return gobernacionRepository.save(encontrarGobernacion);
    }

    protected void mapGobernacion(Gobernacion from,Gobernacion to){
        to.setEstado(from.getEstado());
        to.setFundacion(from.getFundacion());
        to.setPartidaAnual(from.getPartidaAnual());
    }


    private boolean verificarGobernacionExiste(Gobernacion gobernacion) throws Exception {
        Optional<Gobernacion> gobernacionEncontrado=gobernacionRepository.findById(gobernacion.getEstado());
        if(gobernacionEncontrado.isPresent())
        {
            throw  new Exception("gobernacion ya esta presente");
        }
        return true;
    }
}
