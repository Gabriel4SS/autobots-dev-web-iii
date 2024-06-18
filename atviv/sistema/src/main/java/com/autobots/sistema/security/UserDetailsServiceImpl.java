package com.autobots.sistema.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autobots.sistema.entities.Usuario;
import com.autobots.sistema.repositories.UsuarioRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

    final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl (UsuarioRepository usuarioRepository){
    this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
       Usuario usuario = usuarioRepository.findByUserEmail(userEmail)
       .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + userEmail));
       return new User(usuario.getUsername(), usuario.getPassword(), 
       true, true, true, true, usuario.getAuthorities());
    }
    
}
