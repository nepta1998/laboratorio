package com.proyecto.laboratorio.Repository;

import com.proyecto.laboratorio.model.entity.Fundacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FundacionRepository extends CrudRepository<Fundacion,Long> {

    public Optional<Fundacion> findByNombre(String nombre);
}
