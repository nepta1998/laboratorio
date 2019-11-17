package com.proyecto.laboratorio.Service;

import com.proyecto.laboratorio.model.entity.Gobernacion;

public interface GobernacionService {

    public Iterable<Gobernacion> getAllGobenaciones();
    public  Gobernacion getGobernacionById(String estado) throws Exception;
    public  Gobernacion updateGobernacion(Gobernacion gobernacion) throws Exception;
}
