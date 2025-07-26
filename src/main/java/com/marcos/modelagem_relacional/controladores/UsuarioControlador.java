package com.marcos.modelagem_relacional.controladores;

import com.marcos.modelagem_relacional.dto.UsuarioDTO;
import com.marcos.modelagem_relacional.dto.UsuarioRespostaDTO;
import com.marcos.modelagem_relacional.entidades.Usuario;
import com.marcos.modelagem_relacional.servicos.ServicoUsuario;
import jakarta.servlet.http.PushBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
    private final ServicoUsuario servicoUsuario;

    public UsuarioControlador(ServicoUsuario servicoUsuario) {
        this.servicoUsuario = servicoUsuario;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        var usuarioSalvo = servicoUsuario.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRespostaDTO> retornarUsuario(@PathVariable Long id){
        var usuario = servicoUsuario.retornarUsuario(id);
        return ResponseEntity.ok(usuario);
    }

}
