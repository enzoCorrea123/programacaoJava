package br.senai.sc.demo.service;

import br.senai.sc.demo.model.Usuario;
import br.senai.sc.demo.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
//@RequiredArgsConstructor
public class UsuarioService {
    //    @NonNull
    private UsuarioRepository usuarioRepository;

    private void validarUsuario(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario não encontrado!");

        }
    }

    public Usuario cadastroUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return usuario;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuario(Integer id) throws Exception {
        validarUsuario(id);
        return usuarioRepository.findById(id).get();
    }


    public Usuario atualizarUsuario(Usuario usuario) {
        validarUsuario(usuario.getId());
        return usuarioRepository.save(usuario);
    }

    public Usuario alterarSenha(Integer id, String senha) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setSenha(senha);
            return usuarioRepository.save(usuario);

        }
        throw new RuntimeException("Usuario não encontrado!");
    }

    public void deletarUsuario(Integer id) {
        validarUsuario(id);
        usuarioRepository.deleteById(id);
        if (usuarioRepository.existsById(id)) { //se ele ainda existir após ser deletado...
            throw new RuntimeException("Não foi possível de deletar o usuario de id " + id);
        }
    }
}
