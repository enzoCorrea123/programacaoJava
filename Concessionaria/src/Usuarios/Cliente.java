package Usuarios;

public class Cliente extends Usuario{
    public Cliente(String nome, String usuario, String senha) {
        super(nome, usuario, senha);
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "" + super.toString() +
                "}";
    }
}
