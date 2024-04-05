package net.weg.topcar.view;

import java.util.InputMismatchException;

public class EntradaInteiro extends Entrada<Long>{
    @Override
    protected boolean validaEntrada(Long valor) {
        return valor > 0;
    }

    @Override
    public Long leia() throws InputMismatchException {
        return sc.nextLong();
    }

}
