package Usuarios;

import java.util.ArrayList;

public abstract class Funcionario extends Usuario{
    private double salario;
    private long codigo;
    private double comissao;
    private ArrayList<Double> pagamentos = new ArrayList<>();
    //construtor funcionario


    public ArrayList<Double> getPagamentos() {
        return pagamentos;
    }
    public static void addPagamento(double pagamento){
        pagamentos.add(pagamento);
    }
    public Cliente procurarCliente(String nomeUsuario){
        for(Cliente cliente: listaDeUsuarios){
            if(cliente.getUsuario().equals(nomeUsuario)){
                return cliente;
            }
        }
        return null;
    }
    public boolean venderVeiculo(int codigo,String usuario){
        //vender veiculo
        return false;
    }

}
