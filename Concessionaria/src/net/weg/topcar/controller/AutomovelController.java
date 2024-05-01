package net.weg.topcar.controller;

import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.PermissaoNegadaException;
import net.weg.topcar.model.exceptions.VeiculoExistenteException;
import net.weg.topcar.model.usuarios.IGerente;
import net.weg.topcar.model.usuarios.UsuarioAutenticadoBack;
import net.weg.topcar.service.AutenticacaoService;
import net.weg.topcar.service.AutomovelService;

import java.util.List;

public class AutomovelController {
    private final AutenticacaoService autenticacaoService;
    private final AutomovelService automovelService;

    public AutomovelController(AutenticacaoService autenticacaoService, AutomovelService automovelService) {
        this.autenticacaoService = autenticacaoService;
        this.automovelService = automovelService;
    }

    public List<Automovel> buscarAutomoveisDisponiveis() {
        List<Automovel> listaAutomoveisDisponiveis = automovelService.buscarAutomoveisDisponiveis();
        return listaAutomoveisDisponiveis;
    }

    public Automovel buscarAutomovel(String codigo) throws ObjetoNaoEncontradoException {
        Automovel automovel = automovelService.buscarUm(codigo);
        return automovel;
    }

    public void removerAutomovel(String codigo) throws ObjetoNaoEncontradoException {
        isGerente();
        automovelService.remover(codigo);
    }

    public void alterarPreco(String codigo, Double preco) throws ObjetoNaoEncontradoException {
        isGerente();
        automovelService.alterarPreco(codigo, preco);

    }

    protected void isGerente() throws PermissaoNegadaException {
        if (!(UsuarioAutenticadoBack.getUsuario() instanceof IGerente)) {
            throw new PermissaoNegadaException("o usuário não é um gerente");
        }
    }

    protected void cadastroAutomovel(Automovel automovel) throws VeiculoExistenteException {
        automovelService.adicionar(automovel);
    }

    public void editarAutomovel(Automovel automovel, String codigo) throws ObjetoNaoEncontradoException {
        automovelService.alterar(codigo,automovel);

    }

}
