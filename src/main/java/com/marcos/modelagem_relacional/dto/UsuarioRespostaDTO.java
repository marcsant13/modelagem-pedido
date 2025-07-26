package com.marcos.modelagem_relacional.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioRespostaDTO {
    private String nome;
    private String email;
    private List<String> codigosPedidos;
}
