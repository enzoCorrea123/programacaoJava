package net.weg.topcar.model.exceptions;

import net.weg.topcar.model.usuarios.Cliente;

public class TipoDeUsuarioInvalidoException extends Exception{
    public TipoDeUsuarioInvalidoException(Cliente cliente){
        super("Tipo de usuário Invalido!\nO usuario com o cpf " + cliente.getCpf() + "é um "
                +cliente.getClass().getSimpleName().toLowerCase());
    }
}
