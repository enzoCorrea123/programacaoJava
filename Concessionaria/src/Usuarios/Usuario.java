package Usuarios;

import Veiculos.Veiculo;

import java.util.ArrayList;

public abstract class Usuario {
    private String nome;
    private String usuario;
    private String senha;
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public Usuario procurarUsuario(String usuario){
        for (Usuario userProcurado: usuarios) {
            if(userProcurado.usuario.equals(usuario)){
                return userProcurado;
            }
        }
        return null;
    }
    public void addUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    public void removeUsuario(Usuario usuario){
        usuarios.remove(usuario);
    }
    public void addVeiculo(Veiculo veiculo){
        Veiculo.addVeiculo(veiculo);
    }
    public void removeVeiculo(Veiculo veiculo){
        Veiculo.removeVeiculo(veiculo);
    }
    public ArrayList<Veiculo> getVeiculos(){
        return Veiculo.getVeiculos();
    }

}
