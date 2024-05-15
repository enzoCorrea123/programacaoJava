package Pessoa;

import Escola.Disciplina;
import Escola.Prova;
import Escola.Turma;

public class Professor extends Usuario{
	private Disciplina disciplina;
	
	
	public Professor(String nome, int idade, String endereco, Disciplina disciplina) {
		super(nome, idade, endereco);
		this.disciplina = disciplina;
	}


	@Override
	protected void cadastrar(Usuario professor) {
		if(professor instanceof Professor) {
			getListaDeUsuario().add(professor);
			
		}
		
	}
	
	
	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}


	public String calcularMedia(Turma turma, Prova prova) {
		String txt = "Disciplina: " + disciplina + "\n";
		for (Aluno aluno : turma.getListaDeAlunos()) {
			Double media;
			media = (double) ((prova.getNota1() + prova.getNota2())/2);
			txt += "Aluno : " + aluno + " - " + media + "\n";
		}
		return txt;

	}
	public void controleDeNotas() {
		Turma.registrarProva(this);
	}
	

	
}
