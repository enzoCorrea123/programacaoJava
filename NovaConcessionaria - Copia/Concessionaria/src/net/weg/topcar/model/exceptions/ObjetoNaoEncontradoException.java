package net.weg.topcar.model.exceptions;

public class ObjetoNaoEncontradoException extends Exception {
    public ObjetoNaoEncontradoException(Long cpf){
        super("O usuário de CPF " + cpf +
                " não foi encontrado!");
    }
    public ObjetoNaoEncontradoException(){
        super("Usuário não encontrado!");
    }
}
