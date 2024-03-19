package Exceptions;

public class PrecoInvalidoException extends RuntimeException{
    public PrecoInvalidoException(){
        super("Preço inválido");
    }
}
