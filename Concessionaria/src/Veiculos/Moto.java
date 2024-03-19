package Veiculos;

public class Moto extends Veiculo{
    private String carenagem;
    private int cilindrada;
    private String estilo;
    private String partida;

    public Moto(int codigo, String modelo, int ano, String cor, String marca, double quilometragem, String combustivel, double preco, String carenagem, int cilindrada, String estilo, String partida) {
        super(codigo, modelo, ano, cor, marca, quilometragem, combustivel, preco);
        this.carenagem = carenagem;
        this.cilindrada = cilindrada;
        this.estilo = estilo;
        this.partida = partida;
    }


    @Override
    public String toString() {
        return "Moto{" +
                "carenagem='" + carenagem + '\'' +
                ", cilindrada=" + cilindrada +
                ", estilo='" + estilo + '\'' +
                ", partida='" + partida + '\'' + super.toString() +
                '}';
    }
}
