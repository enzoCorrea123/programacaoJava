package Usuarios;

public class Vendedor extends Funcionario{
    public Vendedor(String nome, String usuario, String senha, double salario, long codigo) {
        super(nome, usuario, senha, salario, codigo, 0.01);
    }

    @Override
    public String menu() {
        return super.menu() + "\n4 - Vender Veiculo\n5 - Procurar Cliente\n6 - Ver pagamento";
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "" +super.toString() +
                "}";
    }
}
