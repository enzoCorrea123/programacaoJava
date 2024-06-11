package br.senai.sc.demo.controller;

import br.senai.sc.demo.model.Usuario;
import lombok.ToString;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teste")

public class UsuarioController {

    @GetMapping
    public String endpointGet() {
        return "GET!";
    }

    @PostMapping
    public String cadastroUsuario(@RequestBody Usuario usuario) {
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
