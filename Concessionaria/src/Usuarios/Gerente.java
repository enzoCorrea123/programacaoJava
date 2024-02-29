package Usuarios;

import Veiculos.Veiculo;

import java.util.ArrayList;

public class Gerente extends Funcionario{

    public Gerente(String nome, String usuario, String senha, double salario, long codigo, double comissao) {
        super(nome, usuario, senha, salario, codigo, comissao);
    }

    public void cadastrarVeiculo(Veiculo veiculo){
        Veiculo.addVeiculo(veiculo);
    }
    public void removerVeiculo(Veiculo veiculo){
        Veiculo.removeVeiculo(veiculo);
    }
    public void editarVeiculos(Veiculo veiculo){
        //chamar classe veiculo
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
    public String verVendedores(){
        String txt = "";
        for(Usuario usuario : usuarios){
            if (usuario instanceof Vendedor){
                txt += usuario.toString() + "\n";
            }
        }
        return txt;
    }
    public String verClientes(){
        String txt = "";
        for(Usuario usuario : usuarios){
            if (usuario instanceof Cliente){
                txt += usuario.toString() + "\n";
            }
        }
        return txt;
    }
    public ArrayList<Double> verPagamentos(){
        return getPagamentos();
    }

    public ArrayList<Double> verPagamento(Usuario usuario){
        return ((Funcionario) usuario).getPagamentos();
    }




}

