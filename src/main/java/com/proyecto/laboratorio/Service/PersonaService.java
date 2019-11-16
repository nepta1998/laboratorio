package com.proyecto.laboratorio.Service;

import com.proyecto.laboratorio.model.entity.Persona;

public interface PersonaService {

    public Iterable<Persona> getAllPersonas();
    public  Persona createPersona(Persona persona) throws Exception;
    public  Persona getPersonaById(String ced) throws Exception;
    public  Persona updatePersona(Persona persona) throws Exception;
    public  void deletePersona(String  ced) throws Exception;
}
