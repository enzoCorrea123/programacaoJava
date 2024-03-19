package Veiculos;

public class Caminhao extends Veiculo{
    private String carroceria;
    private String tracao;
    private String cabine;

    public Caminhao(int codigo, String modelo, int ano, String cor, String marca, double quilometragem, String combustivel, double preco, String carroceria, String tracao, String cabine) {
        super(codigo, modelo, ano, cor, marca, quilometragem, combustivel, preco);
        this.carroceria = carroceria;
        this.tracao = tracao;
        this.cabine = cabine;
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "carroceria='" + carroceria + '\'' +
                ", tracao='" + tracao + '\'' +
                ", cabine='" + cabine + '\'' + super.toString() +
                '}';
    }
}
