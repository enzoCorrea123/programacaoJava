package Pessoa;
import java.util.ArrayList;

import Escola.Disciplina;
import Escola.Prova;
import Escola.Turma;

public class Aluno extends Usuario {
	private Turma turma;
	
	public Aluno(String nome, int idade, String endereco, Turma turma) {
		super(nome, idade, endereco);
		this.turma = turma;
	}

	@Override
	protected void cadastrar(Usuario aluno) {
		if(aluno instanceof Aluno) {
			getListaDeUsuario().add(aluno);
			
		}
		
	}
	
	public ArrayList<Double> calcularMedia(Prova prova) {
		ArrayList<Disciplina> disciplinas = prova.getListaDeDisciplina();
		ArrayList<Double> medias = new ArrayList<Double>();
		for(Disciplina disciplina : disciplinas) {
			Double media;
			media = (double) ((prova.getNota1() + prova.getNota2())/2);
			medias.add(media);
		}
		return medias;
	}
	

}
