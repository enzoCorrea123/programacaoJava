package Veiculos;

import java.util.ArrayList;

public abstract class Veiculo {
    private int codigo;
    private String modelo;
    private int ano;
    private String cor;
    private String marca;
    private double quilometragem;
    private String alimentacao;
    private double preco;
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public void addVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }
    public void removeVeiculo(Veiculo veiculo){
        veiculos.remove(veiculo);
    }
    public Veiculo procurarVeiculo(int codigo){
        for (Veiculo veiculo: veiculos) {
            if(veiculo.codigo == codigo){
                return veiculo;
            }
        }
        return null;
    }
    public ArrayList<Veiculo> getVeiculos(){
        return veiculos;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }
}
