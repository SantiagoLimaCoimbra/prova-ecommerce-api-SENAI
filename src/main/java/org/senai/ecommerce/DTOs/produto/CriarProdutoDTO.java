package org.senai.ecommerce.DTOs.produto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CriarProdutoDTO {

    private String nome;
    private String descricao;
    private double preco;
    private int estoque;

}
