package com.marcos.modelagem_relacional.servicos;

import com.marcos.modelagem_relacional.dto.ProdutoDTO;
import com.marcos.modelagem_relacional.entidades.Produto;
import com.marcos.modelagem_relacional.repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ServicoProduto {

    private final ProdutoRepositorio produtoRepositorio;

    public ServicoProduto(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    public Produto salvarProduto(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setCodigoDoProduto(produtoDTO.getCodigoDoProduto());
        produto.setPreco(produtoDTO.getPreco());
        return produtoRepositorio.save(produto);
    }
}
