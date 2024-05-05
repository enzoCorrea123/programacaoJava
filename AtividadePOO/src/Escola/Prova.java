package Escola;

import java.util.ArrayList;

import Pessoa.Aluno;

public class Prova {
	private int nota1;
	private int nota2;
	private Aluno aluno;
	ArrayList<Disciplina> listaDeDisciplina = new ArrayList<Disciplina>();
	public Prova(int nota1, int nota2, Aluno aluno, Disciplina disciplina) {
		super();
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.aluno = aluno;
		setListaDeDisciplina(disciplina);
	}
	public ArrayList<Disciplina> getListaDeDisciplina() {
		return listaDeDisciplina;
	}
	public void setListaDeDisciplina(Disciplina disciplina) {
		this.listaDeDisciplina.add(disciplina);
	}
	public int getNota1() {
		return nota1;
	}
	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}
	public int getNota2() {
		return nota2;
	}
	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	

}
