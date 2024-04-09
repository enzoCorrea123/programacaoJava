package net.weg.topcar.view;

import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.automoveis.Carro;
import net.weg.topcar.model.automoveis.Moto;
import net.weg.topcar.model.automoveis.Quadriciclo;
import net.weg.topcar.model.exceptions.AutomovelExistenteException;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.PermissaoNegadasException;

public class FormularioCadastroAutomovel extends FormularioAutomovel{
    public void cadastroAutomovel() {
        try {
            isGerente();
            String codigo = entradaCodigo();
            Automovel automovel = automovelService.buscarUm(codigo);
            String modelo = entradaModelo();
            Long ano = entradaAno();
            String marca = entradaMarca();
            String tipoCombustivel = entradaCombustivel();
            Double preco = entradaPreco();
            Boolean novo = entradaNovo();
            Double quilometragem = 0.0;
            String placa = "";
            if (!novo) {
                quilometragem = entradaQuilometragem();
                placa = entradaPlaca();
            }
            String cor = entradaCor();
            Long tipo = selecionaTipoAutomovel();
            Automovel automovelNovo;
            if (tipo == 1) {
                String carroceria = entradaCarroceria();
                String marcha = entradaMarcha();
                automovelNovo = new Carro(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, novo, marcha, carroceria);
            } else if (tipo == 2) {
                Long cilindradas = entradaCilindradas();
                String partida = entradaPartida();
                automovelNovo = new Moto(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, novo, partida, cilindradas);
            } else {
                automovelNovo = new Quadriciclo(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, novo);
            }
            automovelService.adicionar(automovelNovo);
        } catch (PermissaoNegadasException | ObjetoNaoEncontradoException | AutomovelExistenteException e) {
            saida.escreva(e.getMessage());
        }
    }


}
