package com.proyecto.laboratorio.Service;


import com.proyecto.laboratorio.Repository.FundacionRepository;
import com.proyecto.laboratorio.model.entity.Fundacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
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
}
