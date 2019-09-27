package com.proyecto.laboratorio.Repository;

import com.proyecto.laboratorio.model.entity.Servicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio,Long> {

   public  Optional<Servicio> findByNombre(String nombre);
}
