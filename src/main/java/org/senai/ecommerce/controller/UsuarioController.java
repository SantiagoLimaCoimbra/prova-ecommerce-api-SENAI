package org.senai.ecommerce.controller;

import org.senai.ecommerce.DTOs.usuario.CriarUsuarioDTO;
import org.senai.ecommerce.entity.Usuario;
import org.senai.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody CriarUsuarioDTO data){
        try {
            Usuario user = service.criarUsuario(data);
            return new ResponseEntity(user, HttpStatus.CREATED);
        } catch (Exception exception){
            return new ResponseEntity<>("Erro na requisição", HttpStatus.BAD_REQUEST);
        }
    }

}
