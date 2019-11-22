package com.proyecto.laboratorio.Service;

import com.proyecto.laboratorio.Repository.EmpleadoRepository;
import com.proyecto.laboratorio.model.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    EmpleadoRepository empleadoRepository;
    @Override
    public Iterable<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado createEmpleado(Empleado empleado) throws Exception {
        if(verificarEmpleadoExiste(empleado))
        {
            empleado= empleadoRepository.save(empleado);
        }
        return empleado;
    }

    @Override
    public Empleado getEmpleadoById(String ced) throws Exception {
        return empleadoRepository.findById(ced).orElseThrow(() -> new  Exception("El empleado no existe"));
    }

    @Override
    public Empleado updateEmpleado(Empleado empleado) throws Exception {
        Empleado encontrarEmpleado=getEmpleadoById(empleado.getCedula());
        mapEmpleado(empleado,encontrarEmpleado);
        return empleadoRepository.save(encontrarEmpleado);
    }

    @Override
    public void deleteEmpleado(String ced) throws Exception {
       Empleado empleado=getEmpleadoById(ced);
        empleadoRepository.delete(empleado);
    }

    protected void mapEmpleado(Empleado from,Empleado to){
        to.setNombre(from.getNombre());
        to.setSexo(from.getSexo());
        to.setEdad(from.getEdad());
        to.setContraseña(from.getContraseña());
        to.setTelefono(from.getTelefono());
        to.setFundacion(from.getFundacion());
    }


    public boolean verificarEmpleadoExiste(Empleado Empledo) throws Exception {
        Optional<Empleado> servicioEncontrado=empleadoRepository.findById(Empledo.getCedula());
        if(servicioEncontrado.isPresent())
        {
            throw  new Exception("Empleado ya esta presente");
        }
        return true;
    }
}
