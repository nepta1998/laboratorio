package com.proyecto.laboratorio.Repository;


import com.proyecto.laboratorio.model.entity.Fundacion;
import com.proyecto.laboratorio.model.entity.Solicitud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface SolicitudRepository extends CrudRepository<Solicitud,Long> {
    public Iterable<Solicitud>findByStatus(char status);
    public Iterable<Solicitud>findByFundacion(Fundacion fundacion);
    public  Iterable<Solicitud>findByFechaBetween(Date fecha1,Date fecha2);
    public  Iterable<Solicitud>findByFechaBetweenAndFundacion(Date fecha1,Date fecha2,Fundacion fundacion);
}
