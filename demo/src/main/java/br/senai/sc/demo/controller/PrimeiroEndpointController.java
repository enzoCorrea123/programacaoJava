package br.senai.sc.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teste")
public class PrimeiroEndpointController {

    @GetMapping
    public String endpointGet() {
        return "GET!";
    }

    @PostMapping
    public String endpointPost(@RequestBody String nome) {
        return "POST -> " + nome;
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
