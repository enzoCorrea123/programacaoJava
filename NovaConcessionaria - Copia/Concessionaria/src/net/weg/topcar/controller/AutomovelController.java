package net.weg.topcar.controller;

import net.weg.topcar.dao.BancoAutomoveis;
import net.weg.topcar.dao.BancoCliente;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.automoveis.Carro;
import net.weg.topcar.model.automoveis.Moto;
import net.weg.topcar.model.automoveis.Quadriciclo;
import net.weg.topcar.model.exceptions.AcessoNegadoException;
import net.weg.topcar.model.exceptions.AutomovelNaoExistenteException;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.model.usuarios.IGerente;
import net.weg.topcar.view.*;

import java.util.ArrayList;
import java.util.List;

public class AutomovelController {
    private static Cliente usuarioLogado;
    private final Entrada<Double> entradaDecimal = new EntradaDecimal();
    private final Entrada<Long> entradaInteiro = new EntradaInteiro();
    private final Entrada<String> entradaTexto = new EntradaTexto();

    private final Saida saida = new Saida();
    BancoCliente bancoUsuario = new BancoCliente();
    BancoAutomoveis bancoAutomoveis = new BancoAutomoveis();

    public void verAutomoveis() {
        List<Automovel> listaAutomovel = bancoAutomoveis.buscarTodos();
        List<Automovel> listaAutomovelDisponiveis = filtrarAutomoveisDisponiveis(listaAutomovel);
        for (Automovel automovel : listaAutomovel) {
            saida.escreva(automovel.toString());
        }
    }

    public void alterarPreco() {
        try {
            isGerente();
            String codigo = entradaCodigo();
            Automovel automovel = bancoAutomoveis.buscarUm(codigo);
            Double preco = entradaPreco(automovel.getPreco());
            automovel.setPreco(preco);
            bancoAutomoveis.alterar(automovel.getCODIGO(), automovel);
        } catch (ObjetoNaoEncontradoException | AcessoNegadoException e) {
            saida.escreva(e.getMessage());
        }
    }

    public void removerAutomovel() {
        try {
            isGerente();
            String codigo = entradaCodigo();
            bancoAutomoveis.remover(codigo);
        } catch (ObjetoNaoEncontradoException | AcessoNegadoException e) {
            saida.escreva(e.getMessage());
        }
    }


