package Veiculos;

public class Moto extends Veiculo{
    private String carenagem;
    private int cilindrada;
    private String estilo;
    private String partida;

    public Moto(String carenagem, int cilindrada, String estilo, String partida, int codigo, String modelo, int ano, String marca, double preco, String cor, double quilometragem, String alimentacao) {
        this.carenagem = carenagem;
        this.cilindrada = cilindrada;
        this.estilo = estilo;
        this.partida = partida;
        this.setCodigo(codigo);
        this.setModelo(modelo);
        this.setAno(ano);
        this.setMarca(marca);
        this.setPreco(preco);
        this.setCor(cor);
        this.setQuilometragem(quilometragem);
        this.setAlimentacao(alimentacao);


    }

    public void setCarenagem(String carenagem) {
        this.carenagem = carenagem;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "carenagem='" + carenagem + '\'' +
                ", cilindrada=" + cilindrada +
                ", estilo='" + estilo + '\'' +
                ", partida='" + partida + '\'' +
                '}';
    }
}
