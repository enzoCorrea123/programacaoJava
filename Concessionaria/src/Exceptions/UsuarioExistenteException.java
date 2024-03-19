package Exceptions;

public class UsuarioExistenteException extends RuntimeException{
    public UsuarioExistenteException(){
        super("Usuário já existente");
    }
}
