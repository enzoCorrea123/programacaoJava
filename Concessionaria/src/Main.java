import Usuarios.*;
import Veiculos.*;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Usuario usuarioLogado;
    public static void main(String[] args) {
        System.out.println("Hello World!");


    }
    public static void login(){
        System.out.println("Bem vindo ao sistema de concessionária!\n1 - Login\n2 - Sair");
        int opcao = sc.nextInt();
        switch (opcao){
            case 1 -> {
                do{
                    System.out.println("Digite seu usuario:");
                    String usuario = sc.nextLine();
                    System.out.println("Digite sua senha:");
                    String senha = sc.nextLine();
                    usuarioLogado = Usuario.procurarUsuario(usuario);

                }while(usuarioLogado == null);
                menu();
            }
            case 2-> System.exit(0);

        }

    }

    private static void menu() {
        do{
            if(usuarioLogado instanceof Cliente){
                System.out.println("1 - logout\n2 - Ver veiculos disponiveis\n3 - Ver veiculos comprados\n4 - Ver perfil");

            }
            if(usuarioLogado instanceof Funcionario){
                System.out.println("5 - Vender Veiculo\n6 - Procurar Cliente\n7 - Ver pagamento");
            }
            if(usuarioLogado instanceof Gerente){
                System.out.println("8 - Adicionar Funcionario\n9 - Remover Funcionario\n10 - Cadastrar cliente\n11 - Remover Cliente\n12 - Editar veiculo\n13 - Alterar preço do veiculo\n14 - Cadastrar veiculo\n15 - Remover veiculo\n16 - Editar veiculo\n17 - Ver vendedores\n18 - Ver clientes\n19 - Ver pagamento dos seus vendedores\n20 - Ver pagamento de um vendedor");

            }
            int opcao = sc.nextInt();
            switch (opcao){
                case 1 -> logout();
                case 2 -> verVeiculosDisponiveis();
                case 3 -> verVeiculosComprados();
                case 4 -> verPerfil();
                case 5 -> venderVeiculo();
                case 6 -> procurarCliente();
                case 7 -> verPagamento();
                case 8 -> adicionarFuncionario();
                case 9 -> removerFuncionario();
                case 10 -> cadastrarCliente();
                case 11 -> removerCliente();
                case 12 -> editarVeiculo();
                case 13 -> alterarPrecoVeiculo();
                case 14 -> cadastrarVeiculo();
                case 15 -> removerVeiculo();
                case 16 -> editarVeiculo();
                case 17 -> verVendedores();
                case 18 -> verClientes();
                case 19 -> verPagamentoVendedores();
                case 20 -> verPagamentoVendedor();
            }

        }while(usuarioLogado != null);
    }




    private static void logout() {
        usuarioLogado = null;
    }
    private static void verVeiculosDisponiveis() {
    }
    private static void verVeiculosComprados() {
    }
    private static void verPerfil() {
        System.out.println(usuarioLogado.toString());
    }
    private static void venderVeiculo() {
    }
    private static void procurarCliente() {
        if(usuarioLogado instanceof Cliente){
            System.out.println("Digite o nome do cliente que deseja procurar:");
            String nome = sc.nextLine();
            Cliente cliente = Cliente.procurarCliente(nome);
            System.out.println(cliente.toString());
        }
    }
    private static void verPagamento() {
        if(usuarioLogado instanceof Funcionario){
            System.out.println("Seu pagamento é: " + ((Funcionario) usuarioLogado).getPagamentos());
        }
    }
    private static void adicionarFuncionario() {
        System.out.println("Digite o nome do funcionario que deseja adicionar:");
        String nome = sc.next();
        System.out.println("Digite o nome de usuario do funcionario:");
        String nomeUsuario = sc.next();
        System.out.println("Digite a senha do funcionario:");
        String senha = sc.next();
        System.out.println("Digite o salario do funcionario:");
        double salario = sc.nextDouble();
        System.out.println("Digite o código do funcionario:");
        int codigo = sc.nextInt();
        Usuario usuario = new Vendedor(nome,nomeUsuario,senha,salario,codigo);
        usuarioLogado.addUsuario(usuario);
    }
    private static void removerFuncionario() {
        if(usuarioLogado instanceof Gerente){
            System.out.println("Digite o nome do funcionario que deseja remover:");
            String nome = sc.next();
            Usuario usuario = Usuario.procurarUsuario(nome);
            usuarioLogado.removeUsuario(usuario);
        }
    }
    private static void cadastrarCliente() {
        System.out.println("Digite o nome do cliente que deseja adicionar:");
        String nome = sc.next();
        System.out.println("Digite o nome de usuario:");
        String nomeUsuario = sc.next();
        System.out.println("Digite a senha do cliente:");
        String senha = sc.next();
        Usuario cliente = new Cliente(nome,nomeUsuario,senha);
        usuarioLogado.addUsuario(cliente);

    }
    private static void removerCliente() {
        if(usuarioLogado instanceof Gerente){
            System.out.println("Digite o nome do cliente que deseja remover:");
            String nome = sc.next();
            Usuario cliente = Usuario.procurarUsuario(nome);
            usuarioLogado.removeUsuario(cliente);
        }
    }
    private static void editarVeiculo() {
    }
    private static void alterarPrecoVeiculo() {
    }
    private static void cadastrarVeiculo() {
        System.out.println("Qual veículo deseja adicionar?\n1 - Carro\n2 - Moto\n3 - Caminhão");
        int opcao = sc.nextInt();
        System.out.println("Digite o modelo do veiculo:");
        String modelo = sc.next();
        System.out.println("Digite a marca do veiculo:");
        String marca = sc.next();
        System.out.println("Digite o ano do veiculo:");
        int ano = sc.nextInt();
        System.out.println("Digite o preço do veiculo:");
        double preco = sc.nextDouble();
        System.out.println("Digite a cor do veículo:");
        String cor = sc.next();
        System.out.println("Digite a quilometragem do veículo:");
        double quilometragem = sc.nextDouble();
        System.out.println("Digite a alimentacao do veículo:");
        String alimentacao = sc.next();
        System.out.println("Digite o código do carro:");
        int codigo = sc.nextInt();

        switch (opcao){
            case 1 ->{
                System.out.println("Digite o tipo do carro:");
                String tipo = sc.next();
                System.out.println("Digite a quantidade de portas do carro:");
                int portas = sc.nextInt();
                System.out.println("Digite qual o câmbio do carro:");
                String cambio = sc.next();
                System.out.println("Digite se o carro é completo:\n1 - sim\n2 - não");
                int completo = sc.nextInt();
                boolean completo1 = false;
                if(completo == 1){
                    completo1 = true;
                }else if(completo == 2){
                    completo1 = false;
                }

                Veiculo carro = new Carro(tipo, portas, cambio, completo1, codigo, modelo, ano, marca, preco, cor, quilometragem, alimentacao);
                usuarioLogado.addVeiculo(carro);

            }
            case 2->{
                System.out.println("Digite a carenagem da moto:");
                String carenagem = sc.next();
                System.out.println("Digite a cilindrada da moto:");
                int cilindrada = sc.nextInt();
                System.out.println("Digite o estilo da moto:");
                String estilo = sc.next();
                System.out.println("Digite a partida da moto:");
                String partida = sc.next();

                Veiculo moto = new Moto(carenagem, cilindrada, estilo, partida, codigo, modelo, ano, marca, preco,cor, quilometragem, alimentacao);
                usuarioLogado.addVeiculo(moto);
            }
            case 3->{
                System.out.println("Digite a carroceria do caminhão:");
                String carroceria = sc.next();
                System.out.println("Digite a tração da carroceria:");
                String tracao = sc.next();
                System.out.println("Digite qual a cabine do caminhão:");
                String cabine = sc.next();

                Veiculo caminhao = new Caminhao(carroceria, tracao, cabine, codigo, modelo, ano, marca, preco, cor, quilometragem, alimentacao);
                usuarioLogado.addVeiculo(caminhao);

            }

        }
    }
    private static void removerVeiculo() {
        if(usuarioLogado instanceof Funcionario){
            System.out.println("Digite o codigo do veiculo que deseja remover:");
            int codigo = sc.nextInt();
            Veiculo veiculo = Veiculo.procurarVeiculo(codigo);
            usuarioLogado.removeVeiculo(veiculo);
        }
    }
    private static void verVendedores() {
    }
    private static void verClientes() {
    }
    private static void verPagamentoVendedores() {
    }
    private static void verPagamentoVendedor() {
    }
}
