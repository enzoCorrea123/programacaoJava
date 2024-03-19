package Usuarios;

import Exceptions.*;
import Veiculos.Veiculo;

import java.util.ArrayList;

public abstract class Usuario {
    private String nome;
    private String usuario;
    private String senha;
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Usuario(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }


    public void addVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }
    public void removeVeiculo(Veiculo veiculo){
        veiculos.remove(veiculo);
    }


    public ArrayList<Veiculo> getVeiculos(){
        return veiculos;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String menu(){
        return "1 - logout\n2 - Ver veiculos disponiveis\n3 - Ver veiculos comprados";
    }
    public void verificarOpcao(int opcao) throws AcessoNegadoException, OpcaoInvalidaException {
        if(opcao > 17){
            throw new OpcaoInvalidaException();
        }

    }
    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", veiculos=" + veiculos +
                '}';
    }
}
