package net.weg.topcar.controller;

import net.weg.topcar.model.automoveis.Carro;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.VeiculoExistenteException;
import net.weg.topcar.service.AutenticacaoService;
import net.weg.topcar.service.AutomovelService;

public class CarroController extends AutomovelController {


    public CarroController(AutenticacaoService autenticacaoService, AutomovelService automovelService) {
        super(autenticacaoService, automovelService);
    }

    public void cadastroCarro(String codigo, String marca, String modelo, Long ano, String tipoCombustivel, Double preco, String cor, Double quilometragem, String placa, boolean novo, String carroceria, String marcha) throws VeiculoExistenteException {
        isGerente();
        quilometragem = 0.0;
        placa = "";
        Carro novoAutomovel = new Carro(codigo, modelo, ano, marca, tipoCombustivel,
                preco, quilometragem, placa, cor, novo, marcha, carroceria);

        cadastroAutomovel(novoAutomovel);

    }

    public void editarCarro(String codigo, String marca, String modelo, Long ano, String tipoCombustivel, Double preco, String cor, Double quilometragem, String placa, boolean novo, String carroceria, String marcha) throws ObjetoNaoEncontradoException {
        isGerente();
        buscarAutomovel(codigo);
        quilometragem = 0.0;
        placa = "";
        Carro novoAutomovel = new Carro(codigo, modelo, ano, marca, tipoCombustivel,
                preco, quilometragem, placa, cor, novo, marcha, carroceria);

        editarAutomovel(novoAutomovel, codigo);

    }

}

