package br.senai.sc.demo.controller;

import br.senai.sc.demo.model.Usuario;
import br.senai.sc.demo.service.UsuarioService;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {
//    @Autowired //depois do objeto controller ser criado ele adiciona um novo usuario service(agregação)
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){//(composição)
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String endpointGetAll() {
        return usuarioService.listarUsuarios().toString();
    }
    @GetMapping("/{id}")
    public String endpointGet(@PathVariable Integer id) throws Exception {
        return usuarioService.buscarUsuario(id).toString();
    }

    @PostMapping
    public String cadastroUsuario(@RequestBody Usuario usuario) {
        usuarioService.cadastroUsuario(usuario);
        return "POST -> " + usuario.getNome() + "\n" + usuario;
    }

    @PutMapping
    public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(usuario);
    }

    @PatchMapping("/{id}")
    public Usuario alterarSenha(@PathVariable Integer id, @RequestBody String senha) {//PathVariable(value) seria para deixar um valor default
        return usuarioService.alterarSenha(id, senha);
    }

    @DeleteMapping
    public void deletarUsuario(@RequestParam Integer id) {
        usuarioService.deletarUsuario(id);
    }
}
