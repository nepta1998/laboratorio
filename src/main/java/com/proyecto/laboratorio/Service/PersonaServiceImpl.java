package com.proyecto.laboratorio.Service;

import com.proyecto.laboratorio.Repository.PersonaRepository;
import com.proyecto.laboratorio.model.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;
    @Override
    public Iterable<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona createPersona(Persona persona) throws Exception {
        if(verificarPersonaExiste(persona))
        {
            persona= personaRepository.save(persona);
        }
        return persona;
    }

    @Override
    public Persona getPersonaById(String ced) throws Exception {
        return personaRepository.findById(ced).orElseThrow(() -> new  Exception("la persona no existe"));
    }

    @Override
    public Persona updatePersona(Persona persona) throws Exception {
        Persona encontrarPersona=getPersonaById(persona.getCedula());
        mapPersona(persona,encontrarPersona);
        return personaRepository.save(encontrarPersona);
    }

    @Override
    public void deletePersona(String ced) throws Exception {
        Persona persona=getPersonaById(ced);
        personaRepository.delete(persona);
    }

    protected void mapPersona(Persona from,Persona to){
        to.setNombre(from.getNombre());
        to.setSexo(from.getSexo());
        to.setEdad(from.getEdad());
        to.setTelefono(from.getTelefono());
    }


    private boolean verificarPersonaExiste(Persona persona) throws Exception {
        Optional<Persona> personaEncontrada=personaRepository.findById(persona.getCedula());
        if(personaEncontrada.isPresent())
        {
            throw  new Exception("persona ya esta presente");
        }
        return true;
    }
}
