package com.proyecto.laboratorio.Service;

import com.proyecto.laboratorio.model.entity.Empleado;

public interface EmpleadoService {
    public Iterable<Empleado> getAllEmpleados();
    public  Empleado createEmpleado(Empleado empleado) throws Exception;
    public  Empleado getEmpleadoById(String ced) throws Exception;
    public  Empleado updateServicio(Empleado empleado) throws Exception;
    public  void deleteEmpleado(String  ced) throws Exception;
}
