package com.proyecto.laboratorio.Service;

import java.util.Optional;

import javax.validation.Valid;

import com.proyecto.laboratorio.model.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.laboratorio.exception.CustomFieldValidationException;
//import com.cristianRuizBlog.aplicacion.Exception.UsernameOrIdNotFound;
//import com.cristianRuizBlog.aplicacion.dto.ChangePasswordForm;
import com.proyecto.laboratorio.model.entity.User;
import com.proyecto.laboratorio.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

   //@Autowired
   //BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    PasswordEncoder passwordEncoder;

    public EmpleadoServiceImpl employee;

    @Override
    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

     private boolean checkUsernameAvailable(User user) throws Exception {
        Optional<User> userFound = repository.findByUsername(user.getUsername());
        if (userFound.isPresent()) {
            throw new CustomFieldValidationException("Username no disponible","username");
        }
        return true;
    }

   /* private boolean checkPasswordValid(User user) throws Exception {
        if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
            throw new CustomFieldValidationException("Confirm Password es obligatorio","confirmPassword");
        }

        if ( !user.getPassword().equals(user.getConfirmPassword())) {
            throw new CustomFieldValidationException("Password y Confirm Password no son iguales","password");
        }
        return true;
    }*/


  /* @Override
    public User createUser(User user) throws Exception {
        if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
            String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            user = repository.save(user);
        }
        return user;
    }*/

    @Override
    public User createUser(User user) throws Exception {

          // String encodedPassword = passwordEncoder.encode(user.getPassword());
            //user.setPassword(encodedPassword);

          //  String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
           // user.setPassword(encodedPassword);
            //String test = user.getPassword();
            //user.setPassword(test);

            String encodedPassword = passwordEncoder.encode(user.getPassword());

            user.setPassword(encodedPassword);
            user = repository.save(user);

        return user;
    }


    /*@Override
    public User getUserById(Long id) throws UsernameOrIdNotFound {
        return repository.findById(id).orElseThrow(() -> new UsernameOrIdNotFound("El Id del usuario no existe."));
    }

    @Override
    public User updateUser(User fromUser) throws Exception {
        User toUser = getUserById(fromUser.getId());
        mapUser(fromUser, toUser);
        return repository.save(toUser);
    }*/

    /**
     * Map everything but the password.
     * @param from
     * @param to
     */


    protected void mapUser(User from,User to) {
        to.setUsername(from.getUsername());
        to.setRoles(from.getRoles());
    }

    /*
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteUser(Long id) throws UsernameOrIdNotFound {
        User user = getUserById(id);
        repository.delete(user);
    }



    @Override
    public User changePassword(ChangePasswordForm form) throws Exception {
        User user = getUserById(form.getId());

        if ( !isLoggedUserADMIN() && !user.getPassword().equals(form.getCurrentPassword())) {
            throw new Exception ("Current Password invalido.");
        }

        if( user.getPassword().equals(form.getNewPassword())) {
            throw new Exception ("Nuevo debe ser diferente al password actual.");
        }

        if( !form.getNewPassword().equals(form.getConfirmPassword())) {
            throw new Exception ("Nuevo Password y Confirm Password no coinciden.");
        }

        String encodePassword = bCryptPasswordEncoder.encode(form.getNewPassword());
        user.setPassword(encodePassword);
        return repository.save(user);
    }*/

    private boolean isLoggedUserADMIN() {
        //Obtener el usuario logeado
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserDetails loggedUser = null;
        Object roles = null;

        //Verificar que ese objeto traido de sesion es el usuario
        if (principal instanceof UserDetails) {
            loggedUser = (UserDetails) principal;

            roles = loggedUser.getAuthorities().stream()
                    .filter(x -> "ROLE_ADMIN".equals(x.getAuthority())).findFirst()
                    .orElse(null);
        }
        return roles != null ? true : false;
    }

    private User getLoggedUser() throws Exception {
        //Obtener el usuario logeado
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserDetails loggedUser = null;

        //Verificar que ese objeto traido de sesion es el usuario
        if (principal instanceof UserDetails) {
            loggedUser = (UserDetails) principal;
        }

        User myUser = repository
                .findByUsername(loggedUser.getUsername()).orElseThrow(() -> new Exception("Error obteniendo el usuario logeado desde la sesion."));

        return myUser;
    }
}
