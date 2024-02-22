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
    public static void logout() {
        usuariologado = null;
    }

    private static void login() {
        do {
            System.out.println("Usuario: ");
            String user = sc.next();
            System.out.println("Senha: ");
            String senha = sc.next();
            usuariologado = Usuario.login(user, senha);
            System.out.println(usuariologado);

        } while (usuariologado == null);
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
                case 0:
                    logout();
                    break;
                case 1:
                    System.out.println("Digite seu novo nome:");
                    String nome = sc.next();
                    usuariologado.alterarNome(nome);
                    break;
                case 2:
                    System.out.println("Digite sua nova senha:");
                    String senha = sc.next();
                    usuariologado.alterarSenha(senha);
                    break;
                case 3:
                    System.out.println(usuariologado.getEmprestimos());
                    break;
                case 4:
                    System.out.println(usuariologado);
                    break;
                case 5:
                    System.out.println("Digite o código da mídia:");
                    int codigo = sc.nextInt();
                    System.out.println(usuariologado.consultarMidia(codigo));
                    break;
                case 6:
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
                    break;
                case 7:
                    if (usuariologado instanceof Funcionario) {
                        System.out.println("Usuario:");
                        String user = sc.next();
                        System.out.println("Senha:");
                        String senha2 = sc.next();
                        Usuario usuario1 = Usuario.login(user, senha2);
                        if (usuario1 != null) {
                            ((Funcionario) usuariologado).removerUsuario(usuario1);
                        } else {
                            System.out.println("Usuário não encontrado");
                        }
                    }
                    break;
                case 8:
                    if (usuariologado instanceof Funcionario) {
                        System.out.println("Digite o código da mídia:");
                        int codigo1 = sc.nextInt();
                        System.out.println("Digite o nome do usuário");
                        String nomeUsuario = sc.next();
                        System.out.println("Digite a senha do usuário");
                        String senha1 = sc.next();
                        Usuario usuario1 = Usuario.login(nomeUsuario, senha1);
                        Midia midia = Midia.procurarMidia(codigo1);
                        if (midia != null && usuario1 != null) {
                            ((Funcionario) usuariologado).emprestarMidia(midia, usuario1);
                        } else {
                            System.out.println("Mídia ou usuário não encontrados");
                        }
                    }
                    break;
                case 9:
                    if (usuariologado instanceof Funcionario) {
                        System.out.println("Usuario:");
                        String user = sc.next();
                        System.out.println("Senha:");
                        String senha2 = sc.next();
                        Usuario usuario1 = Usuario.login(user, senha2);
                        if (usuario1 != null) {
                            System.out.println("Digite o código da mídia:");
                            int codigo1 = sc.nextInt();
                            Midia midia = Midia.procurarMidia(codigo1);
                            if (midia != null) {
                                ((Funcionario) usuariologado).devolverMidia(midia, usuario1);
                            } else {
                                System.out.println("Mídia não encontrada");
                            }
                        }

                    }
                    break;
                case 10:
                    System.out.println(((Funcionario) usuariologado).verMidias());
                    break;
                case 11:
                    if (usuariologado instanceof Bibliotecario) {
                        System.out.println("1 - Livro\n2 - Revista\n3 - Jornal\n4 - DVD");
                        int tipo = sc.nextInt();
                        switch (tipo) {
                            case 1:
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
                                break;
                            case 2:
                                System.out.println("Digite o gênero: ");
                                String genero1 = sc.next();
                                System.out.println("Digite a editora:");
                                String editora = sc.next();
                                System.out.println("Digite o código:");
                                int codigo2 = sc.nextInt();
                                Midia revista = new Revista(editora, genero1, codigo2);
                                ((Bibliotecario) usuariologado).cadastrarMidia(revista);
                                break;
                            case 3:
                                System.out.println("Digite a data: ");
                                String data = sc.next();
                                System.out.println("Digite o código:");
                                int codigo3 = sc.nextInt();
                                Midia jornal = new Jornal(data, codigo3);
                                ((Bibliotecario) usuariologado).cadastrarMidia(jornal);
                                break;
                            case 4:
                                System.out.println("Digite o diretor:");
                                String diretor = sc.next();
                                System.out.println("Digite o nome do filme: ");
                                String filme = sc.next();
                                System.out.println("Digite o código:");
                                int codigo4 = sc.nextInt();
                                Midia dvd = new DVD(diretor, filme, codigo4);
                                ((Bibliotecario) usuariologado).cadastrarMidia(dvd);
                                break;
                        }
                    }
                    break;
                case 12:
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
                    break;
            }
        }while(usuariologado != null);
    }


}
