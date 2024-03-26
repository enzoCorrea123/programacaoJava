package net.weg.topcar.model.usuarios;

import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.exceptions.SenhaIncorretaException;

;

public class LoginUsuario {
    private final BancoUsuario bancoUsuario;
    private Cliente usuario;

    public LoginUsuario(
            BancoUsuario bancoUsuario){
        this.bancoUsuario = bancoUsuario;
    }
    public Usuario login(String cpf,
                         String senha)
            throws ObjetoNaoEncontradoException,
            SenhaIncorretaException {
        this.usuario = this.bancoUsuario
                .procurarUsuario(cpf);
        validarSenha(senha);
        return usuario;
    }
    private void validarSenha(
            String senha)
        throws SenhaIncorretaException {
        if(!usuario.getSenha()
                .equals(senha)){
            throw new SenhaIncorretaException();
        }
    }
}
