package net.weg.topcar.controller;

import net.weg.topcar.dao.BancoAutomoveis;
import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.automoveis.Carro;
import net.weg.topcar.model.automoveis.Moto;
import net.weg.topcar.model.automoveis.Quadriciclo;
import net.weg.topcar.model.exceptions.AutomovelExistenteException;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.PermissaoNegadasException;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.model.usuarios.IGerente;
import net.weg.topcar.service.AutomovelService;
import net.weg.topcar.view.*;

import java.util.List;

public class AutomovelController {
    public static Cliente usuarioLogado = null;
    private final IBanco<Automovel, String> bancoAutomovel;
    protected final Saida saida = new Saida();

    private final AutomovelService automovelService = new AutomovelService();
    public AutomovelController(BancoAutomoveis bancoAutomoveis) {
        this.bancoAutomovel = bancoAutomoveis;
    }

    public void verAutomoveis() {
        List<Automovel> automoveisDisponiveis = automovelService.buscarAutomoveisDisponiveis();
        automoveisDisponiveis.forEach(automovel -> saida.escrevaln(automovel.toString()));
    }

    public void verAutomovel() {
        try {
            String codigo = entradaCodigo();
            Automovel automovel = automovelService.buscarUm(codigo);
            saida.escreva(automovel.toString());
        } catch (ObjetoNaoEncontradoException e) {
            saida.escrevaln(e.getMessage());
        }
    }

    public void removerAutomovel() {
        try {
            isGerente();
            String codigo = entradaCodigo();
            automovelService.remover(codigo);
        } catch (ObjetoNaoEncontradoException | PermissaoNegadasException e) {
            saida.escreva(e.getMessage());
        }
    }

    public void alterarPreco() {
        try {
            isGerente();
            String codigo = entradaCodigo();
            Automovel automovel = automovelService.buscarUm(codigo);
            Double preco = entradaPreco();
            automovelService.alterarPreco(codigo, preco);

        } catch (ObjetoNaoEncontradoException | PermissaoNegadasException e) {
            saida.escreva(e.getMessage());
        }
    }

    public void editarAutomovel() {
        try {
            isGerente();
            Automovel automovel = buscarAutomovel();
            String modelo = entradaModelo(automovel.getModelo());
            Long ano = entradaAno(automovel.getAno());
            String marca = entradaMarca(automovel.getMarca());
            String tipoCombustivel = entradaCombustivel(automovel.getTipoCombustivel());
            Double preco = entradaPreco(automovel.getPreco());
            String cor = entradaCor(automovel.getCor());
            Boolean novo = entradaNovo();
            Double quilometragem = 0.0;
            String placa = "";
            if (!novo) {
                quilometragem = entradaQuilometragem(automovel.getQuilometragem());
                placa = entradaPlaca(automovel.getPlaca());
            }
            String codigo = automovel.getCODIGO();
            Automovel automovelEditado;
            if (automovel instanceof Carro carro) {
                String carroceria = entradaCarroceria(carro.getTipoCarroceria());
                String marcha = entradaMarcha(carro.getMarcha());
                automovelEditado = new Carro(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, novo, marcha, carroceria);
            } else if (automovel instanceof Moto moto) {
                Long cilindradas = entradaCilindradas(moto.getCilindradas());
                String partida = entradaPartida(moto.getPartida());
                automovelEditado = new Moto(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, novo, partida, cilindradas);
            } else {
                automovelEditado = new Quadriciclo(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, novo);
            }
            automovelService.alterar(codigo, automovelEditado);
        } catch (ObjetoNaoEncontradoException | PermissaoNegadasException e) {
            saida.escreva(e.getMessage());
        }
    }

    private Automovel buscarAutomovel() throws ObjetoNaoEncontradoException {
        String codigo = entradaCodigo();
        return bancoAutomovel.buscarUm(codigo);
    }

    private Long selecionaTipoAutomovel() {
        Long entrada;
        do {
            entrada = entradaInteiro.leiaComSaidaEValidacao("""
                    Qual o tipo de veiculo 
                    1 - Carro
                    2 - Moto
                    3 - Quadriciculo""", saida);
        } while (entrada > 3);
        return entrada;
    }




    private void isGerente() {
        if (!(usuarioLogado instanceof IGerente)) {
            throw new PermissaoNegadasException("Usuário não é um gerente");
        }
    }



}
