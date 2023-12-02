package org.senai.ecommerce.service;

import org.senai.ecommerce.DTOs.usuario.CriarUsuarioDTO;
import org.senai.ecommerce.entity.Usuario;
import org.senai.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario criarUsuario(CriarUsuarioDTO data){
        Usuario usuario = new Usuario();
        usuario.setNome(data.getNome());
        usuario.setEmail(data.getEmail());
        usuario.setPermicao(data.getPermicao());

        String senhaEncripitada = passwordEncoder.encode(data.getSenha());
        usuario.setSenha(senhaEncripitada);

        return usuario;
    }

    public Optional<Usuario> pegarUsuarioAutenticado(String email){
        return  repository.findByEmail(email);
    }

}
