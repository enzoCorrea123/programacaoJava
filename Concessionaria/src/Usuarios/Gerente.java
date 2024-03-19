package Usuarios;

import Veiculos.Veiculo;

import java.util.ArrayList;

public class Gerente extends Funcionario{
    BancoUsuario bancoUsuario;

    public Gerente(String nome, String usuario, String senha, double salario, long codigo, double comissao) {
        super(nome, usuario, senha, salario, codigo, comissao);
    }

    public void cadastrarVeiculo(Veiculo veiculo){
        Veiculo.addVeiculo(veiculo);
    }
    public void removerVeiculo(Veiculo veiculo){
        Veiculo.removeVeiculo(veiculo);
    }
    public void editarVeiculos(Veiculo veiculo, Veiculo novoVeiculo){
        int index = Veiculo.getVeiculos().indexOf(veiculo);
        Veiculo.getVeiculos().set(index, novoVeiculo);
    }

    public void cadastrarUsuario(Usuario usuario){
        bancoUsuario.addUsuario(usuario);
    }
    public void removerUsuario(Usuario usuario){
        bancoUsuario.removeUsuario(usuario);
    }
    public void editarUsuario(Usuario usuario, Usuario novoUsuario){
        int index = bancoUsuario.getListaUsuarios().indexOf(usuario);
        bancoUsuario.getListaUsuarios().set(index, novoUsuario);
    }
    public String verVendedores(){
        String txt = "";
        for(Usuario usuario : bancoUsuario.getListaUsuarios()){
            if (usuario instanceof Vendedor){
                txt += usuario.toString() + "\n";
            }
        }
        return txt;
    }
    public String verClientes(){
        String txt = "";
        for(Usuario usuario : bancoUsuario.getListaUsuarios()){
            if (usuario instanceof Cliente){
                txt += usuario.toString() + "\n";
            }
        }
        return txt;
    }
    public ArrayList<String> verPagamentos(){ // adicionar exception
        ArrayList<String> listaDePagamentos = new ArrayList<>();
        for(Usuario usuario : bancoUsuario.getListaUsuarios()){
            if (usuario instanceof Funcionario){
                listaDePagamentos.add(usuario.getNome() + " " + ((Funcionario) usuario).getPagamentos() +"\n");
            }
        }
        if(listaDePagamentos.size() > 0){
            return listaDePagamentos;

        }
        return null;
    }

    public ArrayList<Double> verPagamento(Usuario usuario){
        return ((Funcionario) usuario).getPagamentos();
    }


    @Override
    public String menu() {
        return super.menu() + "\n7 - Cadastrar veículos\n8 - Remover veículos\n9 - Editar veículos\n10 - Alterar preço\n" +
                "11 - Cadastrar Usuario\n12 - Remover usuario\n13 - Editar usuário\n14 - Ver vendedores\n" +
                "15 - Ver clientes\n16 - Ver pagamento de seus vendedores\n17 - Ver pagamentos de um vendedor";
    }


}

