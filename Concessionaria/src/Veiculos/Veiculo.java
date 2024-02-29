package Veiculos;

import java.util.ArrayList;

public abstract class Veiculo {
    private int codigo;
    private String modelo;
    private int ano;
    private String cor;
    private String marca;
    private double quilometragem;
    private String combustivel;
    private double preco;
    private static ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Veiculo(int codigo, String modelo, int ano, String cor, String marca, double quilometragem, String combustivel, double preco) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.marca = marca;
        this.quilometragem = quilometragem;
        this.combustivel = combustivel;
        this.preco = preco;
    }

    public static void addVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }
    public static void removeVeiculo(Veiculo veiculo){
        veiculos.remove(veiculo);
    }
    public static Veiculo procurarVeiculo(int codigo){
        for (Veiculo veiculo: veiculos) {
            if(veiculo.codigo == codigo){
                return veiculo;
            }
        }
        return null;
    }
    public static ArrayList<Veiculo> getVeiculos(){
        return veiculos;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
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

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "codigo=" + codigo +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                ", marca='" + marca + '\'' +
                ", quilometragem=" + quilometragem +
                ", combustivel='" + combustivel + '\'' +
                ", preco=" + preco +
                '}';
    }
}
