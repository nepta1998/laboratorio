package com.proyecto.laboratorio.Service;

import javax.validation.Valid;

import com.proyecto.laboratorio.model.entity.Empleado;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//import com.cristianRuizBlog.aplicacion.Exception.UsernameOrIdNotFound;
//import com.cristianRuizBlog.aplicacion.dto.ChangePasswordForm;
import com.proyecto.laboratorio.model.entity.User;

public interface UserService {

    public Iterable<User> getAllUsers();

    public User createUser(User user) throws Exception;

    //public User getUserById(Long id) throws Exception;

   // public User updateUser(User user) throws Exception;

//    public void deleteUser(Long id) throws UsernameOrIdNotFound;

//    public User changePassword(ChangePasswordForm form) throws Exception;
}