package Usuarios;

public class SenhaIncorretaException extends RuntimeException{
    public SenhaIncorretaException(){
        super("Senha incorreta");
    }
}
