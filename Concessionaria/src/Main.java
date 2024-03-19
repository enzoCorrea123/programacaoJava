import Exceptions.*;
import Usuarios.*;
import Veiculos.*;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Usuario usuarioLogado;
    public static Usuario cliente = new Cliente("Kevin", "kevinca", "123");
    public static Usuario vendedor = new Vendedor("João", "winter", "123", 1200, 1);
    public static Usuario gerente = new Gerente("Enzo", "enzorc", "123", 5000, 2, 0.2);

    public static void main(String[] args) throws AcessoNegadoException, OpcaoInvalidaException, UsuarioNaoEncontradoException {
        Usuario.addUsuario(cliente);
        Usuario.addUsuario(vendedor);
        Usuario.addUsuario(gerente);
        do {
            try {
                login();

                 do{
                    try {
                        menu();
                    } catch (OpcaoInvalidaException | AcessoNegadoException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Deseja ver as opções de novo?\n1 - sim\n2 - não");
                        int op = sc.nextInt();
                        if (op == 2) {
                            logout();
                        }
                    }
                }while (usuarioLogado != null);
            } catch (SenhaIncorretaException | UsuarioNaoEncontradoException e) {
                System.out.println(e.getMessage());
                System.out.println("Deseja realizar o login?\n1 - sim\n2 - não");
                int op = sc.nextInt();
                if (op == 2) {
                    System.exit(0);
                }
            }
        } while (true);

    }




    public static void login() throws UsuarioNaoEncontradoException, SenhaIncorretaException {
        System.out.println("Bem vindo ao sistema de concessionária!\n1 - Login\n2 - Sair");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {

                System.out.println("Digite seu usuario:");
                String usuario = sc.next();
                System.out.println("Digite sua senha:");
                String senha = sc.next();
                usuarioLogado = Usuario.login(usuario, senha);

            }
            case 2 -> System.exit(0);

        }

    }

    private static void menu() throws AcessoNegadoException, OpcaoInvalidaException {
        System.out.println(usuarioLogado.menu());
        int opcao = sc.nextInt();
        usuarioLogado.verificarOpcao(opcao);


        switch (opcao) {
            case 1 -> logout();
            case 2 -> verVeiculosDisponiveis();
            case 3 -> verVeiculosComprados();
            case 4 -> venderVeiculo();
            case 5 -> procurarCliente();
            case 6 -> verPagamento();
            case 7 -> cadastrarVeiculo();
            case 8 -> removerVeiculo();
            case 9 -> editarVeiculo();
            case 10 -> alterarPrecoVeiculo();
            case 11 -> cadastrarUsuario();
            case 12 -> removerUsuario();
            case 13 -> editarUsuario();
            case 14 -> verVendedores();
            case 15 -> verClientes();
            case 16 -> verPagamentoVendedores();
            case 17 -> verPagamentoVendedor();
        }

    }


    private static void logout() {
        usuarioLogado = null;
    }

    private static void verVeiculosDisponiveis() {
        System.out.println(Veiculo.getVeiculos());

    }

    private static void verVeiculosComprados() { // adicionar exception
        System.out.println("Digite o nome de usuário:");
        String nome = sc.next();
        Usuario vendedor = Usuario.procurarUsuario(nome);
        System.out.println("Veiculos comprados por " + nome + ":" + vendedor.getVeiculos());

    }

    private static void venderVeiculo() { // adicionar exception
        if (usuarioLogado instanceof Funcionario) {
            System.out.println("Digite o nome do cliente:");
            String nome = sc.next();
            System.out.println("Digite o código do veiculo:");
            int codigo = sc.nextInt();
            ((Funcionario) usuarioLogado).venderVeiculo(codigo, nome);
        }
    }


    private static void procurarCliente() {//adicionar exception
        if (usuarioLogado instanceof Funcionario) {
            System.out.println("Digite o nome do cliente que deseja procurar:");
            String nome = sc.next();
            Usuario vendedor = Usuario.procurarUsuario(nome);
            System.out.println(vendedor);
        }
    }

    private static void verPagamento() {
        if (usuarioLogado instanceof Funcionario) {
            System.out.println("Seu pagamento é: " + ((Funcionario) usuarioLogado).getPagamentos());
        }
    }

    private static void cadastrarUsuario() throws UsuarioExistenteException {//adicionar exception
        System.out.println("Deseja cadastrar cliente ou funcionário?\n1 - Cliente\n2 - Funcionário");
        int opcao = sc.nextInt();
        System.out.println("Digite o nome:");
        String nome = sc.next();
        System.out.println("Digite o nome de usuario:");
        String nomeUsuario = sc.next();
        System.out.println("Digite a senha:");
        String senha = sc.next();
        Usuario usuario = null;
        if (opcao == 1) {
            usuario = new Cliente(nome, nomeUsuario, senha);
        }
        if (opcao == 2) {
            System.out.println("Digite o salario do funcionario:");
            double salario = sc.nextDouble();
            System.out.println("Digite o código do funcionario:");
            int codigo = sc.nextInt();
            usuario = new Vendedor(nome, nomeUsuario, senha, salario, codigo);
        }
        if (usuario != null) {
            try{
                usuarioLogado.addUsuario(usuario);

            }catch (UsuarioExistenteException e){
                System.out.println(e.getMessage());//testar-+
            }
        }
    }

    private static void removerUsuario() {//adicionar exception
        if (usuarioLogado instanceof Gerente) {
            System.out.println("Digite o nome do funcionario que deseja remover:");
            String nome = sc.next();
            Usuario usuario = Usuario.procurarUsuario(nome);
            usuarioLogado.removeUsuario(usuario);
        }
    }

    private static void editarUsuario() {//adicionar exception
        System.out.println("Digite o usuario do usuario que deseja editar:");
        String nome = sc.next();
        Usuario usuario = Usuario.procurarUsuario(nome);
        Usuario novoUsuario = null;

        System.out.println("Digite o novo nome do usuario:");
        String nome1 = sc.next();
        System.out.println("Digite a nova senha do usuario:");
        String senha = sc.next();
        if (usuario instanceof Cliente) {
            novoUsuario = new Cliente(nome1, usuario.getUsuario(), senha);
        }
        if (usuario instanceof Vendedor) {
            System.out.println("Digite o novo salario do funcionário:");
            double salario = sc.nextDouble();
            System.out.println("Digite o novo código do funcionário:");
            int codigo = sc.nextInt();
            novoUsuario = new Vendedor(nome1, usuario.getUsuario(), senha, salario, codigo);
        }

        ((Gerente) usuarioLogado).editarUsuario(usuario, novoUsuario);

    }

    private static void editarVeiculo() {//adicionar exception
        System.out.println("Digite o código do veículo que deseja editar:");
        int codigo = sc.nextInt();
        Veiculo veiculo = Veiculo.procurarVeiculo(codigo);
        Veiculo novoVeiculo = null;
        System.out.println("Digite o novo modelo do veículo:");
        String modelo = sc.next();
        System.out.println("Digite a nova marca do veículo:");
        String marca = sc.next();
        System.out.println("Digite o novo ano do veículo:");
        int ano = sc.nextInt();
        System.out.println("Digite o novo preço do veículo:");
        double preco = sc.nextDouble();
        System.out.println("Digite a nova cor do veículo:");
        String cor = sc.next();
        System.out.println("Digite a nova quilometragem do veículo:");
        double quilometragem = sc.nextDouble();
        System.out.println("Digite o novo combustível:");
        String combustivel = sc.next();

        if (veiculo instanceof Carro) {
            System.out.println("Digite a nova quantidade de portas do veículo:");
            int portas = sc.nextInt();
            System.out.println("Digite o novo tipo do carro:");
            String tipo = sc.next();
            System.out.println("Digite o novo câmbio do carro:");
            String cambio = sc.next();
            novoVeiculo = new Carro(veiculo.getCodigo(), modelo, ano, cor, marca, quilometragem, combustivel, preco, tipo, portas, cambio, ((Carro) veiculo).isCompleto());
        } else if (veiculo instanceof Moto) {
            System.out.println("Digite a nova cilindrada da moto:");
            int cilindrada = sc.nextInt();
            System.out.println("Digite a nova carenagem:");
            String carenagem = sc.next();
            System.out.println("Digite o novo estilo da moto:");
            String estilo = sc.next();
            System.out.println("Digite a partida da moto:");
            String partida = sc.next();
            novoVeiculo = new Moto(veiculo.getCodigo(), modelo, ano, cor, marca, quilometragem, combustivel, preco, carenagem, cilindrada, estilo, partida);
        } else if (veiculo instanceof Caminhao) {
            System.out.println("Digite a nova carroceria do caminhão:");
            String carroceria = sc.next();
            System.out.println("Digite a nova tração do caminhão:");
            String tracao = sc.next();
            System.out.println("Digite a nova cabine do carro:");
            String cabine = sc.next();
            novoVeiculo = new Caminhao(veiculo.getCodigo(), modelo, ano, cor, marca, quilometragem, combustivel, preco, carroceria, tracao, cabine);

        }
        if (novoVeiculo != null) {
            ((Gerente) usuarioLogado).editarVeiculos(veiculo, novoVeiculo);

        }
    }

    private static void alterarPrecoVeiculo() { //adicionar exception
        System.out.println("Digite o código do veículo que deseja editar:");
        int codigo = sc.nextInt();
        Veiculo veiculo = Veiculo.procurarVeiculo(codigo);
        System.out.println("Digite o novo preço do veículo:");
        double preco = sc.nextDouble();
        veiculo.setPreco(preco);

    }

    private static void cadastrarVeiculo() { //adicionar exception
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
        System.out.println("Digite o combustível do veículo:");
        String combustivel = sc.next();
        System.out.println("Digite o código do carro:");
        int codigo = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.println("Digite o tipo do carro:");
                String tipo = sc.next();
                System.out.println("Digite a quantidade de portas do carro:");
                int portas = sc.nextInt();
                System.out.println("Digite qual o câmbio do carro:");
                String cambio = sc.next();
                System.out.println("Digite se o carro é completo:\n1 - sim\n2 - não");
                int completo = sc.nextInt();
                boolean completo1 = false;
                if (completo == 1) {
                    completo1 = true;
                } else if (completo == 2) {
                    completo1 = false;
                }

                Veiculo carro = new Carro(codigo, modelo, ano, cor, marca, quilometragem, combustivel, preco, tipo, portas, cambio, completo1);
                Veiculo.addVeiculo(carro);

            }
            case 2 -> {
                System.out.println("Digite a carenagem da moto:");
                String carenagem = sc.next();
                System.out.println("Digite a cilindrada da moto:");
                int cilindrada = sc.nextInt();
                System.out.println("Digite o estilo da moto:");
                String estilo = sc.next();
                System.out.println("Digite a partida da moto:");
                String partida = sc.next();

                Veiculo moto = new Moto(codigo, modelo, ano, cor, marca, quilometragem, combustivel, preco, carenagem, cilindrada, estilo, partida);
                Veiculo.addVeiculo(moto);
            }
            case 3 -> {
                System.out.println("Digite a carroceria do caminhão:");
                String carroceria = sc.next();
                System.out.println("Digite a tração da carroceria:");
                String tracao = sc.next();
                System.out.println("Digite qual a cabine do caminhão:");
                String cabine = sc.next();

                Veiculo caminhao = new Caminhao(codigo, modelo, ano, cor, marca, quilometragem, combustivel, preco, carroceria, tracao, cabine);
                Veiculo.addVeiculo(caminhao);

            }

        }
    }

    private static void removerVeiculo() { //adicionar exception
        if (usuarioLogado instanceof Funcionario) {
            System.out.println("Digite o codigo do veiculo que deseja remover:");
            int codigo = sc.nextInt();
            Veiculo veiculo = Veiculo.procurarVeiculo(codigo);
            usuarioLogado.removeVeiculo(veiculo);
        }
    }

    private static void verVendedores() {
        System.out.println(((Gerente) usuarioLogado).verVendedores());
    }

    private static void verClientes() {
        System.out.println(((Gerente) usuarioLogado).verClientes());
    }

    private static void verPagamentoVendedores() {
        System.out.println(((Gerente) usuarioLogado).verPagamentos());
    }

    private static void verPagamentoVendedor() {
        System.out.println("Digite o nome do vendedor que deseja ver o pagamento:");
        String nome = sc.next();

        Usuario vendedor = Usuario.procurarUsuario(nome);
        System.out.println(((Gerente) usuarioLogado).verPagamento(vendedor));

    }
}