    public void verAutomovel() {
        String codigo = entradaCodigo();
        try {
            Automovel automovel = bancoAutomoveis.buscarUm(codigo);
            saida.escreva(automovel.toString());
        } catch (ObjetoNaoEncontradoException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastroAutomovel() {
        try {
            isGerente();
            String codigo = entradaCodigo();
            validaCodigo(codigo);
            String modelo = entradaModelo();
            Long ano = entradaAno();
            String marca = entradaMarca();
            String tipoCombustivel = entradaTipoCombustivel();
            double preco = entradaPreco();
            double quilometragem = entradaQuilometragem();
            String placa = entradaPlaca();
            String cor = entradaCor();
            String estado = entradaEstado();
            boolean novo = entradaNovo();
            Long tipo = selecionaTipoDeAutomovel();
            switch (tipo.intValue()){
                case 1->{
                    String carroceria = entradaCarroceria();
                    String marcha = entradaMarcha();

                    cadastroCarro(codigo,modelo,ano,marca,tipoCombustivel,preco,quilometragem,placa,cor,carroceria,marcha,carroceria);
                }
                case 2 -> {
                    String partida = entradaPartida();
                    Long cilindradas = entradaCilindradas();
                    cadastroMoto(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, codigo, partida, cilindradas);
                }
                case 3 -> cadastroQuadriciclo(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, estado);

            }


        } catch (AutomovelNaoExistenteException e) {
            saida.escreva(e.getMessage());
        }
    }

    private void cadastroCarro(String CODIGO, String modelo, Long ano, String marca, String tipoCombustivel, double preco, double quilometragem, String placa, String cor, String estado, String marcha, String tipoCarroceria){
        Carro carro = new Carro(CODIGO,modelo,ano,marca,tipoCombustivel, preco, quilometragem, placa, cor, estado, marcha, tipoCarroceria);
        bancoAutomoveis.adicionar(carro);
    }
    private void cadastroMoto(String CODIGO, String modelo, Long ano, String marca, String tipoCombustivel, double preco, double quilometragem, String placa, String cor, String estado, String partida, Long cilindradas){
        Moto moto = new Moto(CODIGO, modelo, ano, marca, tipoCombustivel, preco,quilometragem, placa, cor, estado, partida, cilindradas);
        bancoAutomoveis.adicionar(moto);
    }

    private void cadastroQuadriciclo(String CODIGO, String modelo, Long ano, String marca, String tipoCombustivel, double preco, double quilometragem, String placa, String cor, String estado){
        Quadriciclo quadriciclo = new Quadriciclo(CODIGO, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, estado);
        bancoAutomoveis.adicionar(quadriciclo);
    }
    private String entradaMarcha(){
        return entradaTexto.leiaComSaidaEValidacao("Marcha: ",saida);
    }
    private String entradaCarroceria(){
        return entradaTexto.leiaComSaidaEValidacao("Carroceria: ",saida);
    }
    private String entradaPartida(){
        return entradaTexto.leiaComSaidaEValidacao("Partida: ",saida);
    }
    private Long entradaCilindradas(){
        return entradaInteiro.leiaComSaidaEValidacao("Cilindrada:",saida);
    }
    private String entradaEstado(){
        return entradaTexto.leiaComSaidaEValidacao("Estado: ",saida);
    }
    private Long selecionaTipoDeAutomovel(){
        Long entrada;
        do{
            entrada = entradaInteiro.leiaComSaidaEValidacao("Qual o tipo do automovel?\n1 - carro\n2 - moto\n3 - Quadriciclo",saida);

        }while (entrada > 3);
        return entrada;
    }

    private boolean entradaNovo(){
        Long entrada;
        do{
            entrada = entradaInteiro.leiaComSaidaEValidacao("Automóvel novo?\n1-sim\n2-não",saida);

        }while (entrada>2);
        return entrada == 1;
    }


    private void validaCodigo(String codigo) throws AutomovelNaoExistenteException {
        if(bancoAutomoveis.existe(codigo)){
            throw new AutomovelNaoExistenteException(codigo);
        }
    }
    private Long entradaAno(){
        return entradaInteiro.leiaComSaida("Modelo: ", saida);
    }
    private Double entradaQuilometragem(){
        return entradaDecimal.leiaComSaida("Quilometragem: ", saida);
    }

    private Double entradaPreco(){
        return entradaDecimal.leiaComSaidaEValidacao("Preço: ", saida);
    }
    private String entradaModelo() {
        return entradaTexto.leiaComSaida("Modelo: ", saida);
    }

    private String entradaTipoCombustivel() {
        return entradaTexto.leiaComSaida("Combustivel: ", saida);
    }

    private String entradaCor() {
        return entradaTexto.leiaComSaida("Cor: ", saida);
    }

    private String entradaPlaca() {
        return entradaTexto.leiaComSaida("Placa: ", saida);
    }

    private String entradaMarca() {
        return entradaTexto.leiaComSaida("Marca: ", saida);
    }

    private Double entradaPreco(Double precoAntigo) {
        Double novoPreco = entradaDecimal.leiaComSaidaEValidacao("Preço: ", saida);
        if (novoPreco <= 0) {
            novoPreco = precoAntigo;
        }
        return novoPreco;
    }

    private void isGerente() {
        if (!(usuarioLogado instanceof IGerente)) {
            throw new AcessoNegadoException();
        }
    }

    private List<Automovel> filtrarAutomoveisDisponiveis(List<Automovel> listaAutomovel) {
        List<Automovel> listaAutomovelDisponiveis = new ArrayList<>();
        for (Automovel automovel : listaAutomovel) {
            if (!automovel.isComprado()) {
                listaAutomovelDisponiveis.add(automovel);
            }
        }
        return listaAutomovelDisponiveis;
    }

    private String entradaCodigo() {
        return entradaTexto.leiaComSaidaEValidacao("Codigo: ", saida);

    }
}
