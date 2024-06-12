package br.senai.sc.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@ToString
public class Usuario {
    @Id
    // identity: sequencial, mantém um id que já foi utilizada. (auto_increment)
    // table: sequencial, não mantém a reserva do id utilizado.
    //sequency : segue uma sequência
    //UUID : define um id único em todo universo
    //auto : define qual dos 4 tipos seria o padrão do banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)//gera um valor aleatório para o id
    @Column
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(name = "password")
    @ToString.Exclude
    private String senha;
    @Column(length = 50, unique = true, nullable = false, precision = 11)
    private Long cpf;
    @Column(length = 50)
    private String nomePet;

}
