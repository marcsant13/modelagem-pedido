package com.marcos.modelagem_relacional.servicos;

import com.marcos.modelagem_relacional.dto.UsuarioDTO;
import com.marcos.modelagem_relacional.dto.UsuarioRespostaDTO;
import com.marcos.modelagem_relacional.entidades.Pedido;
import com.marcos.modelagem_relacional.entidades.Usuario;
import com.marcos.modelagem_relacional.repositorios.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoUsuario {

    private final UsuarioRepositorio usuarioRepositorio;

    public ServicoUsuario(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario salvarUsuario(UsuarioDTO usuarioDTO){

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());

        return usuarioRepositorio.save(usuario);
    }

    public UsuarioRespostaDTO retornarUsuario(Long id){
        var usuario = usuarioRepositorio.findById(id).orElseThrow();
        UsuarioRespostaDTO usuarioRespostaDTO = new UsuarioRespostaDTO();
        usuarioRespostaDTO.setNome(usuario.getNome());
        usuarioRespostaDTO.setEmail(usuario.getEmail());
        List<String> codigosPedido = new ArrayList<>();
        for (Pedido pedido: usuario.getPedidos()){
            codigosPedido.add(pedido.getCodigoPedido());
        }
        usuarioRespostaDTO.setCodigosPedidos(codigosPedido);
        return usuarioRespostaDTO;
    }
}
