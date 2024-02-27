package Usuarios;

import Veiculos.Veiculo;

import java.util.ArrayList;

public class Gerente extends Funcionario{
    public Gerente(String nome, String usuario, String senha, double salario, int codigo, double comissao){}
    this.nome = nome;
    this.usuario = usuario;
    this.senha = senha;
    this.salario = salario;
    this.codigo = codigo;
    this.comissao = 0.02;


    }
    public void cadastrarVeiculo(Veiculo veiculo){
        //chamar classe veiculo
    }
    public void removerVeiculo(Veiculo veiculo){
        //chamar classe veiculo
    }
    public void editarVeiculos(Veiculo veiculo){
        //chamar classe veiculo
    }
    public void alterarPreco(Veiculo veiculo) {
        //alterar preco com veiculo??
    }
    public void cadastrarUsuario(Usuario usuario){
        Usuario.addUsuario(usuario);
    }
    public void removerUsuario(Usuario usuario){
        Usuario.removeUsuario(usuario);
    }
    public void editarUsuario(Usuario usuario){
        //editar usuario
    }
    public ArrayList<Vendedor> verVendedores(){
        //ver vendedores
        return null;
    }
    public void verVendedores(){
        //ver vendedores
    }
    public ArrayList<Cliente> verClientes(){
        //ver clientes
    }
    public ArrayList<Double> verPagamentos(){
        return getPagamentos();
    }
    public ArrayList<Double> verPagamento(Usuario usuario){
        Usuario user = procurarUsuario(usuario.getUsuario());
        return user.getPagamentos();
    }




}

