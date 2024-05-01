package net.weg.topcar.controller;

import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.UsuarioExistenteException;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.service.UsuarioService;

public class ClienteController extends UsuarioController{

    public ClienteController(UsuarioService usuarioService) {
        super(usuarioService);
    }

    public void cadastroCliente(String nome, Long cpf, String senha, Long idade) throws UsuarioExistenteException {
        Cliente cliente = new Cliente(nome, cpf, senha, idade);
        cadastroUsuario(cliente);
    }

    protected void editarCliente(String nome, Long cpf, String senha, Long idade) throws ObjetoNaoEncontradoException {
        isGerente();
        Cliente cliente = new Cliente(nome,cpf,senha,idade);
        editarUsuario(cliente);
    }

}
