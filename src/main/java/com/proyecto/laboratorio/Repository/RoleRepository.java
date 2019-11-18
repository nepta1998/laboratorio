package com.proyecto.laboratorio.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.laboratorio.model.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

    public Role findByName(String role);
}