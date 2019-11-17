package com.proyecto.laboratorio.Repository;

import com.proyecto.laboratorio.model.entity.Gobernacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GobernacionRepository extends CrudRepository<Gobernacion,String> {
}
