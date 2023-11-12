package com.catcare.project.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.catcare.project.Entity.Administrador;
import com.catcare.project.Entity.Cliente;
import com.catcare.project.Entity.Role;
import com.catcare.project.Entity.UserEntity;
import com.catcare.project.Entity.Veterinario;
import com.catcare.project.Repository.RoleRepository;
import com.catcare.project.Repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired 
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userDB = userRepository.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("User not found")
        );

        UserDetails userDetails = new User(userDB.getUsername(),
        userDB.getPassword(),
         mapRolesToAuthorities(userDB.getRoles()));

         return userDetails;
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public UserEntity AdministradorToUser(Administrador administrador){
        UserEntity user = new UserEntity();
        user.setUsername(administrador.getCedula());
        user.setPassword(passwordEncoder.encode("123"));

        Role roles  = roleRepository.findByName("ADMINISTRADOR").get();
        user.setRoles(List.of(roles));
        return user;
    }

    public UserEntity VeterinarioToUser(Veterinario veterinario){
        UserEntity user = new UserEntity();
        user.setUsername(veterinario.getCedula()); 
        user.setPassword(passwordEncoder.encode("123"));
    

        Role roles  = roleRepository.findByName("VETERINARIO").get();
        user.setRoles(List.of(roles));
        return user;
    }

    public UserEntity ClienteToUser(Cliente cliente){
        UserEntity user = new UserEntity();
        user.setUsername(cliente.getCedula()); 
        user.setPassword(passwordEncoder.encode("123"));
    

        Role roles  = roleRepository.findByName("CLIENTE").get();
        user.setRoles(List.of(roles));
        return user;
    }
    

}
