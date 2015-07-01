package br.ufpi.es.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.ufpi.es.controller.Fachada;
import br.ufpi.es.controller.IFachada;
import br.ufpi.es.model.Aluno;
import br.ufpi.es.system.exception.AlunoNaoExistenteException;

public class AlunosTest {

	@Test
	public void addAluno() throws SQLException {
		IFachada fachada = new Fachada();
		// Instancia de alunos
		Aluno aluno1 = new Aluno("201100000", "Francisco Wermeson",
				"Ciência da Computação");
		Aluno aluno2 = new Aluno("201149100", "João", "Ciência da Computação");
		Aluno aluno3 = new Aluno("201149101", "Pedro", "Matemática");
		Aluno aluno4 = new Aluno("201149102", "Maria", "Matemática");
		Aluno aluno5 = new Aluno("201149103", "José", "Ciência da Computação");

		// Salvando alunos no repositório
		try {
			fachada.inserirAluno(aluno1);
			fachada.inserirAluno(aluno2);
			fachada.inserirAluno(aluno3);
			fachada.inserirAluno(aluno4);
			fachada.inserirAluno(aluno5);
			assertEquals(5, fachada.quantidadeAlunos());
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void buscarAluno() throws Exception {
		IFachada fachada = new Fachada();

		Aluno aluno1 = new Aluno("201100000", "Francisco Wermeson",
				"Ciência da Computação");
		Aluno aluno2 = new Aluno("201149101", "Pedro", "Matemática");

		fachada.inserirAluno(aluno1);
		fachada.inserirAluno(aluno2);
		try {
			aluno1 = fachada.buscarAluno("201100000");
			aluno2 = fachada.buscarAluno("201149101");

			assertNotNull(aluno1);
			assertNotNull(aluno2);

			assertEquals("201100000", aluno1.getMatricula()); // Matricula
			assertEquals("Francisco Wermeson", aluno1.getNome());
			assertEquals("Ciência da Computação", aluno1.getCurso());

			assertEquals("201149101", aluno2.getMatricula());
			assertEquals("Pedro", aluno2.getNome());
			assertEquals("Matemática", aluno2.getCurso());
		} catch (AlunoNaoExistenteException e) {
			assertTrue(false);
		}
	}

	@Test
	public void listaAlunos() throws Exception {
		IFachada fachada = new Fachada();
		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		Aluno aluno1 = new Aluno("201100000", "Francisco Wermeson",
				"Ciência da Computação");
		Aluno aluno2 = new Aluno("201149101", "Pedro", "Matemática");

		fachada.inserirAluno(aluno1);
		fachada.inserirAluno(aluno2);

		listaAlunos.add(aluno1);
		listaAlunos.add(aluno2);

		assertEquals(listaAlunos, fachada.listarAlunos());
		assertEquals(2, listaAlunos.size());

	}
}
