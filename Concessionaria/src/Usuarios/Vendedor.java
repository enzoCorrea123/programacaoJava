package Usuarios;

public class Vendedor extends Funcionario{
    public Vendedor(String nome, String usuario, String senha, double salario, int codigo){
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.salario = salario;
        this.codigo = codigo;
        this.comissao = 0.01;
    }

}
