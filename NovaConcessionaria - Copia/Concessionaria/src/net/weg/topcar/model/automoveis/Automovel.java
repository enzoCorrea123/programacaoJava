package net.weg.topcar.model.automoveis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Automovel {
    private static ArrayList<Automovel> listaAutomoveis = new ArrayList<Automovel>();
    private final String CODIGO;
    private String modelo;
    private Long ano;
    private String marca;
    private String tipoCombustivel;
    private double preco;
    private double quilometragem;
    private String placa;
    private String cor;
    private boolean comprado;
    private String estado;

    public Automovel(String CODIGO, String modelo, Long ano, String marca, String tipoCombustivel, double preco, double quilometragem, String placa, String cor, String estado) {
        this.CODIGO = CODIGO;
        this.modelo = modelo;
        this.ano = ano;
        this.marca = marca;
        this.tipoCombustivel = tipoCombustivel;
        this.preco = preco;
        this.quilometragem = quilometragem;
        this.placa = placa;
        this.cor = cor;
        this.estado = estado;
        this.comprado = false;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void mudarStatusDeCompra() {
        this.comprado = true;
    }

    public static List<Automovel> getListaAutomoveis() {
        return Collections.unmodifiableList(listaAutomoveis);
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public String getModelo() {
        return modelo;
    }

    public Long getAno() {
        return ano;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public double getPreco() {
        return preco;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCor() {
        return cor;
    }

    public boolean isComprado() {
        return comprado;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
            return
             "\nCódigo: " + this.getCODIGO() +
            "\nModelo: " + this.getModelo() +
            "\nAno: " + this.getAno() +
            "\nMarca: " + this.getMarca() +
            "\nTipo de combústivel: " + this.getTipoCombustivel() +
            "\nPreço: " + this.getPreco() +
            "\nQuilometragem: " + this.getQuilometragem() +
            "\nPlaca: " + this.getPlaca() +
            "\nCor: " + this.getCor() +
            "\nStatus: " + (this.isComprado() ? "Comprado" : "À venda") +
            "\nEstado: " + this.getEstado();
}
}
