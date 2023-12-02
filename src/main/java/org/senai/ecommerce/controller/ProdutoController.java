package org.senai.ecommerce.controller;
import org.senai.ecommerce.DTOs.produto.AtualizarProdutoDTO;
import org.senai.ecommerce.DTOs.produto.CriarProdutoDTO;
import org.senai.ecommerce.entity.Produto;
import org.senai.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<?> getProdutos() {
        List<Produto> lista = produtoService.getProdutos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> getProdutoPorCodigo(@PathVariable Long codigo) {
        Produto produto = produtoService.getProdutoPorCodigo(codigo);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> criarProduto(@RequestBody CriarProdutoDTO data) {
        Produto produto = produtoService.criarProduto(data);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> atualizarProduto(@RequestBody AtualizarProdutoDTO data) {
        var produto = produtoService.atualizarProduto(data);
        return new ResponseEntity<>("Produto atualizado!", HttpStatus.OK);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long codigo) {
        produtoService.excluirProduto(codigo);
        return new ResponseEntity<>("Produto Excluído do Sucesso!", HttpStatus.OK);
    }
}
