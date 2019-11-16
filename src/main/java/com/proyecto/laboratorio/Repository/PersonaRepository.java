package com.proyecto.laboratorio.Repository;

import com.proyecto.laboratorio.model.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona,String> {
}
