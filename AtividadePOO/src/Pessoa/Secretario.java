package Pessoa;

import java.util.ArrayList;

import Escola.Disciplina;
import Escola.Prova;
import Escola.Turma;

public class Secretario extends Usuario{
	private int quantidadeBoletinsGerados;
	
	public Secretario(String nome, int idade, String endereco) {
		super(nome, idade, endereco);
		this.quantidadeBoletinsGerados = 0;
		
	}

	@Override
	protected void cadastrar(Usuario secretario) {
		if(secretario instanceof Secretario) {
			getListaDeUsuario().add(secretario);
			
		}
	
	}
	public Turma criarTurma(ArrayList<Aluno> listaDeAlunos, Professor professor) {
		Turma turma = new Turma(listaDeAlunos, professor);
		return turma;
		
	}
	public String gerarBoletins(Turma turma) {
		String txt = "";
		for(Aluno aluno : turma.getListaDeAlunos()) {
			txt += "Aluno: " + aluno + "\n";
			for(Disciplina disciplina : turma.getProfessor().getDisciplina().getProva().getListaDeDisciplina()) {
				txt += disciplina + "Nota 1: " + turma.getProfessor().getDisciplina().getProva().getNota1() + ""
						+ "\nNota 2: " + turma.getProfessor().getDisciplina().getProva().getNota2() + "\n\n";
			}
			quantidadeBoletinsGerados++;
		}
		return txt;
		
	}

	public int getQuantidadeBoletinsGerados() {
		return quantidadeBoletinsGerados;
	}
	
	
	

}
