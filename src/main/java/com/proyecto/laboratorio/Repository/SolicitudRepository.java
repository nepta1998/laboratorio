package com.proyecto.laboratorio.Repository;


import com.proyecto.laboratorio.model.entity.Solicitud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudRepository extends CrudRepository<Solicitud,Long> {

}
