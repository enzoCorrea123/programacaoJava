package net.weg.topcar.controller;

import net.weg.topcar.model.automoveis.Moto;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.VeiculoExistenteException;
import net.weg.topcar.service.AutenticacaoService;
import net.weg.topcar.service.AutomovelService;

public class MotoController extends AutomovelController{

    public MotoController(AutenticacaoService autenticacaoService, AutomovelService automovelService) {
        super(autenticacaoService, automovelService);
    }

    public void CadastroMoto(String codigo, String marca, String modelo, Long ano, String tipoCombustivel, Double preco, String cor, boolean novo, Double quilometragem, String placa, Long cilindradas, String partida) throws VeiculoExistenteException {
        isGerente();
        Moto novoAutomovel = new Moto(codigo, modelo, ano, marca, tipoCombustivel,
                preco, quilometragem, placa, cor, novo, partida, cilindradas);
        cadastroAutomovel(novoAutomovel);
    }
    public void editarMoto(String codigo, String marca, String modelo, Long ano, String tipoCombustivel, Double preco, String cor, boolean novo, Double quilometragem, String placa, Long cilindradas, String partida) throws ObjetoNaoEncontradoException {
        isGerente();
        buscarAutomovel(codigo);
        Moto novoAutomovel = new Moto(codigo, modelo, ano, marca, tipoCombustivel,
                preco, quilometragem, placa, cor, novo, partida, cilindradas);
        editarAutomovel(novoAutomovel, codigo);
    }
}
