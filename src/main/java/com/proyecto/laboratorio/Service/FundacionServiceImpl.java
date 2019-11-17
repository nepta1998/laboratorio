package com.proyecto.laboratorio.Service;


import com.proyecto.laboratorio.Repository.FundacionRepository;
import com.proyecto.laboratorio.model.entity.Fundacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class FundacionServiceImpl implements FundacionService {

    @Autowired
    FundacionRepository fundacionRepository;
    @Override
    public Iterable<Fundacion> getAllFundaciones() {
        return fundacionRepository.findAll();
    }

    @Override
    public Fundacion getFundacionByNombre(String nombre) throws Exception {
        return fundacionRepository.findByNombre(nombre).orElseThrow(() -> new  Exception("la fundacion no existe"));
    }

    @Override
    public Fundacion getFundacionById(Long id) throws Exception {
        return fundacionRepository.findById(id).orElseThrow(() -> new  Exception("la fundacion no existe"));
    }

    @Override
    public Fundacion updateFundacion(Fundacion funcdacion) throws Exception {
        Fundacion encontrarFundacion=getFundacionById(funcdacion.getId());
        mapFundacion(funcdacion,encontrarFundacion);
        return fundacionRepository.save(encontrarFundacion);
    }

    protected void mapFundacion(Fundacion from, Fundacion to){
        to.setNombre(from.getNombre());
        to.setGobernacion(from.getGobernacion());
        to.setPorcentaje(from.getPorcentaje());
    }


    private boolean verificarFundacionExiste(Fundacion fundacion) throws Exception {
        Optional<Fundacion> servicioEncontrado=fundacionRepository.findById(fundacion.getId());
        if(servicioEncontrado.isPresent())
        {
            throw  new Exception("Fundacion ya esta presente");
        }
        return true;
    }
}
