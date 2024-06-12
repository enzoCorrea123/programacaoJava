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
    public String endpointGet(@PathVariable Integer id) {
        return usuarioService.buscarUsuario(id).toString();
    }

    @PostMapping
    public String cadastroUsuario(@RequestBody Usuario usuario) {
        usuarioService.cadastroUsuario(usuario);
        return "POST -> " + usuario.getNome() + "\n" + usuario;
    }

    @PutMapping
    public String endpointPut(@RequestParam int id, @RequestBody String nome) {
        return "PUT id-> " + id + " nome -> " + nome;
    }

    @PatchMapping("/{id}")
    public String endpointPatch(@PathVariable(name = "id") int identificador, @RequestBody String nome) {//PathVariable(value) seria para deixar um valor default
        return "PATCH id-> " + identificador + " nome -> " + nome;
    }

    @DeleteMapping("/{id}")
    public String endpointDelete(@PathVariable int id) {
        return "DELETE id -> " + id;
    }
}
