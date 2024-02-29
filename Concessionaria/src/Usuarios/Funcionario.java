package Usuarios;

import Veiculos.Veiculo;

import java.util.ArrayList;

public abstract class Funcionario extends Usuario{
    private double salario;
    private long codigo;
    private double comissao;
    private ArrayList<Double> pagamentos = new ArrayList<>();

    public Funcionario(String nome, String usuario, String senha, double salario, long codigo, double comissao) {
        super(nome, usuario, senha);
        this.salario = salario;
        this.codigo = codigo;
        this.comissao = comissao;
    }

    public ArrayList<Double> getPagamentos() {
        return pagamentos;
    }

    public void addPagamento(double pagamento){
        pagamentos.add(pagamento);
    }
    public Usuario procurarCliente(String nome){
        return Usuario.procurarUsuario(nome);
    }
    public boolean venderVeiculo(int codigo,String usuario){
        Usuario usuario1 = Usuario.procurarUsuario(usuario);
        Veiculo veiculo = Veiculo.procurarVeiculo(codigo);
        if(usuario1 != null && veiculo != null){
            usuario1.addVeiculo(veiculo);
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "salario=" + salario +
                ", codigo=" + codigo +
                ", comissao=" + comissao +
                '}';
    }
}
