package net.weg.topcar.controller;


import net.weg.topcar.dao.BancoAutomoveis;
import net.weg.topcar.dao.BancoCliente;
import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.*;
import net.weg.topcar.model.usuarios.*;
import net.weg.topcar.view.*;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    private static Cliente usuarioLogado;


    private final Entrada<Double> entradaDecimal = new EntradaDecimal();
    private final Entrada<Long> entradaInteiro = new EntradaInteiro();
    private final Entrada<String> entradaTexto = new EntradaTexto();

    private final Saida saida = new Saida();
    BancoCliente banco = new BancoCliente();
    BancoAutomoveis bancoAutomoveis = new BancoAutomoveis();

    public void verVendedores(){
        try{
            isGerente();
            saida.escreva(buscarVendedores().toString());
        }catch (AcessoNegadoException e) {
            saida.escreva(e.getMessage());
        }
    }
    public void verPagamentoVendedores(){
        try{
            isGerente();
            List<Vendedor> listaVendedores = buscarVendedores();
            for(Vendedor vendedor : listaVendedores){
                saida.escreva(vendedor.verPagamento());
            }
        }catch (AcessoNegadoException e){
            saida.escreva(e.getMessage());
        }
    }
    public void verPagamentoVendedor() throws TipoDeUsuarioInvalidoException {
        try{
            Cliente cliente = buscarCliente();
            if(cliente instanceof IVendedor vendedor){
                saida.escreva(vendedor.verPagamento());
            }else{
                throw new TipoDeUsuarioInvalidoException(cliente);
            }

        }catch (ObjetoNaoEncontradoException e){
            saida.escreva(e.getMessage());
        }
    }
    public void verMeusAutomoveis(){
        List<Automovel> meusAutomoveis = usuarioLogado.verMeusAutomoveis();
        for(Automovel automovel : meusAutomoveis){
            saida.escreva(automovel.toString());
        }
    }
    public void verUsuario() {
        try{
            isVendedor();
            Cliente cliente = buscarCliente();
            saida.escreva(cliente.toString());
        }catch (ObjetoNaoEncontradoException | AcessoNegadoException e){
            saida.escreva(e.getMessage());
        }
    }
    private Cliente buscarCliente() throws ObjetoNaoEncontradoException {
        Long cpf = entradaCpf();
        return banco.buscarUm(cpf);
    }

    private String entradaCodigo(){
        return entradaTexto.leiaComSaidaEValidacao("Código: ",saida);
    }

    private List<Vendedor> buscarVendedores(){
        List<Cliente> listClientes = banco.buscarTodos();
        return filtrarVendedores(listClientes);

    }
    private List<Vendedor> filtrarVendedores(List<Cliente> listClientes){
        List<Vendedor> listaVendedores = new ArrayList<>();

        for(Cliente cliente : listClientes){
            if(cliente instanceof Vendedor vendedor){
                listaVendedores.add(vendedor);
            }

        }

        return listaVendedores;
    }
    public void verClientes(){
        saida.escreva(banco.buscarTodos().toString());
    }
    public void removerUsuario(){
        if(usuarioLogado instanceof IGerente){
            try{
                Long cpf = entradaCpf();
                banco.remover(cpf);
            }catch (ObjetoNaoEncontradoException | AcessoNegadoException e){
                saida.escreva(e.getMessage());
            }
        }
    }
    public void cadastroUsuario() throws AcessoNegadoException, ObjetoNaoEncontradoException {
        String senha = null, nome = null;
        Long idade = null;
        try{
            Long cpf = entradaCpf();
            validaCpf(cpf);
            Cliente cliente;
            nome = entradaNome();
            idade = entradaIdade();
            senha = entradaSenha();

            if (usuarioLogado instanceof Gerente gerente) {
                IBanco<Cliente, Long> banco = null;
                Long escolha = escolhaUsuario();
                if (escolha == 1) {
                    Double salario = entradaSalario();
                    cadastroVendedor(nome, cpf, senha, idade, salario);
                    cliente = new Vendedor(nome, cpf, senha, idade, salario);
                    gerente.registrarUsuario(cliente, banco);
                }
            } else {
                cadastroCliente(nome, cpf, senha, idade);

            }
        }catch (Exception e){

        }

    }
    public void verPagamento(){
//        if(usuarioLogado instanceof IVendedor vendedor){
//            saida.escreva(vendedor.verPagamento());
//        }
        try{

            IVendedor vendedor = isVendedor();
            saida.escreva(vendedor.verPagamento());
        }catch (AcessoNegadoException e){
            saida.escreva(e.getMessage());
        }


    }
    private IVendedor isVendedor(){
        if(usuarioLogado instanceof IVendedor vendedor){
            return vendedor;
        }
        throw new AcessoNegadoException();

    }
    private IGerente isGerente(){
        if(usuarioLogado instanceof IGerente gerente){
            return gerente;
        }
        throw new AcessoNegadoException();
    }
    private Automovel buscarAutomovel(){
        String codigo = entradaCodigo();
        try {
            return bancoAutomoveis.buscarUm(codigo);
        } catch (ObjetoNaoEncontradoException e) {
            throw new RuntimeException(e);
        }
    }
    public void editarUsuario(){
        try {
            Cliente cliente = buscarCliente();
            if(!(cliente instanceof Gerente)){
                String nome = entradaNome(cliente.getNome());
                Long idade = entradaIdade(cliente.getIdade());
                if(cliente instanceof Vendedor vendedor){
                    Double salario = entradaSalario(vendedor.getSalario());
                    banco.alterar(vendedor.getCpf(), new Vendedor(nome, vendedor.getCpf(), vendedor.getSenha(), idade, salario));
                }else{
                    banco.alterar(cliente.getCpf(), new Cliente(nome, cliente.getCpf(), cliente.getSenha(), idade));
                }
            }
        } catch (ObjetoNaoEncontradoException e) {
            saida.escreva("Objeto não encontrado");
        }

    }
    public void vender(){
        IVendedor vendedor = isVendedor();
        if(usuarioLogado instanceof Vendedor vendedor){
            saida.escreva("Identifique o comprador:");
            try {
                Cliente cliente = buscarCliente();
                saida.escreva("Identifique o veículo:");
                Automovel automovel = buscarAutomovel();
                vendedor.vender(automovel, cliente);
                atualizarEnvolvidosNaVenda(cliente,vendedor,automovel);

            } catch (ObjetoNaoEncontradoException | FalhaNaCompraException e) {
                saida.escreva(e.getMessage());
            }
        }
    }
    private void atualizarEnvolvidosNaVenda(Cliente cliente, Vendedor vendedor, Automovel automovel) throws ObjetoNaoEncontradoException {
        banco.alterar(cliente.getCpf(), cliente);
        banco.alterar(vendedor.getCpf(),vendedor);
        bancoAutomoveis.alterar(automovel.getCODIGO(), automovel);
    }
    private void cadastroCliente(String nome, Long cpf, String senha, Long idade) {
        banco.adicionar(new Cliente(nome, cpf, senha, idade));
    }

    private void cadastroVendedor(String nome, Long cpf, String senha, Long idade, Double salario) {
        banco.adicionar(new Vendedor(nome, cpf, senha, idade, salario));

    }

    private Long escolhaUsuario(){
        return entradaInteiro.leiaComSaidaEValidacao("""
                    Qual o perfil de usuário?
                    1 - Vendedor;
                    Outro - Cliente.
                    """, saida);
    }
    private Long entradaCpf() {
        return entradaInteiro.leiaComSaidaEValidacao("Informe o seu CPF:", saida);
    }

    private Long entradaIdade() {
        return entradaInteiro.leiaComSaidaEValidacao("Informe a sua idade:", saida);
    }
    private Long entradaIdade(Long idade) {
        Long novaIdade = entradaInteiro.leiaComSaidaEValidacao("Informe a sua idade:", saida);
        if(idade <= 0){
            novaIdade = idade;
        }
        return novaIdade;
    }

    private String entradaNome() {
        return entradaTexto.leiaComSaidaEValidacao("Informe o seu nome:", saida);
    }
    private String entradaNome(String nome) {
        String novoNome = entradaTexto.leiaComSaidaEValidacao("Informe o seu nome:", saida);
        if(novoNome.isEmpty()){
            novoNome = nome;
        }
        return novoNome;
    }

    private String entradaSenha() {
        String senha, confSenha;
        do {
            senha = entradaTexto.leiaComSaidaEValidacao("Informe a sua senha:", saida);
            confSenha = entradaTexto.leiaComSaidaEValidacao("Confirme a sua senha:", saida);
        } while (!senha.equals(confSenha));
        return senha;
    }

    private Double entradaSalario() {
        return entradaDecimal.leiaComSaidaEValidacao("Salário: ", saida);
    }
    private Double entradaSalario(Double salario) {
        Double novoSalario = entradaDecimal.leiaComSaidaEValidacao("Salário: ", saida);
        if(novoSalario <= 0){
            novoSalario = salario;
        }
        return novoSalario;
    }

    private void validaCpf(Long cpf) throws UsuarioExistenteException {
        if(banco.existe(cpf)){
            throw new UsuarioExistenteException(cpf);
        }
    }

}
