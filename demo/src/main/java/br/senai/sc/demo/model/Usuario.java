package br.senai.sc.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(name = "password")
    private String senha;
    @Column(length = 50, unique = true, nullable = false, precision = 11)
    private Long cpf;
    @Column(length = 50)
    private String nomePet;

}
