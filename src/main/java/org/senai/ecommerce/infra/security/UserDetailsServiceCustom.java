package org.senai.ecommerce.infra.security;

import org.senai.ecommerce.entity.Usuario;
import org.senai.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    @Autowired
    UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = service.pegarUsuarioAutenticado(username);

        if(!usuario.isPresent())
            new UsernameNotFoundException("Usuário não encontrado");

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.get().getPermicao());
        Set<GrantedAuthority> authorities = new HashSet();
        authorities.add(authority);

        User user = new User(usuario.get().getEmail(), usuario.get().getSenha(), authorities);
        return user;
    }

}
