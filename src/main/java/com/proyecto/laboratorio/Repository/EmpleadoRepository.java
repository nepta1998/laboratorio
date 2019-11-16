package com.proyecto.laboratorio.Repository;


import com.proyecto.laboratorio.model.entity.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado,String> {

}
