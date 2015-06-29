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
				"Ci�ncia da Computa��o");
		Aluno a2 = new Aluno("201149100", "Jo�o", "Ci�ncia da Computa��o");
		Aluno a3 = new Aluno("201149101", "Pedro", "Matem�tica");
		Aluno a4 = new Aluno("201149102", "Maria", "Matem�tica");
		Aluno a5 = new Aluno("201149103", "Jos�", "Ci�ncia da Computa��o");

		// Salvando alunos no reposit�rio
		try {
			fachada.inserirAluno(a1);
			fachada.inserirAluno(a2);
			fachada.inserirAluno(a3);
			fachada.inserirAluno(a4);
			fachada.inserirAluno(a5);
			// testa a quantidade de alunos inseridos no reposit�rio.
			assertEquals(5, fachada.quantidadeAlunos());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void buscarAluno() throws Exception {
		IFachada fachada = new Fachada();

		Aluno aux1 = new Aluno("201100000", "Francisco Wermeson",
				"Ci�ncia da Computa��o");
		Aluno aux2 = new Aluno("201149101", "Pedro", "Matem�tica");

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

		// Fazendo a verifica��o das informa��es.
		assertNotNull(aux1);
		assertNotNull(aux2);

		assertEquals("201100000", aux1.getMatricula()); // Matricula
		assertEquals("Francisco Wermeson", aux1.getNome());
		assertEquals("Ci�ncia da Computa��o", aux1.getCurso());

		assertEquals("201149101", aux2.getMatricula());
		assertEquals("Pedro", aux2.getNome());
		assertEquals("Matem�tica", aux2.getCurso());
	}

	@Test
	public void listaAlunos() throws Exception {
		IFachada fachada = new Fachada();
		List<Aluno> lista = null;
		Aluno aux1 = new Aluno("201100000", "Francisco Wermeson",
				"Ci�ncia da Computa��o");
		Aluno aux2 = new Aluno("201149101", "Pedro", "Matem�tica");

		fachada.inserirAluno(aux1);
		fachada.inserirAluno(aux2);

		try {
			lista = fachada.listarAlunos();
		} catch (AlunosNaoCadastradosException e) {
			e.printStackTrace();
		}

		// testa as informa��es retornada.
		assertEquals(2, lista.size());
	}
}
