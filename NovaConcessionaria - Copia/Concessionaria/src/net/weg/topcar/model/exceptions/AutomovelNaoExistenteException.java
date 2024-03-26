package net.weg.topcar.model.exceptions;

public class AutomovelNaoExistenteException extends Exception{
    public AutomovelNaoExistenteException(String codigo){
        super("O carro com o código " + codigo + "já existe");
    }
}
