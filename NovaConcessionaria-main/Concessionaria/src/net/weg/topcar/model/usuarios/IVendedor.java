package net.weg.topcar.model.usuarios;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.FalhaNaCompraException;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;

public interface IVendedor extends ICliente{
    void vender(Automovel automovel,
                Cliente cliente) throws FalhaNaCompraException;
    Cliente buscarUsuario(Long cpf, IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException;
    String verPagamento();
}
