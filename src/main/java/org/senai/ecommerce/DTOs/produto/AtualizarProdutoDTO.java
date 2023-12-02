package org.senai.ecommerce.DTOs.produto;

import lombok.Data;

@Data
public class AtualizarProdutoDTO {

    private Long codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;

}
