package Pessoa;

import java.util.ArrayList;

public abstract class Usuario {
	private String nome;
	private int idade;
	private String endereco;
	private ArrayList<Usuario> listaDeUsuario = new ArrayList<Usuario>();
	
	
	public Usuario(String nome, int idade, String endereco) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
	}

	

	public ArrayList<Usuario> getListaDeUsuario() {
		return listaDeUsuario;
	}



	protected abstract void cadastrar(Usuario usuario);
	
	
}
