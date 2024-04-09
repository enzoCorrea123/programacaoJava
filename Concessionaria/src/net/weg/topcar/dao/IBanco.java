package net.weg.topcar.dao;

import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.usuarios.Cliente;

import java.util.List;

public interface IBanco<T,ID> {
    List<T> buscarTodos();
    T buscarUm(ID id)
            throws ObjetoNaoEncontradoException;
    Cliente adicionar(T novo);
    void remover(ID id)
            throws ObjetoNaoEncontradoException;
    Boolean existe(ID id);
    void alterar(ID id,
                 T novo)
            throws ObjetoNaoEncontradoException;
}
