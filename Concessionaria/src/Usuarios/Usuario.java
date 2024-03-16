package Usuarios;

import Veiculos.Veiculo;

import java.util.ArrayList;

public abstract class Usuario {
    private String nome;
    private String usuario;
    private String senha;
    protected static ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Usuario(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public static Usuario procurarUsuario(String usuario){
        for (Usuario userProcurado: usuarios) {
            if(userProcurado.usuario.equals(usuario)){
                return userProcurado;
            }
        }
        return null;
    }
    public static void addUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    public static void removeUsuario(Usuario usuario){
        usuarios.remove(usuario);
    }
    public void addVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }
    public void removeVeiculo(Veiculo veiculo){
        veiculos.remove(veiculo);
    }
    public static Usuario login(String usuario, String senha) throws Exception{
        for(Usuario user : usuarios){
            if(user.usuario.equals(usuario) && user.senha.equals(senha)){
                return user;
            }
        }
        throw new UsuarioNaoEncontradoException();

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

    public String menu(){
        return "1 - logout\n2 - Ver veiculos disponiveis\n3 - Ver veiculos comprados";
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
