package Veiculos;

public class Caminhao extends Veiculo{
    private String carroceria;
    private String tracao;
    private String cabine;

    public Caminhao(String carroceria, String tracao, String cabine, int codigo, String modelo, int ano, String marca, double preco, String cor, double quilometragem, String alimentacao) {
        this.carroceria = carroceria;
        this.tracao = tracao;
        this.cabine = cabine;
        this.setCodigo(codigo);
        this.setModelo(modelo);
        this.setAno(ano);
        this.setMarca(marca);
        this.setPreco(preco);
        this.setQuilometragem(quilometragem);
        this.setAlimentacao(alimentacao);
        this.setCor(cor);

    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    public void setCabine(String cabine) {
        this.cabine = cabine;
    }

    public void setTracao(String tracao) {
        this.tracao = tracao;
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "carroceria='" + carroceria + '\'' +
                ", tracao='" + tracao + '\'' +
                ", cabine='" + cabine + '\'' +
                '}';
    }
}
