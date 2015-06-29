package br.ufpi.es.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.ufpi.es.controller.Fachada;
import br.ufpi.es.controller.IFachada;
import br.ufpi.es.model.Aluno;
import br.ufpi.es.system.exception.AlunoNaoExistenteException;
import br.ufpi.es.system.exception.AlunosNaoCadastradosException;

public class AlunosTest {

	@Test
	public void addAluno() throws SQLException {
		IFachada fachada = new Fachada();
		// Instancia de alunos
		Aluno a1 = new Aluno("201100000", "Francisco Wermeson",
				"Ciência da Computação");
		Aluno a2 = new Aluno("201149100", "João", "Ciência da Computação");
		Aluno a3 = new Aluno("201149101", "Pedro", "Matemática");
		Aluno a4 = new Aluno("201149102", "Maria", "Matemática");
		Aluno a5 = new Aluno("201149103", "José", "Ciência da Computação");

		// Salvando alunos no repositório
		try {
			fachada.inserirAluno(a1);
			fachada.inserirAluno(a2);
			fachada.inserirAluno(a3);
			fachada.inserirAluno(a4);
			fachada.inserirAluno(a5);
			// testa a quantidade de alunos inseridos no repositório.
			assertEquals(5, fachada.quantidadeAlunos());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void buscarAluno() throws Exception {
		IFachada fachada = new Fachada();

		Aluno aux1 = new Aluno("201100000", "Francisco Wermeson",
				"Ciência da Computação");
		Aluno aux2 = new Aluno("201149101", "Pedro", "Matemática");

		fachada.inserirAluno(aux1);
		fachada.inserirAluno(aux2);
		// Fazendo a busca
		try {
			aux1 = fachada.buscarAluno("201100000");
			aux2 = fachada.buscarAluno("201149101");
		} catch (AlunoNaoExistenteException e) {
			e.printStackTrace();
			fail();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		// Fazendo a verificação das informações.
		assertNotNull(aux1);
		assertNotNull(aux2);

		assertEquals("201100000", aux1.getMatricula()); // Matricula
		assertEquals("Francisco Wermeson", aux1.getNome());
		assertEquals("Ciência da Computação", aux1.getCurso());

		assertEquals("201149101", aux2.getMatricula());
		assertEquals("Pedro", aux2.getNome());
		assertEquals("Matemática", aux2.getCurso());
	}

	@Test
	public void listaAlunos() throws Exception {
		IFachada fachada = new Fachada();
		List<Aluno> lista = null;
		Aluno aux1 = new Aluno("201100000", "Francisco Wermeson",
				"Ciência da Computação");
		Aluno aux2 = new Aluno("201149101", "Pedro", "Matemática");

		fachada.inserirAluno(aux1);
		fachada.inserirAluno(aux2);

		try {
			lista = fachada.listarAlunos();
		} catch (AlunosNaoCadastradosException e) {
			e.printStackTrace();
		}

		// testa as informações retornada.
		assertEquals(2, lista.size());
	}
}
