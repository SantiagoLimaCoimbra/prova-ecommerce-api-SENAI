package org.senai.ecommerce.service;

import org.senai.ecommerce.DTOs.produto.AtualizarProdutoDTO;
import org.senai.ecommerce.DTOs.produto.CriarProdutoDTO;
import org.senai.ecommerce.entity.Produto;
import org.senai.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService{

    @Autowired
    private ProdutoRepository repository;

    //PEGAR TODOS
    public List<Produto> getProdutos() {
        return repository.findAll();
    }

    //PEGAR APENAS UM
    public Produto getProdutoPorCodigo(Long codigo) {
        Produto produto = repository.findById(codigo).get();
        return produto;
    }

    //CRIAR PRODUTO
    public Produto criarProduto(CriarProdutoDTO data) {
        Produto produto = new Produto();
        produto.setNome(data.getNome());
        produto.setDescricao(data.getDescricao());
        produto.setPreco(data.getPreco());
        produto.setEstoque(data.getEstoque());

        repository.save(produto);
        return produto;
    }

    //ATUALIZAR PRODUTO
    public Produto atualizarProduto(AtualizarProdutoDTO data) {
        var produto = repository.getReferenceById(data.getCodigo());

        if(data.getNome() != null){
            produto.setNome(data.getNome());
        }
        if(data.getDescricao() != null){
            produto.setDescricao(data.getDescricao());
        }
        if(data.getPreco() != data.getPreco()){
            produto.setPreco(data.getPreco());
        }
        if (data.getEstoque() != data.getEstoque()){
            produto.setEstoque(data.getEstoque());
        }

        repository.save(produto);
        return produto;
    }

    //DELETAR PRODUTO
    public void excluirProduto(Long codigo) {
        repository.deleteById(codigo);
    }
}
