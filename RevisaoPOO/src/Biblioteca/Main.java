package Biblioteca;

import Biblioteca.Usuarios.Bibliotecario;
import Biblioteca.Usuarios.Cliente;
import Biblioteca.Usuarios.Funcionario;
import Biblioteca.Usuarios.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem vindo à biblioteca virtual! 😊");
        System.out.println("1 - Cadastro de Usuário\n2 - Login\n3 - Sair");
        int escolha = sc.nextInt();
        switch (escolha) {
            case 1:
                cadastrarUsuario();
                break;
            case 2:
                login();
                break;
            case 3:
                System.exit(0);
                break;
        }

    }

    private static void login() {
        Usuario usuario = null;
        do {
            System.out.println("");
            Usuario.login("enzorc", "123");

        } while (usuario == null);
        menuUsuario(usuario);
    }

    private static void menuUsuario(Usuario usuario) {
        System.out.println("0 - Logout\n1 - Alterar nome\n2 - Alterar senha\n3 - Ver empréstimos\n4 - Ver perfil\n5 - Consultar disponibilidade de mídia");
        if(usuario instanceof Funcionario){
            System.out.println("6 - Cadastrar usuário\n7 - Remover usuário\n8 - Emprestar mídia\n9 - Devolver de mídia");
        }
        if(usuario instanceof Bibliotecario){

        }
    }

    private static void cadastrarUsuario() {
        System.out.println("");
        Usuario usuario = new Cliente("Enzo", "enzorc", "123");
        Usuario.addUsuario(usuario);

    }
}
