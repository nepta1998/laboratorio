package com.proyecto.laboratorio.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.proyecto.laboratorio.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proyecto.laboratorio.model.entity.Role;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Buscar nombre de usuario en nuestra base de datos
        com.proyecto.laboratorio.model.entity.User appUser =
                userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User does not exist!"));

       // Set grantList = new HashSet();
        Set<GrantedAuthority> grantList = new HashSet<>();
        //Crear la lista de los roles/accessos que tienen el usuarios
        for (Role role: appUser.getRoles()) {
            //List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            grantList.add(grantedAuthority);
        }

        //Crear y retornar Objeto de usuario soportado por Spring Security
      //  UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
        //return user;
        return new User(appUser.getUsername(), appUser.getPassword(), grantList);

    }


}
