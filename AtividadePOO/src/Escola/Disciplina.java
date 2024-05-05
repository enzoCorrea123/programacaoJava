package Escola;

public class Disciplina {
	private String nome;
	private int codigo;
	private int cargaHoraria;
	private Prova prova;
	
	public Disciplina(String nome, int codigo, int cargaHoraria) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.cargaHoraria = cargaHoraria;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}
	
	
	
	
}
