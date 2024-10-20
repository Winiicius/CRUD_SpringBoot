package com.projeto.simpleCrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.projeto.simpleCrud.dao.interfaces.AlunoDAOInterface;
import com.projeto.simpleCrud.entity.Aluno;

@SpringBootApplication
public class SimpleCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AlunoDAOInterface aluno){
		return runner -> {

			// criandoAluno(aluno);

			// criarVariosAlunos(aluno);

			// BuscarAlunoPorId(aluno);

			// mostrarAlunos(aluno);

			// buscarAlunosPorCurso(aluno);

			// updateAluno(aluno);

			// deletarAluno(aluno);

			deletarTodosAlunos(aluno);

		};
	}

	private void criandoAluno(AlunoDAOInterface alunoInterface) {
		Aluno aluno = new Aluno("Winicius", "winicius.alexandre@academico.ifpb.edu.br", "Análise e Desenvolvimento de Sistemas", 5);
		alunoInterface.save(aluno);
		
	}

	private void criarVariosAlunos(AlunoDAOInterface alunoDAOInterface ){
		Aluno atos = new Aluno("Atos", "atos@academico.ifpb.edu.br", "Analise e Desenvolvimento de Sistemas", 3);
		Aluno robson = new Aluno("Robson", "robson@academico.ifpb.edu.br", "Tecnologo em Construção de Edifícios", 7);
		Aluno rharhuky = new Aluno("Rharhuky", "rharhuky@academico.ifpb.edu.br", "Engenharia Civil", 1);
		
		alunoDAOInterface.save(atos);
		alunoDAOInterface.save(robson);
		alunoDAOInterface.save(rharhuky);

	}

	private void BuscarAlunoPorId(AlunoDAOInterface alunoDAOInterface) {
		
		System.out.println(alunoDAOInterface.findById(5));
		System.out.println(alunoDAOInterface.findById(6));

	}

	private void mostrarAlunos(AlunoDAOInterface alunoDAOInterface) {

		for( Aluno aluno : alunoDAOInterface.findAll() ) {
			System.out.println(aluno);
		}
	}

	
	private void buscarAlunosPorCurso(AlunoDAOInterface alunoDAOInterface) {
		for(Aluno aluno : alunoDAOInterface.findByCurso("Engenharia Civil")){
			System.out.println(aluno);
		}
	}

	private void updateAluno(AlunoDAOInterface alunoDAOInterface){

		Aluno aluno = alunoDAOInterface.findById(2);
		aluno.setNome("Fred");
		aluno.setCurso("Intrumento Musical");
		aluno.setPeriodo(2);
		aluno.setEmail("fred@academico.ifpb.edu.br");

		alunoDAOInterface.update(aluno);

	}

	private void deletarAluno(AlunoDAOInterface alunoDAOInterface){
		alunoDAOInterface.delete(3);
	}

	private void deletarTodosAlunos(AlunoDAOInterface alunoDAOInterface){
		System.out.println(alunoDAOInterface.deleteAll());
	}


}
