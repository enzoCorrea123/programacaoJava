import Usuarios.*;
import Veiculos.*;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Usuario usuarioLogado;
    public static Usuario cliente = new Cliente("Kevin", "kevinca", "123");
    public static Usuario vendedor = new Vendedor("João", "winter", "123", 1200, 1);
    public static Usuario gerente = new Gerente("Enzo", "enzorc", "123", 5000, 2, 0.2);

    public static void main(String[] args) {
        Usuario.addUsuario(cliente);
        Usuario.addUsuario(vendedor);
        Usuario.addUsuario(gerente);
        login();

    }

    public static void login() {
        do {
            System.out.println("Bem vindo ao sistema de concessionária!\n1 - Login\n2 - Sair");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> {

                    System.out.println("Digite seu usuario:");
                    String usuario = sc.next();
                    System.out.println("Digite sua senha:");
                    String senha = sc.next();
                    usuarioLogado = Usuario.login(usuario, senha);


                    menu();
                }
                case 2 -> System.exit(0);

            }
        } while (usuarioLogado == null);

    }

    private static void menu() {
        do {
            System.out.println("1 - logout\n2 - Ver veiculos disponiveis\n3 - Ver veiculos comprados");
            if (usuarioLogado instanceof Funcionario) {
                System.out.println("4 - Vender Veiculo\n5 - Procurar Cliente\n6 - Ver pagamento");
            }
            if (usuarioLogado instanceof Gerente) {
                System.out.println("7 - Cadastrar veículos\n8 - Remover veículos\n9 - Editar veículos\n10 - Alterar preço\n" +
                        "11 - Cadastrar vendedor\n12 - Cadastrar cliente\n13 - Remover vendedor\n14 - Remover cliente\n" +
                        "15 - Editar vendedor\n16 - Editar cliente\n17 - Ver vendedores \n18 - Ver clientes\n" +
                        "19 - Ver pagamento de seus vendedores\n20 - Ver pagamentos de um vendedor");
            }
            int opcao = sc.nextInt();
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
                case 11 -> adicionarFuncionario();
                case 12 -> cadastrarCliente();
                case 13 -> removerFuncionario();
                case 14 -> removerCliente();
                case 15 -> editarVendedor();
                case 16 -> editarCliente();
                case 17 -> verVendedores();
                case 18 -> verClientes();
                case 19 -> verPagamentoVendedores();
                case 20 -> verPagamentoVendedor();
            }

        } while (usuarioLogado != null);
    }


    private static void logout() {
        usuarioLogado = null;
    }

    private static void verVeiculosDisponiveis() {
        System.out.println(Veiculo.getVeiculos());

    }

    private static void verVeiculosComprados() {
        System.out.println("Digite o nome de usuário:");
        String nome = sc.next();
        Usuario vendedor = Usuario.procurarUsuario(nome);
        System.out.println("Veiculos comprados por " + nome + ":" + vendedor.getVeiculos());

    }

    private static void venderVeiculo() {
        if (usuarioLogado instanceof Funcionario) {
            System.out.println("Digite o nome do cliente:");
            String nome = sc.next();
            System.out.println("Digite o código do veiculo:");
            int codigo = sc.nextInt();
            ((Funcionario) usuarioLogado).venderVeiculo(codigo, nome);
        }
    }

    private static void procurarCliente() {
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
        Usuario usuario = new Vendedor(nome, nomeUsuario, senha, salario, codigo);
        usuarioLogado.addUsuario(usuario);
    }

    private static void removerFuncionario() {
        if (usuarioLogado instanceof Gerente) {
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
        Usuario cliente = new Cliente(nome, nomeUsuario, senha);
        usuarioLogado.addUsuario(cliente);

    }

    private static void removerCliente() {
        if (usuarioLogado instanceof Gerente) {
            System.out.println("Digite o nome do cliente que deseja remover:");
            String nome = sc.next();
            Usuario cliente = Usuario.procurarUsuario(nome);
            usuarioLogado.removeUsuario(cliente);
        }
    }

    private static void editarCliente() {
        System.out.println("Digite o usuario do cliente que deseja editar:");
        String nome = sc.next();
        Usuario cliente = Usuario.procurarUsuario(nome);
        System.out.println("Digite o novo nome do cliente:");
        String nome1 = sc.next();
        System.out.println("Digite o novo nome de usuario:");
        String nomeUsuario = sc.next();
        System.out.println("Digite a nova senha do cliente:");
        String senha = sc.next();
        cliente.setNome(nome1);
        cliente.setUsuario(nomeUsuario);
        cliente.setSenha(senha);
        ((Gerente) usuarioLogado).editarUsuario(cliente);

    }

    private static void editarVendedor() {
        System.out.println("Digite o usuario do cliente que deseja editar:");
        String nome = sc.next();
        Usuario funcionario = Usuario.procurarUsuario(nome);
        System.out.println("Digite o novo nome do funcionário:");
        String nome1 = sc.next();
        System.out.println("Digite o novo nome de usuario:");
        String nomeUsuario = sc.next();
        System.out.println("Digite a nova senha do funcionário:");
        String senha = sc.next();
        System.out.println("Digite o novo salario do funcionário:");
        double salario = sc.nextDouble();
        System.out.println("Digite o novo código do funcionário:");
        int codigo = sc.nextInt();
        funcionario.setNome(nome1);
        funcionario.setUsuario(nomeUsuario);
        funcionario.setSenha(senha);
        ((Funcionario) funcionario).setCodigo(codigo);
        ((Funcionario) funcionario).setSalario(salario);
        ((Gerente) usuarioLogado).editarUsuario(funcionario);

    }

    private static void editarVeiculo() {
        System.out.println("Digite o código do veículo que deseja editar:");
        int codigo = sc.nextInt();
        Veiculo veiculo = Veiculo.procurarVeiculo(codigo);
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
            ((Carro) veiculo).setNumeroPortas(portas);
            ((Carro) veiculo).setTipo(tipo);
            ((Carro) veiculo).setCambio(cambio);
            ((Carro) veiculo).setCompleto(true);
        } else if (veiculo instanceof Moto) {
            System.out.println("Digite a nova cilindrada da moto:");
            int cilindrada = sc.nextInt();
            System.out.println("Digite a nova carenagem:");
            String carenagem = sc.next();
            System.out.println("Digite o novo estilo da moto:");
            String estilo = sc.next();
            System.out.println("Digite a partida da moto:");
            String partida = sc.next();
            ((Moto) veiculo).setPartida(partida);
            ((Moto) veiculo).setEstilo(estilo);
            ((Moto) veiculo).setCarenagem(carenagem);
            ((Moto) veiculo).setCilindrada(cilindrada);
        } else if (veiculo instanceof Caminhao) {
            System.out.println("Digite a nova carroceria do caminhão:");
            String carroceria = sc.next();
            System.out.println("Digite a nova tração do caminhão:");
            String tracao = sc.next();
            System.out.println("Digite a nova cabine do carro:");
            String cabine = sc.next();
            ((Caminhao) veiculo).setCarroceria(carroceria);
            ((Caminhao) veiculo).setTracao(tracao);
            ((Caminhao) veiculo).setCabine(cabine);

        }
        veiculo.setAno(ano);
        veiculo.setCor(cor);
        veiculo.setModelo(modelo);
        veiculo.setMarca(marca);
        veiculo.setPreco(preco);
        veiculo.setQuilometragem(quilometragem);
        veiculo.setCombustivel(combustivel);

        ((Gerente) usuarioLogado).editarVeiculos(veiculo);
    }

    private static void alterarPrecoVeiculo() {
        System.out.println("Digite o código do veículo que deseja editar:");
        int codigo = sc.nextInt();
        Veiculo veiculo = Veiculo.procurarVeiculo(codigo);
        System.out.println("Digite o novo preço do veículo:");
        double preco = sc.nextDouble();
        veiculo.setPreco(preco);

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

    private static void removerVeiculo() {
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
