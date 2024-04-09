package net.weg.topcar.view;

public class FormularioAutomovel extends Formulario{
    private Double entradaPreco(Double precoAntigo) {
        Double novoPreco = entradaDouble.leiaComSaida("Novo preço: ", saida);
        if (novoPreco <= 0.0) {
            return precoAntigo;
        }
        return novoPreco;
    }

    Boolean entradaNovo() {
        Long entrada;
        do {
            entrada = entradaInteiro.leiaComSaidaEValidacao("""
                    Carro 0km?
                    1 - Sim
                    2 - Não""", saida);
        } while (entrada > 2);
        return entrada == 1;
    }

    String entradaMarcha() {
        return entradaString.leiaComSaidaEValidacao("Marcha: ", saida);
    }

    private String entradaMarcha(String marcha) {
        String novaMarcha = entradaString.leiaComSaida("Marcha: ", saida);
        if (novaMarcha.isEmpty()) {
            return marcha;
        }
        return novaMarcha;
    }

    String entradaPartida() {
        return entradaString.leiaComSaidaEValidacao("Partida: ", saida);
    }

    private String entradaPartida(String partida) {
        String novaPartida = entradaString.leiaComSaida("Partida: ", saida);
        if (novaPartida.isEmpty()) {
            return partida;
        }
        return novaPartida;
    }

    String entradaCarroceria() {
        return entradaString.leiaComSaidaEValidacao("Carroceria: ", saida);
    }

    private String entradaCarroceria(String carroceria) {
        String novaCarroceria = entradaString.leiaComSaida("Carroceria: ", saida);
        if (novaCarroceria.isEmpty()) {
            return carroceria;
        }
        return novaCarroceria;
    }

    Long entradaCilindradas() {
        return entradaInteiro.leiaComSaidaEValidacao("Cilindradas: ", saida);
    }

    private Long entradaCilindradas(Long cilindradas) {
        Long novaCilindrada = entradaInteiro.leiaComSaida("Cilindradas: ", saida);
        if (novaCilindrada == 0) {
            return cilindradas;
        }
        return novaCilindrada;
    }

    Double entradaPreco() {
        return entradaDouble.leiaComSaidaEValidacao("Preço: ", saida);
    }

    Double entradaQuilometragem() {
        return entradaDouble.leiaComSaidaEValidacao("Quilometragem: ", saida);
    }

    private Double entradaQuilometragem(Double quilometragem) {
        Double novaQuilometragem = entradaDouble.leiaComSaida("Quilometragem: ", saida);
        if (novaQuilometragem <= 0) {
            return quilometragem;
        }
        return novaQuilometragem;
    }

    Long entradaAno() {
        return entradaInteiro.leiaComSaidaEValidacao("Ano: ", saida);
    }

    private Long entradaAno(Long ano) {
        Long novoAno = entradaInteiro.leiaComSaida("Ano: ", saida);
        if (novoAno == 0) {
            return ano;
        }
        return novoAno;
    }

    String entradaModelo() {
        return entradaString.leiaComSaidaEValidacao("Modelo: ", saida);
    }

    private String entradaModelo(String modelo) {
        String novoModelo = entradaString.leiaComSaida("Modelo: ", saida);
        if (novoModelo.isEmpty()) {
            return modelo;
        }
        return novoModelo;
    }

    String entradaMarca() {
        return entradaString.leiaComSaidaEValidacao("Marca: ", saida);
    }

    private String entradaMarca(String marca) {
        String novaMarca = entradaString.leiaComSaidaEValidacao("Marca: ", saida);
        if (novaMarca.isEmpty()) {
            return marca;
        }
        return novaMarca;
    }

    String entradaCombustivel() {
        return entradaString.leiaComSaidaEValidacao("Combustível: ", saida);
    }

    private String entradaCombustivel(String combustivel) {
        String novoCombustivel = entradaString.leiaComSaida("Combustível: ", saida);
        if (novoCombustivel.isEmpty()) {
            return combustivel;
        }
        return novoCombustivel;
    }

    String entradaPlaca() {
        return entradaString.leiaComSaidaEValidacao("Placa: ", saida);
    }

    private String entradaPlaca(String placa) {
        String novaPlaca = entradaString.leiaComSaida("Placa: ", saida);
        if (novaPlaca.isEmpty()) {
            return placa;
        }
        return novaPlaca;
    }

    String entradaCor() {
        return entradaString.leiaComSaidaEValidacao("Cor: ", saida);
    }

    private String entradaCor(String cor) {
        String novaCor = entradaString.leiaComSaida("Cor: ", saida);
        if (novaCor.isEmpty()) {
            return cor;
        }
        return novaCor;
    }
    String entradaCodigo() {
        return entradaString.leiaComSaidaEValidacao("Codigo: ", saida);
    }


}
