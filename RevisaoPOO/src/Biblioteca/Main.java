package Biblioteca;

import Biblioteca.Midias.DVD;
import Biblioteca.Midias.Jornal;
import Biblioteca.Midias.Livro;
import Biblioteca.Midias.Revista;
import Biblioteca.Usuarios.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static Usuario usuariologado;
    private static Usuario cliente = new Cliente("Enzo", "enzorc", "123");
    private static Usuario bibliotecario = new Bibliotecario("Romario", "romarin", "123");
    private static Funcionario funcionario = new Atendente("Kevin", "kevinca", "123");

    public static void main(String[] args) {
        Usuario.addUsuario(cliente);
        Usuario.addUsuario(bibliotecario);
        Usuario.addUsuario(funcionario);
        System.out.println("Bem vindo à biblioteca virtual! 😊");
        System.out.println("1 - Login\n2 - Sair");
        int escolha = sc.nextInt();
        do {
            switch (escolha) {
                case 1:
                    login();
                    break;
                case 2:
                    System.exit(0);
                    break;
            }
        } while (true);

    }
    private static void login() {
        do{
            usuariologado = acharUsuario();
        }while(usuariologado == null);
        menuUsuario();
    }

    private static void menuUsuario() {
        do {
            System.out.println("0 - Logout\n1 - Alterar nome\n2 - Alterar senha\n3 - Ver empréstimos\n4 - Ver perfil\n5 - Consultar disponibilidade de mídia");
            if (usuariologado instanceof Funcionario) {
                System.out.println("6 - Cadastrar usuário\n7 - Remover usuário\n8 - Emprestar mídia\n9 - Devolver de mídia\n10 - Ver mídias");
            }
            if (usuariologado instanceof Bibliotecario) {
                System.out.println("11 - Cadastrar Mídia\n12 - Remover mídia");
            }
            int opcao = sc.nextInt();
            switch (opcao) {
                case 0 -> logout();
                case 1 -> alterarNome();
                case 2 -> alterarSenha();
                case 3 -> verEmprestimos();
                case 4 -> verPerfil();
                case 5 -> consultarMidia();
                case 6 -> cadastrarUsuario();
                case 7 -> removerUsuario();
                case 8 -> emprestarMidia();
                case 9 -> devolverMidia();
                case 10 -> verMidias();
                case 11 -> cadastrarMidia();
                case 12 -> removerMidia();
            }
        } while (usuariologado != null);
    }

    public static Usuario acharUsuario(){
        System.out.println("Usuario: ");
        String user = sc.next();
        System.out.println("Senha: ");
        String senha = sc.next();
        return Usuario.login(user, senha);
    }
    public static Midia acharMidia(){
        System.out.println("Digite o código da mídia: ");
        int codigo = sc.nextInt();
        return Midia.procurarMidia(codigo);
    }
    private static void cadastrarDvd() {
        System.out.println("Digite o diretor:");
        String diretor = sc.next();
        System.out.println("Digite o nome do filme: ");
        String filme = sc.next();
        System.out.println("Digite o código:");
        int codigo4 = sc.nextInt();
        Midia dvd = new DVD(diretor, filme, codigo4);
        ((Bibliotecario) usuariologado).cadastrarMidia(dvd);
    }

    private static void cadastarJornal() {
        System.out.println("Digite a data: ");
        String data = sc.next();
        System.out.println("Digite o código:");
        int codigo3 = sc.nextInt();
        Midia jornal = new Jornal(data, codigo3);
        ((Bibliotecario) usuariologado).cadastrarMidia(jornal);
    }

    private static void cadastrarRevista() {
        System.out.println("Digite o gênero: ");
        String genero1 = sc.next();
        System.out.println("Digite a editora:");
        String editora = sc.next();
        System.out.println("Digite o código:");
        int codigo2 = sc.nextInt();
        Midia revista = new Revista(editora, genero1, codigo2);
        ((Bibliotecario) usuariologado).cadastrarMidia(revista);
    }

    private static void cadastrarLivro() {
        System.out.println("Digite o título:");
        String titulo = sc.next();
        System.out.println("Digite o autor:");
        String autor = sc.next();
        System.out.println("Digite o gênero: ");
        String genero = sc.next();
        System.out.println("Digite o código:");
        int codigo1 = sc.nextInt();
        Midia livro = new Livro(autor, titulo, genero, codigo1);
        ((Bibliotecario) usuariologado).cadastrarMidia(livro);
        System.out.println(Midia.getMidias());
    }

    public static void logout() {
        usuariologado = null;
    }
    private static void alterarNome() {
        System.out.println("Digite seu novo nome:");
        String nome = sc.next();
        usuariologado.alterarNome(nome);
    }
    private static void alterarSenha() {
        System.out.println("Digite sua nova senha:");
        String senha = sc.next();
        usuariologado.alterarSenha(senha);
    }
    private static void verEmprestimos() {
        System.out.println(usuariologado.getEmprestimos());
    }
    private static void verPerfil() {
        System.out.println(usuariologado);
    }
    private static void consultarMidia() {
        System.out.println("Digite o código da mídia:");
        int codigo = sc.nextInt();
        System.out.println(usuariologado.consultarMidia(codigo));
    }
    private static void cadastrarUsuario() {
        if (usuariologado instanceof Funcionario) {
            System.out.println("Digite o seu nome:");
            String nome1 = sc.next();
            System.out.println("Digite o seu nome de usuário:");
            String nomeUsuario = sc.next();
            System.out.println("Digite a sua senha:");
            String senha1 = sc.next();
            Usuario cliente = new Cliente(nome1, nomeUsuario, senha1);
            ((Funcionario) usuariologado).cadastrarUsuario(cliente);
        }
    }
    private static void removerUsuario() {
        if (usuariologado instanceof Funcionario) {
            Usuario usuario = acharUsuario();
            if (usuario != null) {
                ((Funcionario) usuariologado).removerUsuario(usuario);
            } else {
                System.out.println("Usuário não encontrado");
            }
        }
    }
    private static void emprestarMidia() {
        if (usuariologado instanceof Funcionario) {
            Usuario usuario = acharUsuario();
            Midia midia = acharMidia();

            if (midia != null && usuario != null) {
                ((Funcionario) usuariologado).emprestarMidia(midia, usuario);

            } else {
                System.out.println("Mídia ou usuário não encontrados");
            }
        }
    }
    private static void devolverMidia() {
        if (usuariologado instanceof Funcionario) {
            Usuario usuario = acharUsuario();
            if (usuario != null) {
                Midia midia = acharMidia();
                if (midia != null) {
                    ((Funcionario) usuariologado).devolverMidia(midia, usuario);
                } else {
                    System.out.println("Mídia não encontrada");
                }
            }

        }
    }
    private static void verMidias() {
        System.out.println(((Funcionario) usuariologado).verMidias());
    }
    private static void cadastrarMidia() {
        if (usuariologado instanceof Bibliotecario) {
            System.out.println("1 - Livro\n2 - Revista\n3 - Jornal\n4 - DVD");
            int tipo = sc.nextInt();
            switch (tipo) {
                case 1:
                    cadastrarLivro();

                    break;
                case 2:
                    cadastrarRevista();

                    break;
                case 3:
                    cadastarJornal();

                    break;
                case 4:
                    cadastrarDvd();

                    break;
            }
        }
    }

    private static void removerMidia() {
        if (usuariologado instanceof Bibliotecario) {
            System.out.println("Digite o código da mídia:");
            int codigo1 = sc.nextInt();
            Midia midia = Midia.procurarMidia(codigo1);
            if (midia != null) {
                ((Bibliotecario) usuariologado).removerMidia(codigo1);
            } else {
                System.out.println("Mídia não encontrada");
            }
        }
    }

}
