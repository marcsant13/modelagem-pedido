package com.marcos.modelagem_relacional.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String nome;
    private String email;
    private String password;
}
