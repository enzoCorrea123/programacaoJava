package Escola;
import java.util.ArrayList;
import java.util.Scanner;

import Pessoa.Aluno;
import Pessoa.Professor;

public class Turma {
	private static ArrayList<Aluno> listaDeAlunos = new ArrayList<>();
	private Professor professor;
	
	public Turma(ArrayList<Aluno> listaDeAlunos, Professor professor) {
		super();
		Turma.listaDeAlunos = listaDeAlunos;
		this.professor = professor;
	}
	
	
	public static ArrayList<Aluno> getListaDeAlunos() {
		return listaDeAlunos;
	}
	public static void setListaDeAlunos(Aluno aluno) {
		listaDeAlunos.add(aluno);
	}
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}


	public static void registrarProva(Professor professor) {
		ArrayList<Prova> listaDeProvas = new ArrayList<Prova>();
		Scanner sc = new Scanner(System.in);
		for(Aluno aluno : listaDeAlunos) {
			System.out.println("Digite a primeira nota:");
			int nota1 = sc.nextInt();
			System.out.println("Digite a segunda nota:");
			int nota2 = sc.nextInt();
			
			Prova prova = new Prova(nota1, nota2, aluno, professor.getDisciplina());
			listaDeProvas.add(prova);
		}
		
	}

	

}
