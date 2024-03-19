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
    public static Veiculo procurarVeiculo(int codigo){ // adicionar exception
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
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
