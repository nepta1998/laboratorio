package com.proyecto.laboratorio.Repository;

import com.proyecto.laboratorio.model.entity.Servicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio,Long> {

}
