package Exceptions;

public class VeiculoExistenteException extends Exception{
    public VeiculoExistenteException(){
        super("Veículo já existente");
    }
}
