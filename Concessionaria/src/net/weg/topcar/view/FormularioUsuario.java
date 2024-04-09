package net.weg.topcar.view;

public class FormularioUsuario extends Formulario{
    private final Saida saida = new Saida();


    private String entradaNome(String nome) {
        String novoNome = entradaString.leiaComSaida("Nome: ", saida);
        if(novoNome.isEmpty()){
            return nome;
        }
        return novoNome;
    }
    private Long entradaIdade(Long idade){
        Long novaIdade = entradaInteiro.leiaComSaida("Idade: ", saida);
        if(novaIdade <= idade){
            return idade;
        }
        return novaIdade;
    }
    private  Double entradaSalario(Double salario){
        Double novoSalario = entradaDouble.leiaComSaida("Salário: ", saida);
        if(novoSalario <= 0.0){
            return salario;
        }
        return novoSalario;
    }

    Long entradaCPF(){
        return entradaInteiro.leiaComSaidaEValidacao("Informe o seu cpf: ", saida);
    }
    String entradaNome(){
        return entradaString.leiaComSaidaEValidacao("Informe o seu nome: ", saida);
    }
    Long entradaIdade(){
        return entradaInteiro.leiaComSaidaEValidacao("Informe a sua idade: ", saida);
    }
    String entradaSenha(){
        String senha, confSenha;
        do {
            senha = entradaString.leiaComSaidaEValidacao("Informe a sua senha: ", saida);
            confSenha = entradaString.leiaComSaidaEValidacao("Confirme a sua senha: ", saida);
        } while (!senha.equals(confSenha));
        return senha;
    }
    Double entradaSalario(){
        return entradaDouble.leiaComSaidaEValidacao("Salário: ", saida);
    }


}
