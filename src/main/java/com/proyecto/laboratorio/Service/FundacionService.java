package com.proyecto.laboratorio.Service;

import com.proyecto.laboratorio.model.entity.Fundacion;

import java.util.List;

public interface FundacionService {
    public Iterable<Fundacion> getAllFundaciones();
    public  Fundacion getFundacionByNombre(String nombre) throws Exception;
    public  Fundacion getFundacionById(Long id) throws Exception;
    public Fundacion updateFundacion(Fundacion funcdacion) throws Exception;

}
