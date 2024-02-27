package Veiculos;

public class Carro extends Veiculo{
    private String tipo;
    private int numeroPortas;
    private String cambio;
    private boolean completo;

    public Carro(String tipo, int numeroPortas, String cambio, boolean completo, int codigo, String modelo, int ano, String marca, double preco, String cor, double quilometragem, String alimentacao) {
        this.tipo = tipo;
        this.numeroPortas = numeroPortas;
        this.cambio = cambio;
        this.completo = completo;
        this.setCodigo(codigo);
        this.setModelo(modelo);
        this.setAno(ano);
        this.setMarca(marca);
        this.setPreco(preco);
        this.setCor(cor);
        this.setQuilometragem(quilometragem);
        this.setAlimentacao(alimentacao);


    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "tipo='" + tipo + '\'' +
                ", numeroPortas=" + numeroPortas +
                ", cambio='" + cambio + '\'' +
                ", completo=" + completo +
                '}';
    }
}
