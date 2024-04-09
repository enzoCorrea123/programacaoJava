package net.weg.topcar.service;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.usuarios.Cliente;

public class UsuarioService {
    IBanco<Cliente, Long> usuarioBanco;
    public Cliente adicionar(Cliente cliente){
        return usuarioBanco.adicionar(cliente);
    }
}
