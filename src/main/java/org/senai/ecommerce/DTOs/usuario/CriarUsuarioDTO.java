package org.senai.ecommerce.DTOs.usuario;

import lombok.Data;

@Data
public class CriarUsuarioDTO {

    private String nome;
    private String email;
    private String senha;
    private String permicao;

}
