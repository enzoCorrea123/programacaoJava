package Usuarios;

import Exceptions.SenhaIncorretaException;
import Exceptions.UsuarioNaoEncontradoException;

public class LoginUsuario {
    private BancoUsuario bancoUsuario;

    private Usuario user;

    public LoginUsuario(BancoUsuario bancoUsuario){
        this.bancoUsuario = bancoUsuario
    }
    private Usuario login(String usuario, String senha) throws UsuarioNaoEncontradoException, SenhaIncorretaException {
        user = this.bancoUsuario.procurarUsuario(usuario);
        validarSenha(senha);
        return user;

    }

    private void validarSenha(String senha) throws SenhaIncorretaException{
        if(!user.getSenha().equals(senha)){
            throw new SenhaIncorretaException();
        }
    }



}
