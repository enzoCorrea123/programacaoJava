package Exceptions;

public class UsuarioNaoEncontradoException extends Exception{//exigência de tratamento
    public UsuarioNaoEncontradoException(String user){
        super("Usuário " + user + " não encontrado");
    }
}
