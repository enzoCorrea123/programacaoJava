package Usuarios;

import java.util.List;

public interface IBanco<T, ID> {
    List<T> buscarTodos();
    T buscarUm(ID id);

    void adicionar(T novo);
    void remover(ID id);
    void alterar(ID id);
}
