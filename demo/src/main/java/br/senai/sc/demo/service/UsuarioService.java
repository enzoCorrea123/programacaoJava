package br.senai.sc.demo.service;

import br.senai.sc.demo.model.Usuario;
import br.senai.sc.demo.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
//@RequiredArgsConstructor
public class UsuarioService {
//    @NonNull
    private UsuarioRepository usuarioRepository;
    public Usuario cadastroUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
        return usuario;
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }


    public Usuario buscarUsuario(Integer id) {
        if(usuarioRepository.findById(id).isPresent()){
            return usuarioRepository.findById(id).get();

        }
        throw new RuntimeException();
    }
}
