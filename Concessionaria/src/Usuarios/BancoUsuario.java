package Usuarios;

import Exceptions.SenhaIncorretaException;
import Exceptions.UsuarioExistenteException;
import Exceptions.UsuarioNaoEncontradoException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BancoUsuario implements IBanco<Usuario, String> {
    private List<Usuario> usuarios;

    public Usuario procurarUsuario(String usuario) throws UsuarioNaoEncontradoException {//adicionar exception
        for (Usuario userProcurado: usuarios) {
            if(userProcurado.getUsuario().equals(usuario)){
                return userProcurado;
            }
        }
        throw new UsuarioNaoEncontradoException(usuario);
    }
    public void adicionar(Usuario usuario) throws UsuarioExistenteException {
        for(Usuario usuario1 : usuarios){
            if(usuario1.equals(usuario)){
                throw new UsuarioExistenteException();
            }
        }
        usuarios.add(usuario);
    }
    public void remover(Usuario usuario){
        usuarios.remove(usuario);
    }

    public Usuario login(String usuario, String senha) throws SenhaIncorretaException, UsuarioNaoEncontradoException {
        for(Usuario user : usuarios){
            if(user.getUsuario().equals((usuario))){
                if(user.getSenha().equals((senha))){
                    return user;
                }
                throw new SenhaIncorretaException();
            }
        }
        throw new UsuarioNaoEncontradoException(usuario);

    }
    public List<Usuario> buscarTodos(){
        return Collections.unmodifiableList(usuarios);
    }
}
