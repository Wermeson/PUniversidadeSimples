//package br.ufpi.es.test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.fail;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import org.junit.Test;
//
//import br.ufpi.es.controller.Fachada;
//import br.ufpi.es.controller.IFachada;
//import br.ufpi.es.model.Aluno;
//import br.ufpi.es.system.exception.AlunoNaoExistenteException;
//import br.ufpi.es.system.exception.AlunosNaoCadastradosException;
//
//public class BancoAlunosTest {	
//	/**================================ CRUD ALUNOS ================================ **/
//	
//	/**
//	 * Teste o método de cadastro de alunos.
//	 * @throws SQLException 
//	 */
//	@SuppressWarnings("unused")
//	@Test
//	public void addAluno() throws SQLException {
//		IFachada fachada = new Fachada();
//		//Instancia de alunos
//		Aluno a1 = new Aluno("201149099", "Saulo de Társio", "Ciência da Computação");
//		Aluno a2 = new Aluno("201149100", "João", "Ciência da Computação");
//		Aluno a3 = new Aluno("201149101", "Pedro", "Matemática");
//		Aluno a4 = new Aluno("201149102", "Maria", "Matemática");
//		Aluno a5 = new Aluno("201149103", "José", "Ciência da Computação");
//		
//		//Salvando alunos no repositório
//		try {
//			fachada.inserirAluno(a1);
//			fachada.inserirAluno(a2);
//			fachada.inserirAluno(a3);
//			fachada.inserirAluno(a4);
//			fachada.inserirAluno(a5);
//			assertEquals(5, fachada.quantidadeAlunos());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//			
//		
////		testa a quantidade de alunos inseridos no repositório.
//		
//	}
//	
//	/**
//	 * Método que testa a busca de um aluno.
//	 * @throws Exception 
//	 * @throws SQLException 
//	 */
//	@Test
//	public void buscarAluno() throws Exception{
//		IFachada fachada = new Fachada();
//		
//		Aluno aux1 = new Aluno("201149099", "Saulo de Társio", "Ciência da Computação");
//		Aluno aux2 = new Aluno("201149101", "Pedro", "Matemática");
//
//		fachada.inserirAluno(aux1);
//		fachada.inserirAluno(aux2);
//		//Fazendo a busca
//		try {
//			aux1 = fachada.buscarAluno("201149099");
//			aux2 = fachada.buscarAluno("201149101");
//		}catch (AlunoNaoExistenteException e) {
//			e.printStackTrace();
//			fail();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//		
//		//Fazendo a verificação das informações.
//		assertNotNull(aux1);
//		assertNotNull(aux2);
////		System.out.println("Nome: " + aux1.getNome());
////		System.out.println("Matricula: " + aux1.getMatricula());
//		
//		assertEquals("201149099", aux1.getMatricula()); //Matricula
//		assertEquals("Saulo de Társio", aux1.getNome());
//		assertEquals("Ciência da Computação", aux1.getCurso());
//		
//		assertEquals("201149101", aux2.getMatricula());
//		assertEquals("Pedro", aux2.getNome());
//		assertEquals("Matemática", aux2.getCurso());
//	}
////	
////	/**
////	 * testa o método de alteração de informações de um determinado aluno.
////	 * @throws SQLException 
////	 */
////	@Test
////	public void alterarAluno() throws SQLException{
////		IFachada fachada = new Fachada();
////		
////		Aluno aux1 = null;
////		Aluno aux2 = null;
////		Aluno aux3 = null;
////		
////		//Intancia de alunos
////		Aluno a1 = new Aluno("201149099", "Saulo de Társio", "Ciência da Computação");
////		Aluno a2 = new Aluno("201149100", "João", "Ciência da Computação");
////		Aluno a3 = new Aluno("201149101", "Pedro", "Matemática");
////		Aluno a4 = new Aluno("201149102", "Maria", "Matemática");
////		Aluno a5 = new Aluno("201149101", "José", "Ciência da Computação");
////		
////		//Salvando alunos no repositório
////		fachada.inserirAluno(a1);
////		fachada.inserirAluno(a2);
////		fachada.inserirAluno(a3);
////		fachada.inserirAluno(a4);
////		fachada.inserirAluno(a5);	
////		
////		try {
////			fachada.alterarAluno(2, "201149101", "Paulo"); //Nome
////			fachada.alterarAluno(3, "201149102", "Filosofia"); //curso
////			fachada.alterarAluno(1, "201149099", "107107107");
////			aux1 = fachada.buscarAluno("201149101");
////			aux2 = fachada.buscarAluno("201149102");
////			aux3 = fachada.buscarAluno("107107107");
////		} catch (AlunoNaoExistenteException e) {
////			e.printStackTrace();
////			fail();
////		}
////		
////		//Verifica as informações do aluno que teve os dados alteras
////		assertEquals("Paulo", aux1.getNome()); //Nome
////		assertEquals("Matemática",aux1.getCurso()); //curso
////		
////		assertEquals("Filosofia", aux2.getCurso());
////		assertEquals("Maria", aux2.getNome());
////		assertEquals("Saulo de Társio", aux3.getNome());
////	}
////	
//	/**
//	 * testa o método de remoção.
//	 * @throws Exception 
//	 */
////	@Test
////	public void removeAluno() throws Exception{
////		IFachada fachada = new Fachada();
////
////		
////		//Testa a quantidade de alunos que estão no repositório.
//////		assertEquals(5, fachada.quantidadeAlunos());
////		
////		//Remove dois alunos do repositório.
////		try {
////			fachada.removerAluno("201149100"); //Remove aluno João
////			fachada.removerAluno("201149102"); //Remove aluno Maria
////		} catch (AlunoNaoExistenteException e) {
////			e.printStackTrace();
////			fail();
////		} 
////		
////		//testa a quantidade alunos que ficaram no repositório
////		assertEquals(3, fachada.quantidadeAlunos());
////		
////		//Verifica a existencia de aluno
////	}
//
////	/**
////	 * testa o método de remoção.
////	 * @throws SQLException 
////	 */
////	@Test
////	public void verificaExistenciaAluno() throws SQLException{
////		IFachada fachada = new Fachada();
////		
////		//Intancia de alunos
////		Aluno a1 = new Aluno("201149099", "Saulo de Társio", "Ciência da Computação");
////		Aluno a2 = new Aluno("201149100", "João", "Ciência da Computação");
////		Aluno a3 = new Aluno("201149101", "Pedro", "Matemática");
////		Aluno a4 = new Aluno("201149102", "Maria", "Matemática");
////		Aluno a5 = new Aluno("201149103", "José", "Ciência da Computação");
////		
////		//Salvando alunos no repositório
////		fachada.inserirAluno(a1);
////		fachada.inserirAluno(a2);
////		fachada.inserirAluno(a3);
////		fachada.inserirAluno(a4);
////		fachada.inserirAluno(a5);
////		
////		//Testa a quantidade de alunos que estão no repositório.
////		assertEquals(5, fachada.quantidadeAlunos());
////		
////		//Remove dois alunos do repositório.
////		try {
////			fachada.removerAluno("201149100"); //Remove aluno João
////			fachada.removerAluno("201149102"); //Remove aluno Maria
////		}catch (AlunoNaoExistenteException e) {
////			e.printStackTrace();
////			fail();
////		} 
////		
////		//testa a quantidade alunos que ficaram no repositório
////		assertEquals(3, fachada.quantidadeAlunos());
////		
////		//Verifica a Existencia de alunos
////		assertFalse(fachada.verificaSeExisteAluno("201149100"));
////		assertFalse(fachada.verificaSeExisteAluno("201149102"));
////		assertTrue(fachada.verificaSeExisteAluno("201149099"));
////		assertTrue(fachada.verificaSeExisteAluno("201149103"));
////	}
////
//	/**
//	 * testa o método de remoção.
//	 * @throws Exception 
//	 */
//	@Test
//	public void listaAlunos() throws Exception{
//		IFachada fachada = new Fachada();
//		List<Aluno> lista = null;
//		Aluno aux1 = new Aluno("201149099", "Saulo de Társio", "Ciência da Computação");
//		Aluno aux2 = new Aluno("201149101", "Pedro", "Matemática");
//
//		fachada.inserirAluno(aux1);
//		fachada.inserirAluno(aux2);
//		
//		try {
//			lista = fachada.listarAlunos();
//		}catch (AlunosNaoCadastradosException e) {
//			e.printStackTrace();
//		}
//		
//		//testa as informações retornada.
//		assertEquals(2, lista.size());
//		
////		assertEquals("José", lista.get(2).getNome());
////		assertEquals("Ciência da Computação", lista.get(0).getCurso());
////		assertEquals("Matemática", lista.get(1).getCurso());
////		assertEquals("201149103", lista.get(2).getMatricula());
//	}
////	
////	/**Testa as exceções**/
////	
////	/**
////	 * Método que testa a busca de um aluno.
////	 * @throws SQLException 
////	 */
////	@Test
////	public void buscarAlunoException() throws SQLException{
////		IFachada fachada = new Fachada();
////		
////		Aluno aux1 = null;
////		Aluno aux2 = null;
////		
////		//Intancia de alunos
////		Aluno a1 = new Aluno("201149099", "Saulo de Társio", "Ciência da Computação");
////		Aluno a2 = new Aluno("201149100", "João", "Ciência da Computação");
////		Aluno a3 = new Aluno("201149101", "Pedro", "Matemática");
////		Aluno a4 = new Aluno("201149102", "Maria", "Matemática");
////		Aluno a5 = new Aluno("201149101", "José", "Ciência da Computação");
////		
////		//Salvando alunos no repositório
////		fachada.inserirAluno(a1);
////		fachada.inserirAluno(a2);
////		fachada.inserirAluno(a3);
////		fachada.inserirAluno(a4);
////		fachada.inserirAluno(a5);
////		
////		//Fazendo a busca
////		try {
////			aux1 = fachada.buscarAluno("2011492");
////			aux2 = fachada.buscarAluno("2011491");
////		}catch (AlunoNaoExistenteException e) {
////			System.out.println(e.getMessage());
////		}
////	}
////	
////	/**
////	 * Testa o método de listagem quando não há alunos inseridos no repositório.
////	 */
////	@Test
////	public void listaAlunos2(){
////		IFachada fachada = new Fachada();
////		List<Aluno> lista = null;
////		
////		try {
////			lista = fachada.listarAlunos();
////		} catch (AlunosNaoCadastradosException e) {
////			System.out.println(e.getMessage());
////		}
////	}
////	
////	/**=====================================================================================================**/
////	
////	/**
////	 * testa o método que salva um professor no repositóri de alunos.
////	 */
////	@Test
////	public void addProfessor(){
////		IFachada fachada = new Fachada();
////		
////		//Intancia de alunos
////		Professor p1 = new Professor("123.123.123-01", "Professor 1", "Lotação 1", "Mestre");
////		Professor p2 = new Professor("123.123.123-02", "Professor 2", "Lotação 1", "Doutor");
////		Professor p3 = new Professor("123.123.123-03", "Professor 3", "Lotação 2", "Mestre");
////		Professor p4 = new Professor("123.123.123-04", "Professor 4", "Lotação 3", "Doutor");
////		Professor p5 = new Professor("123.123.123-05", "Professor 5", "Lotação 3", "Doutor");
////		
////		//Inserindo professores no repositório.
////		fachada.inserirProfessor(p1);
////		fachada.inserirProfessor(p2);
////		fachada.inserirProfessor(p3);
////		fachada.inserirProfessor(p4);
////		fachada.inserirProfessor(p5);
////		
////		//verificando a quantidade de professores inseridos no repositório.
////		assertEquals(5, fachada.quantidadeProfessores());
////	}
////	
////	/**
////	 * Testa o metódo de pesquisa de um professor.
////	 */
////	@Test
////	public void buscarrProfessor1(){
////		IFachada fachada = new Fachada();
////		Professor p_aux1 = null;
////		Professor p_aux2 = null;
////		
////		//Intancia de alunos
////		Professor p1 = new Professor("123.123.123-01", "Professor 1", "Lotação 1", "Mestre");
////		Professor p2 = new Professor("123.123.123-02", "Professor 2", "Lotação 1", "Doutor");
////		Professor p3 = new Professor("123.123.123-03", "Professor 3", "Lotação 2", "Mestre");
////		Professor p4 = new Professor("123.123.123-04", "Professor 4", "Lotação 3", "Doutor");
////		Professor p5 = new Professor("123.123.123-05", "Professor 5", "Lotação 3", "Doutor");
////		
////		//Salva os professores no repositório.
////		fachada.inserirProfessor(p1);
////		fachada.inserirProfessor(p2);
////		fachada.inserirProfessor(p3);
////		fachada.inserirProfessor(p4);
////		fachada.inserirProfessor(p5);
////		
////		//Faz a a busca
////		try {
////			p_aux1 = fachada.buscarProfessor("123.123.123-03");
////			p_aux2 = fachada.buscarProfessor("123.123.123-05");
////		} catch (ProfessorNaoExistenteException e) {
////			e.printStackTrace();
////			fail();
////		}
////		
////		//testas as informações.
////		assertNotNull(p_aux1);
////		assertNotNull(p_aux2);
////		
////		assertEquals("Professor 3", p_aux1.getNome());
////		assertEquals("Mestre", p_aux1.getTitulo());
////		assertEquals("Professor 5", p_aux2.getNome());
////		assertEquals("Lotação 3", p_aux2.getLotacao());
////	}
////	
////	/**
////	 * Testa a busca em caso de falhas.
////	 */
////	@Test
////	public void buscarProfessor2(){
////		IFachada fachada = new Fachada();
////		Professor p_aux1 = null;
////		Professor p_aux2 = null;
////		
////		//Intancia de alunos
////		Professor p1 = new Professor("123.123.123-01", "Professor 1", "Lotação 1", "Mestre");
////		Professor p2 = new Professor("123.123.123-02", "Professor 2", "Lotação 1", "Doutor");
////		Professor p3 = new Professor("123.123.123-03", "Professor 3", "Lotação 2", "Mestre");
////		Professor p4 = new Professor("123.123.123-04", "Professor 4", "Lotação 3", "Doutor");
////		Professor p5 = new Professor("123.123.123-05", "Professor 5", "Lotação 3", "Doutor");
////		
////		//Salva os professores no repositório.
////		fachada.inserirProfessor(p1);
////		fachada.inserirProfessor(p2);
////		fachada.inserirProfessor(p3);
////		fachada.inserirProfessor(p4);
////		fachada.inserirProfessor(p5);
////		
////		//Faz a a busca
////		try {
////			p_aux1 = fachada.buscarProfessor("123.123.123-222");
////			p_aux2 = fachada.buscarProfessor("123.123.123-23");
////		}catch (ProfessorNaoExistenteException e) {
////			e.getMessage();
////		}
////	}
////	
////	/**
////	 * testa o método que verifica se um determinado professor existe no repositório.
////	 */
////	@Test
////	public void verificaExistenciaProfessor(){
////		IFachada fachada = new Fachada();
////		
////		//Intancia de alunos
////		Professor p1 = new Professor("123.123.123-01", "Professor 1", "Lotação 1", "Mestre");
////		Professor p2 = new Professor("123.123.123-02", "Professor 2", "Lotação 1", "Doutor");
////		Professor p3 = new Professor("123.123.123-03", "Professor 3", "Lotação 2", "Mestre");
////		Professor p4 = new Professor("123.123.123-04", "Professor 4", "Lotação 3", "Doutor");
////		Professor p5 = new Professor("123.123.123-05", "Professor 5", "Lotação 3", "Doutor");
////		
////		//Salva os professores no repositório.
////		fachada.inserirProfessor(p1);
////		fachada.inserirProfessor(p2);
////		fachada.inserirProfessor(p3);
////		fachada.inserirProfessor(p4);
////		fachada.inserirProfessor(p5);
////		
////		//Verificado o retorno do método.
////		assertTrue(fachada.verificaExistenciaProfessor("123.123.123-05"));
////		assertFalse(fachada.verificaExistenciaProfessor("123.113.123-05"));
////		assertTrue(fachada.verificaExistenciaProfessor("123.123.123-02"));
////	
////	}
////	
////	/**
////	 * testa o método que altera as informações de um professor.
////	 */
////	@Test
////	public void alterarProfessor(){
////		IFachada fachada = new Fachada();
////		
////		Professor p1_aux = null;
////		Professor p2_aux = null;
////		Professor p3_aux = null;
////		
////		//Intancia de alunos
////		Professor p1 = new Professor("123.123.123-01", "Professor 1", "Lotação 1", "Mestre");
////		Professor p2 = new Professor("123.123.123-02", "Professor 2", "Lotação 1", "Doutor");
////		Professor p3 = new Professor("123.123.123-03", "Professor 3", "Lotação 2", "Mestre");
////		Professor p4 = new Professor("123.123.123-04", "Professor 4", "Lotação 3", "Doutor");
////		Professor p5 = new Professor("123.123.123-05", "Professor 5", "Lotação 3", "Doutor");
////		
////		//Salva os professores no repositório.
////		fachada.inserirProfessor(p1);
////		fachada.inserirProfessor(p2);
////		fachada.inserirProfessor(p3);
////		fachada.inserirProfessor(p4);
////		fachada.inserirProfessor(p5);
////		
////		//fazendo as alterações.
////		try {
////			fachada.alterarProfessor(2, "123.123.123-04", "Saulo de Társio");
////			fachada.alterarProfessor(3, "123.123.123-02", "Lotação X");
////			fachada.alterarProfessor(4, "123.123.123-05", "Ph. D.");
////		} catch (ProfessorNaoExistenteException e) {
////			System.out.println(e.getMessage());
////		}
////		
////		//Verificando as novas informações do professores.
////		try {
////			p1_aux = fachada.buscarProfessor("123.123.123-04");
////			p2_aux = fachada.buscarProfessor("123.123.123-02");
////			p3_aux = fachada.buscarProfessor("123.123.123-05");
////			fachada.alterarProfessor(1, "123.123.123-05", "123.123.123-10");
////		} catch (ProfessorNaoExistenteException e) {
////			e.printStackTrace();
////		}
////		
////		assertEquals("Saulo de Társio", p1_aux.getNome());
////		assertEquals("Lotação X", p2_aux.getLotacao());
////		assertEquals("Ph. D.", p3_aux.getTitulo());
////	}
////	
////	/**
////	 * testa o método de remoção de um determinado professor.
////	 */
////	@Test
////	public void removerProfessor(){
////		IFachada fachada = new Fachada();
////		
////		Professor p1_aux = null;
////		Professor p2_aux = null;
////		Professor p3_aux = null;
////		
////		//Intancia de alunos
////		Professor p1 = new Professor("123.123.123-01", "Professor 1", "Lotação 1", "Mestre");
////		Professor p2 = new Professor("123.123.123-02", "Professor 2", "Lotação 1", "Doutor");
////		Professor p3 = new Professor("123.123.123-03", "Professor 3", "Lotação 2", "Mestre");
////		Professor p4 = new Professor("123.123.123-04", "Professor 4", "Lotação 3", "Doutor");
////		Professor p5 = new Professor("123.123.123-05", "Professor 5", "Lotação 3", "Doutor");
////		
////		//Salva os professores no repositório.
////		fachada.inserirProfessor(p1);
////		fachada.inserirProfessor(p2);
////		fachada.inserirProfessor(p3);
////		fachada.inserirProfessor(p4);
////		fachada.inserirProfessor(p5);
////		
////		assertEquals(5, fachada.quantidadeProfessores());
////		
////		//Remove 3 professores
////		try {
////			fachada.removerProfessor("123.123.123-04");
////			fachada.removerProfessor("123.123.123-02");
////			fachada.removerProfessor("123.123.123-03");
////		}catch (ProfessorNaoExistenteException e) {
////			e.printStackTrace();
////		}
////		
////		//testa a quantidade professores.
////		assertEquals(2, fachada.quantidadeProfessores());
////		
////		//Verifica a existencia de dois dos professore removidos.
////		assertFalse(fachada.verificaExistenciaProfessor("123.123.123-02"));
////		assertFalse(fachada.verificaExistenciaProfessor("123.123.123-03"));
////	}
////	
////	/**
////	 * testa o método de listagem de todos os professores.
////	 */
////	@Test
////	public void listarProfessores1(){
////		IFachada fachada = new Fachada();
////		
////		List<Professor> l = null;
////		
////		Professor p1_aux = null;
////		Professor p2_aux = null;
////		Professor p3_aux = null;
////		
////		//Intancia de alunos
////		Professor p1 = new Professor("123.123.123-01", "Professor 1", "Lotação 1", "Mestre");
////		Professor p2 = new Professor("123.123.123-02", "Professor 2", "Lotação 1", "Ph. D.");
////		Professor p3 = new Professor("123.123.123-03", "Professor 3", "Lotação 2", "Mestre");
////		Professor p4 = new Professor("123.123.123-04", "Professor 4", "Lotação 3", "Doutor");
////		Professor p5 = new Professor("123.123.123-05", "Professor 5", "Lotação 3", "Doutor");
////		
////		//Salva os professores no repositório.
////		fachada.inserirProfessor(p1);
////		fachada.inserirProfessor(p2);
////		fachada.inserirProfessor(p3);
////		fachada.inserirProfessor(p4);
////		fachada.inserirProfessor(p5);
////		
////		//Busca que retorna todos os professores.
////		try {
////			l = fachada.listarProfessores();
////		}catch (ProfessoresNaoCadastradosException e) {
////			e.printStackTrace();
////		}
////		
////		//Verificando a quantidade de professores.
////		assertEquals(5, l.size());
////		
////		//Testando algumas informações.
////		assertEquals("Professor 5", l.get(4).getNome());
////		assertEquals("Lotação 3", l.get(4).getLotacao());
////		assertEquals("Ph. D.", l.get(1).getTitulo());
////	}
////	
////	/**
////	 * testa o método de listagem de todos os professores quando há algum erro.
////	 */
////	@Test
////	public void listarProfessores2(){
////		IFachada fachada = new Fachada();
////		
////		List<Professor> l = null;
////		
////		Professor p1_aux = null;
////		Professor p2_aux = null;
////		Professor p3_aux = null;
////		
////		//Intancia de alunos
////		Professor p1 = new Professor("123.123.123-01", "Professor 1", "Lotação 1", "Mestre");
////		Professor p2 = new Professor("123.123.123-02", "Professor 2", "Lotação 1", "Ph. D.");
////		Professor p3 = new Professor("123.123.123-03", "Professor 3", "Lotação 2", "Mestre");
////		Professor p4 = new Professor("123.123.123-04", "Professor 4", "Lotação 3", "Doutor");
////		Professor p5 = new Professor("123.123.123-05", "Professor 5", "Lotação 3", "Doutor");
////		
////		//Salva os professores no repositório.
//////		fachada.inserirProfessor(p1);
//////		fachada.inserirProfessor(p2);
//////		fachada.inserirProfessor(p3);
//////		fachada.inserirProfessor(p4);
//////		fachada.inserirProfessor(p5);
////		
////		//Busca que retorna todos os professores.
////		try {
////			l = fachada.listarProfessores();
////		}catch (ProfessoresNaoCadastradosException e) {
////			System.out.println(e.getMessage());
////		}
////	}
////
/////**=====================================================================================================**/
////	
////	/**
////	 * Teste o método de cadastro de uma turma.
////	 */
////	@Test
////	public void addTurma() {
////		IFachada fachada = new Fachada();
////		//Intancia de Turma
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		Turma t3 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral I", 90);
////		Turma t4 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral II", 90);
////		Turma t5 = new Turma("Departamento de Letras", "Inglês Instrumental", 60);
////		
////		//Salvando alunos no repositório
////		fachada.inserirTurma(t1);
////		fachada.inserirTurma(t2);
////		fachada.inserirTurma(t3);
////		fachada.inserirTurma(t4);
////		fachada.inserirTurma(t5);
////		
////		//testa a quantidade de alunos inseridos no repositório.
////		assertEquals(5, fachada.quantidadeTurma());
////	}
////	
////	/**
////	 * Testa o metódo de pesquisa de uma turma.
////	 */
////	@Test
////	public void buscarrTurma1(){
////		IFachada fachada = new Fachada();
////		
////		Turma t_aux1 = null;
////		Turma t_aux2 = null;
////		
////		//Intancia de Turma
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		Turma t3 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral I", 90);
////		Turma t4 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral II", 90);
////		Turma t5 = new Turma("Departamento de Letras", "Inglês Instrumental", 60);
////		
////		//Salvando alunos no repositório
////		fachada.inserirTurma(t1);
////		fachada.inserirTurma(t2);
////		fachada.inserirTurma(t3);
////		fachada.inserirTurma(t4);
////		fachada.inserirTurma(t5);
////		
////		//Faz a a busca
////		try {
////			t_aux1 = fachada.buscarTurma("Inglês Instrumental");
////			t_aux2 = fachada.buscarTurma("Cálculo Diferencial e Integral II");
////		}catch (TurmaNaoExistenteException e) {
////			e.printStackTrace();
////			fail();
////		}
////		
////		//testas as informações.
////		assertNotNull(t_aux1);
////		assertNotNull(t_aux2);
////		
////		assertEquals("Departamento de Letras", t_aux1.getDepartamento());
////		assertEquals("Departamento de Matemática", t_aux2.getDepartamento());
////		assertEquals(60, t_aux1.getCargaHoraria());
////		assertEquals(90, t_aux2.getCargaHoraria());
////	}
////	
////	/**
////	 * Testa a busca em caso de falhas.
////	 */
////	@Test
////	public void buscarTurma2(){
////		IFachada fachada = new Fachada();
////		
////		Turma t_aux1 = null;
////		Turma t_aux2 = null;
////		
////		//Intancia de Turma
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		Turma t3 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral I", 90);
////		Turma t4 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral II", 90);
////		Turma t5 = new Turma("Departamento de Letras", "Inglês Instrumental", 60);
////		
////		
////		//Faz a a busca
////		try {
////			t_aux1 = fachada.buscarTurma("Inglês Instrumental");
////			t_aux2 = fachada.buscarTurma("Cálculo Diferencial e Integral II");
////		}catch (TurmaNaoExistenteException e) {
////			System.out.println(e.getMessage());
////		}
////	}
////	
////	/**
////	 * testa o método que verifica se uma determinada turma existe no repositório.
////	 */
////	@Test
////	public void verificaExistenciaTurma(){
////		IFachada fachada = new Fachada();
////		
////		Turma t_aux1 = null;
////		Turma t_aux2 = null;
////		
////		//Intancia de Turma
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		Turma t3 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral I", 90);
////		Turma t4 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral II", 90);
////		Turma t5 = new Turma("Departamento de Letras", "Inglês Instrumental", 60);
////		
////		//Salvando alunos no repositório
////		fachada.inserirTurma(t1);
////		fachada.inserirTurma(t2);
////		fachada.inserirTurma(t3);
////		fachada.inserirTurma(t4);
////		fachada.inserirTurma(t5);
////		
////		//Verificando a existencia das turmas
////		assertTrue(fachada.verificaExistenciaTurma("Engenharia de Software I"));
////		assertFalse(fachada.verificaExistenciaTurma("Inteligência Artificial"));
////		assertTrue(fachada.verificaExistenciaTurma("Inglês Instrumental"));
////		assertFalse(fachada.verificaExistenciaTurma("Matemática Discreta"));
////	}
////	
////	/**
////	 * testa o método que altera as informações de uma turma.
////	 */
////	@Test
////	public void alterarTurma(){
////		IFachada fachada = new Fachada();
////		
////		Turma t1_aux = null;
////		Turma t2_aux = null;
////		
////		//Intancia de Turma
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		Turma t3 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral I", 90);
////		Turma t4 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral II", 90);
////		Turma t5 = new Turma("Departamento de Letras", "Inglês Instrumental", 60);
////		
////		//Salvando alunos no repositório
////		fachada.inserirTurma(t1);
////		fachada.inserirTurma(t2);
////		fachada.inserirTurma(t3);
////		fachada.inserirTurma(t4);
////		fachada.inserirTurma(t5);
////		
////		//fazendo as alterações.
////		try {
////			fachada.alterarTurma(1, "Cálculo Diferencial e Integral I", "Departamento de Computação");
////			fachada.alterarTurma(3, "Inglês Instrumental", "90");
////		}catch (TurmaNaoExistenteException e) {
////			System.out.println(e.getMessage());
////		}
////		
////		//Verificando as novas informações do professores.
////		try {
////			t1_aux = fachada.buscarTurma("Cálculo Diferencial e Integral I");
////			t2_aux = fachada.buscarTurma("Inglês Instrumental");
////			fachada.alterarTurma(2, "Cálculo Diferencial e Integral II", "Matemática Discreta");
////		}catch (TurmaNaoExistenteException e) {
////			e.printStackTrace();
////		}
////		
////		assertEquals("Departamento de Computação", t1_aux.getDepartamento());
////		assertEquals(90, t2_aux.getCargaHoraria());
////		assertFalse(fachada.verificaExistenciaTurma("Cálculo Diferencial e Integral II"));
////	}
////	
////	/**
////	 * testa o método de remoção de uma determinada turma.
////	 */
////	@Test
////	public void removerTurma(){
////		IFachada fachada = new Fachada();
////		
////		Turma t1_aux = null;
////		Turma t2_aux = null;
////		
////		//Intancia de Turma
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		Turma t3 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral I", 90);
////		Turma t4 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral II", 90);
////		Turma t5 = new Turma("Departamento de Letras", "Inglês Instrumental", 60);
////		
////		//Salvando alunos no repositório
////		fachada.inserirTurma(t1);
////		fachada.inserirTurma(t2);
////		fachada.inserirTurma(t3);
////		fachada.inserirTurma(t4);
////		fachada.inserirTurma(t5);
////		
////		assertEquals(5, fachada.quantidadeTurma());
////		
////		//Remove 3 professores
////		try {
////			fachada.removerTurma("Cálculo Diferencial e Integral II");
////			fachada.removerTurma("Inglês Instrumental");
////		}catch (TurmaNaoExistenteException e) {
////			e.printStackTrace();
////		}
////		
////		//testa a quantidade professores.
////		assertEquals(3, fachada.quantidadeTurma());
////		
////		//verificando a existencia das turmas removidas
////		assertFalse(fachada.verificaExistenciaTurma("Inglês Instrumental"));
////		assertFalse(fachada.verificaExistenciaTurma("Cálculo Diferencial e Integral II"));
////	}
////	
////	/**
////	 * testa o método de listagem de todos as turmas.
////	 */
////	@Test
////	public void listarTurmas1(){
////		IFachada fachada = new Fachada();
////		
////		List<Turma> l = null;
////		
////		Turma t1_aux = null;
////		Turma t2_aux = null;
////		
////		//Intancia de Turma
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		Turma t3 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral I", 90);
////		Turma t4 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral II", 90);
////		Turma t5 = new Turma("Departamento de Letras", "Inglês Instrumental", 60);
////		
////		//Salvando alunos no repositório
////		fachada.inserirTurma(t1);
////		fachada.inserirTurma(t2);
////		fachada.inserirTurma(t3);
////		fachada.inserirTurma(t4);
////		fachada.inserirTurma(t5);
////		
////		//Listagem
////		try{
////			l = fachada.listarTurmas();
////		}catch(TurmasNaoCadastradasException e){
////			System.out.println(e.getMessage());
////		}
////		
////		//Verificando a quantidade turmas retornadas.
////		assertEquals(5, fachada.quantidadeTurma());
////		
////		
////		//Testando algumas informações.
////		assertEquals("Departamento de Letras", l.get(4).getDepartamento());
////		assertEquals("Engenharia de Software II", l.get(1).getDisciplina());
////		assertEquals(90, l.get(2).getCargaHoraria());
////	}
////	
////	/**
////	 * testa o método de listagem de todas em caso de alguma falha.
////	 */
////	@Test
////	public void listarTurmas2(){
////		IFachada fachada = new Fachada();
////		
////		List<Turma> l = null;
////		
////		Turma t1_aux = null;
////		Turma t2_aux = null;
////		
////		//Intancia de Turma
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		Turma t3 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral I", 90);
////		Turma t4 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral II", 90);
////		Turma t5 = new Turma("Departamento de Letras", "Inglês Instrumental", 60);
////		
////		//Listagem
////		try{
////			l = fachada.listarTurmas();
////		}catch(TurmasNaoCadastradasException e){
////			System.out.println(e.getMessage());
////		}
////	}
////	
//////========================================================================================================//
//////========================================================================================================//
////	/**
////	 * Testa o método que faz a a matricula de uma aluno.
////	 * @throws SQLException 
////	 */
////	@Test
////	public void testaMatriculaETrancamento() throws SQLException{
////		IFachada fachada = new Fachada();
////		
////		List<Turma> list = null; 
////		
////		Aluno a = null;
////		Aluno b = null;
////		Aluno c = null;
////		Aluno d = null;
////		
////		//Intancia de Turma
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		Turma t3 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral I", 90);
////		Turma t4 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral II", 90);
////		Turma t5 = new Turma("Departamento de Letras", "Inglês Instrumental", 60);
////		Turma t6 = new Turma("Departamento de Matemática", "Matemática Discreta", 60);
////		Turma t7 = new Turma("Departamento de Matemática", "Algebra Linear", 60);
////		Turma t8 = new Turma("Departamento de Computação", "Introdução à Computação", 60);
////		
////		//Salvando alunos no repositório
////		fachada.inserirTurma(t1);
////		fachada.inserirTurma(t2);
////		fachada.inserirTurma(t3);
////		fachada.inserirTurma(t4);
////		fachada.inserirTurma(t5);
////		fachada.inserirTurma(t6);
////		fachada.inserirTurma(t7);
////		fachada.inserirTurma(t8);
////		
////		//Intancia de alunos
////		Aluno a1 = new Aluno("201149099", "Saulo de Társio", "Ciência da Computação");
////		Aluno a2 = new Aluno("201149100", "João", "Ciência da Computação");
////		Aluno a3 = new Aluno("201149101", "Pedro", "Matemática");
////		Aluno a4 = new Aluno("201149102", "Maria", "Matemática");
////		Aluno a5 = new Aluno("201149103", "José", "Ciência da Computação");
////		
////		//Salvando alunos no repositório
////		fachada.inserirAluno(a1);
////		fachada.inserirAluno(a2);
////		fachada.inserirAluno(a3);
////		fachada.inserirAluno(a4);
////		fachada.inserirAluno(a5);
////		
////		
////		//Pesquisa um aluno
////		try{
////			a = fachada.buscarAluno("201149099");
////			b = fachada.buscarAluno("201149102");
////			c = fachada.buscarAluno("201149103");
////			d = fachada.buscarAluno("201149100");
////		}catch(AlunoNaoExistenteException e){
////			System.out.println(e.getMessage());
////		}
////		
////		//Procura as turmas.
////		try{
////			list = fachada.listarTurmas();
////		}catch(TurmasNaoCadastradasException e){
////			System.out.println(e.getMessage());
////		}
////		
////		//Matricula, mandando o aluno e a turma para o método.
////		//Aluno a
////		fachada.matricularAlunoTurma(a, list.get(0));
////		fachada.matricularAlunoTurma(a, list.get(2));
////		fachada.matricularAlunoTurma(a, list.get(4));
////		
////		//Aluno b
////		fachada.matricularAlunoTurma(b, list.get(1));
////		fachada.matricularAlunoTurma(b, list.get(3));
////		fachada.matricularAlunoTurma(b, list.get(6));
////		
////		//Aluno c
////		fachada.matricularAlunoTurma(c, list.get(4));
////		fachada.matricularAlunoTurma(c, list.get(7));
////		
////		//Aluno d
////		fachada.matricularAlunoTurma(d, list.get(5));
////		fachada.matricularAlunoTurma(d, list.get(1));
////		fachada.matricularAlunoTurma(d, list.get(6));
////		fachada.matricularAlunoTurma(d, list.get(4));
////		
////		//verificando as informações.
////		assertEquals(3, a.getTurma().size());
////		assertEquals(3, b.getTurma().size());
////		
////		assertEquals("Engenharia de Software I", a.getTurma().get(0).getDisciplina());
////		assertEquals("Cálculo Diferencial e Integral I", a.getTurma().get(1).getDisciplina());
////		assertEquals("Inglês Instrumental", a.getTurma().get(2).getDisciplina());
////		
////		assertEquals("Engenharia de Software II", b.getTurma().get(0).getDisciplina());
////		assertEquals("Cálculo Diferencial e Integral II", b.getTurma().get(1).getDisciplina());
////		assertEquals("Algebra Linear", b.getTurma().get(2).getDisciplina());
////		
////		assertEquals("Inglês Instrumental", c.getTurma().get(0).getDisciplina());
////		assertEquals("Introdução à Computação", c.getTurma().get(1).getDisciplina());
////		
////		assertEquals("Matemática Discreta", d.getTurma().get(0).getDisciplina());
////		assertEquals("Engenharia de Software II", d.getTurma().get(1).getDisciplina());
////		assertEquals("Algebra Linear", d.getTurma().get(2).getDisciplina());
////		assertEquals("Inglês Instrumental", d.getTurma().get(3).getDisciplina());
////		
////		//Verificando de alunos por turma
////		assertEquals(1, list.get(0).getAluno().size());
////		assertEquals(2, list.get(1).getAluno().size());
////		assertEquals(3, list.get(4).getAluno().size());
////		assertEquals(2, list.get(6).getAluno().size());
////		
////		//Trancando Disciplinas.
////		fachada.trancarTurmaAluno(a, list.get(2));
////		fachada.trancarTurmaAluno(b, list.get(1));
////		fachada.trancarTurmaAluno(d, list.get(4));
////		fachada.trancarTurmaAluno(d, list.get(6));
////		
////		//Verificando de alunos por turma
////		assertEquals(1, list.get(0).getAluno().size());
////		assertEquals(1, list.get(1).getAluno().size());
////		assertEquals(2, list.get(4).getAluno().size());
////		assertEquals(1, list.get(6).getAluno().size());
////	}
////	
////	/**
////	 * Listar alunos por turma.
////	 */
////	/**
////	 * Testa o método que faz a a matricula de uma aluno.
////	 * @throws SQLException 
////	 */
////	@Test
////	public void testaListarAlunoPorTurma() throws SQLException{
////		IFachada fachada = new Fachada();
////		List <Aluno> lista1 = null;
////		List <Aluno> lista2 = null;
////		
////		List<Turma> list = null; 
////		
////		Aluno a = null;
////		Aluno b = null;
////		Aluno c = null;
////		Aluno d = null;
////		
////		//Intancia de Turma
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		Turma t3 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral I", 90);
////		Turma t4 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral II", 90);
////		Turma t5 = new Turma("Departamento de Letras", "Inglês Instrumental", 60);
////		Turma t6 = new Turma("Departamento de Matemática", "Matemática Discreta", 60);
////		Turma t7 = new Turma("Departamento de Matemática", "Algebra Linear", 60);
////		Turma t8 = new Turma("Departamento de Computação", "Introdução à Computação", 60);
////				
////		//Salvando alunos no repositório
////		fachada.inserirTurma(t1);
////		fachada.inserirTurma(t2);
////		fachada.inserirTurma(t3);
////		fachada.inserirTurma(t4);
////		fachada.inserirTurma(t5);
////		fachada.inserirTurma(t6);
////		fachada.inserirTurma(t7);
////		fachada.inserirTurma(t8);
////		
////		//Intancia de alunos
////		Aluno a1 = new Aluno("201149099", "Saulo de Társio", "Ciência da Computação");
////		Aluno a2 = new Aluno("201149100", "João", "Ciência da Computação");
////		Aluno a3 = new Aluno("201149101", "Pedro", "Matemática");
////		Aluno a4 = new Aluno("201149102", "Maria", "Matemática");
////		Aluno a5 = new Aluno("201149103", "José", "Ciência da Computação");
////		
////		//Salvando alunos no repositório
////		fachada.inserirAluno(a1);
////		fachada.inserirAluno(a2);
////		fachada.inserirAluno(a3);
////		fachada.inserirAluno(a4);
////		fachada.inserirAluno(a5);
////		
////		
////		//Pesquisa um aluno
////		try{
////			a = fachada.buscarAluno("201149099");
////			b = fachada.buscarAluno("201149102");
////			c = fachada.buscarAluno("201149103");
////			d = fachada.buscarAluno("201149100");
////		}catch(AlunoNaoExistenteException e){
////			System.out.println(e.getMessage());
////		}
////		
////		//Procura as turmas.
////		try{
////			list = fachada.listarTurmas();
////		}catch(TurmasNaoCadastradasException e){
////			System.out.println(e.getMessage());
////		}
////		
////		//Matricula, mandando o aluno e a turma para o método.
////		//Aluno a
////		fachada.matricularAlunoTurma(a, list.get(0));
////		fachada.matricularAlunoTurma(a, list.get(2));
////		fachada.matricularAlunoTurma(a, list.get(4));
////		
////		//Aluno b
////		fachada.matricularAlunoTurma(b, list.get(1));
////		fachada.matricularAlunoTurma(b, list.get(3));
////		fachada.matricularAlunoTurma(b, list.get(6));
////		
////		//Aluno c
////		fachada.matricularAlunoTurma(c, list.get(4));
////		fachada.matricularAlunoTurma(c, list.get(7));
////		
////		//Aluno d
////		fachada.matricularAlunoTurma(d, list.get(5));
////		fachada.matricularAlunoTurma(d, list.get(1));
////		fachada.matricularAlunoTurma(d, list.get(6));
////		fachada.matricularAlunoTurma(d, list.get(4));
////		
////		//Lista de alunos por turma
////		try{
////			lista1 = fachada.listarAlunoPorTurma(t5);
////			lista2 = fachada.listarAlunoPorTurma(t7);
////		}catch(TurmaSemAlunoException e){
////			System.out.println(e.getMessage());
////		}
////		
////		//verificando as informações.
////		assertEquals(3, lista1.size());
////		assertEquals("Saulo de Társio", lista1.get(0).getNome());
////		assertEquals("José", lista1.get(1).getNome());
////		assertEquals("João", lista1.get(2).getNome());
////		
////		assertEquals(2, lista2.size());
////		assertEquals("Maria", lista2.get(0).getNome());
////		assertEquals("João", lista2.get(1).getNome());
////		
////	}
////	
////	/**
////	 * Listar alunos por turma - falha
////	 * 
////	 */
////	@Test
////	public void testaListarAlunosPorTurmaFalha(){
////		IFachada fachada = new Fachada();
////		List <Aluno> lista = null;
////		//Listar aluno de uma turma com 0 alunos - exception
////		
////		//Intancia de Turma
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		
////		try{
////			lista = fachada.listarAlunoPorTurma(t1);
////		}catch(TurmaSemAlunoException e){
////			System.out.println(e.getMessage());
////		}
////	}
////	
////	
////	/**
////	 * Listar turmas por departamento
////	 */
////	@Test
////	public void testaTurmasDepartamentos(){
////		IFachada fachada = new Fachada();
////		
////		List<Turma> lista1 = null; 
////		List<Turma> lista2 = null;
////		List<Turma> lista3 = null;
////		
////		
////		//Intancia de Turma
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		Turma t3 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral I", 90);
////		Turma t4 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral II", 90);
////		Turma t5 = new Turma("Departamento de Letras", "Inglês Instrumental", 60);
////		Turma t6 = new Turma("Departamento de Matemática", "Matemática Discreta", 60);
////		Turma t7 = new Turma("Departamento de Matemática", "Algebra Linear", 60);
////		Turma t8 = new Turma("Departamento de Computação", "Introdução à Computação", 60);
////				
////		//Salvando alunos no repositório
////		fachada.inserirTurma(t1);
////		fachada.inserirTurma(t2);
////		fachada.inserirTurma(t3);
////		fachada.inserirTurma(t4);
////		fachada.inserirTurma(t5);
////		fachada.inserirTurma(t6);
////		fachada.inserirTurma(t7);
////		fachada.inserirTurma(t8);
////		
////		//Pesquisa
////		try{
////			lista1 = fachada.listarTurmasPorDepartamento("Departamento de Matemática");
////			lista2 = fachada.listarTurmasPorDepartamento("Departamento de Computação");
////			lista3 = fachada.listarTurmasPorDepartamento("Departamento de Letras");
////		}catch(DepartamentoNaoExisteException e){
////			System.out.println(e.getMessage());
////		}catch(TurmasNaoCadastradasException e){
////			System.out.println(e.getMessage());
////		}
////		
////		//Verificação das informações
////		assertEquals(3, lista2.size());
////		assertEquals("Engenharia de Software I", lista2.get(0).getDisciplina());
////		assertEquals("Introdução à Computação", lista2.get(2).getDisciplina());
////		assertEquals("Engenharia de Software II", lista2.get(1).getDisciplina());
////		
////		
////		assertEquals(4, lista1.size());
////		assertEquals("Cálculo Diferencial e Integral II", lista1.get(1).getDisciplina());
////		assertEquals("Cálculo Diferencial e Integral I", lista1.get(0).getDisciplina());
////		assertEquals("Algebra Linear", lista1.get(3).getDisciplina());
////		assertEquals("Matemática Discreta", lista1.get(2).getDisciplina());
////		
////		
////		assertEquals(1, lista3.size());
////		assertEquals("Inglês Instrumental", lista3.get(0).getDisciplina());
////	}
////	
////	/**
////	 * Lista turmas por departamento - falha
////	 */
////	@Test
////	public void testaTurmaDepartamentoFalha(){
////IFachada fachada = new Fachada();
////		
////		List<Turma> lista1 = null; 
////		List<Turma> lista2 = null;
////		List<Turma> lista3 = null;
////		
////		
////		//Intancia de Turma
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		Turma t3 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral I", 90);
////		Turma t4 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral II", 90);
////		Turma t5 = new Turma("Departamento de Letras", "Inglês Instrumental", 60);
////		Turma t6 = new Turma("Departamento de Matemática", "Matemática Discreta", 60);
////		Turma t7 = new Turma("Departamento de Matemática", "Algebra Linear", 60);
////		Turma t8 = new Turma("Departamento de Computação", "Introdução à Computação", 60);
////				
////		//Salvando alunos no repositório
////		fachada.inserirTurma(t1);
////		fachada.inserirTurma(t2);
////		fachada.inserirTurma(t3);
////		fachada.inserirTurma(t4);
////		fachada.inserirTurma(t5);
////		fachada.inserirTurma(t6);
////		fachada.inserirTurma(t7);
////		fachada.inserirTurma(t8);
////		
////		//Pesquisa
////		try{
////			lista1 = fachada.listarTurmasPorDepartamento("Departamento de Biologia");
////		}catch(DepartamentoNaoExisteException e){
////			System.out.println(e.getMessage());
////		}catch(TurmasNaoCadastradasException e){
////			System.out.println(e.getMessage());
////		}
////	}
////	
////	/**
////	 * Testa o método que associa um professor a uma determinada turma.
////	 */
////	@Test
////	public void testaAssociaDesassociaProfessor(){
////		IFachada fachada = new Fachada();
////		
////		List<Turma> list1 = null;
////		List<Turma> list2 = null;
////
////		
////		
////		//Intancia de alunos
////		Professor p1 = new Professor("123.123.123-01", "Professor 1", "Lotação 1", "Mestre");
////		Professor p2 = new Professor("123.123.123-02", "Professor 2", "Lotação 1", "Ph. D.");
////		Professor p3 = new Professor("123.123.123-03", "Professor 3", "Lotação 2", "Mestre");
////		Professor p4 = new Professor("123.123.123-04", "Professor 4", "Lotação 3", "Doutor");
////		Professor p5 = new Professor("123.123.123-05", "Professor 5", "Lotação 3", "Doutor");
////		
////		//Criando turmas.
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		Turma t3 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral I", 90);
////		Turma t4 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral II", 90);
////		Turma t5 = new Turma("Departamento de Letras", "Inglês Instrumental", 60);
////		Turma t6 = new Turma("Departamento de Matemática", "Matemática Discreta", 60);
////		Turma t7 = new Turma("Departamento de Matemática", "Algebra Linear", 60);
////		Turma t8 = new Turma("Departamento de Computação", "Introdução à Computação", 60);
////				
////		
////		//Fazendo a associação.
////		fachada.associarProfessorTurma(p1, t1);
////		fachada.associarProfessorTurma(p2, t2);
////		fachada.associarProfessorTurma(p3, t3);
////		fachada.associarProfessorTurma(p1, t4);
////		fachada.associarProfessorTurma(p2, t5);
////		fachada.associarProfessorTurma(p4, t6);
////		
////		//Fazendo duas desassociações
////		fachada.removerProfessorTurma(p1, t1);
////		assertEquals(1, p1.getTurma().size());
////		assertNull(t1.getProfessor());
////		
////		fachada.removerProfessorTurma(p4, t6);
////		assertEquals(0, p4.getTurma().size());
////		assertNull(t6.getProfessor());
////		
////		assertEquals(2, p2.getTurma().size());
////		assertEquals("Professor 2", t2.getProfessor().getNome());
////		assertEquals("Professor 2", t5.getProfessor().getNome());
////		
////		//Testa o método que lista as turmas de um professor.
////		
////	}
////	
////	/**
////	 * Testa o método que associa um professor a uma determinada turma.
////	 */
////	@Test
////	public void testaListaTurmaPorProfessor(){
////		IFachada fachada = new Fachada();
////		
////		List<Turma> list1 = null;
////		List<Turma> list2 = null;
////
////		
////		
////		//Intancia de alunos
////		Professor p1 = new Professor("123.123.123-01", "Professor 1", "Lotação 1", "Mestre");
////		Professor p2 = new Professor("123.123.123-02", "Professor 2", "Lotação 1", "Ph. D.");
////		Professor p3 = new Professor("123.123.123-03", "Professor 3", "Lotação 2", "Mestre");
////		Professor p4 = new Professor("123.123.123-04", "Professor 4", "Lotação 3", "Doutor");
////		Professor p5 = new Professor("123.123.123-05", "Professor 5", "Lotação 3", "Doutor");
////		
////		//Criando turmas.
////		Turma t1 = new Turma("Departamento de Computação", "Engenharia de Software I", 60);
////		Turma t2 = new Turma("Departamento de Computação", "Engenharia de Software II", 60);
////		Turma t3 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral I", 90);
////		Turma t4 = new Turma("Departamento de Matemática", "Cálculo Diferencial e Integral II", 90);
////		Turma t5 = new Turma("Departamento de Letras", "Inglês Instrumental", 60);
////		Turma t6 = new Turma("Departamento de Matemática", "Matemática Discreta", 60);
////		Turma t7 = new Turma("Departamento de Matemática", "Algebra Linear", 60);
////		Turma t8 = new Turma("Departamento de Computação", "Introdução à Computação", 60);
////				
////		
////		//Fazendo a associação.
////		fachada.associarProfessorTurma(p1, t1);
////		fachada.associarProfessorTurma(p2, t2);
////		fachada.associarProfessorTurma(p3, t3);
////		fachada.associarProfessorTurma(p1, t4);
////		fachada.associarProfessorTurma(p2, t5);
////		fachada.associarProfessorTurma(p4, t6);
////		
////		//Fazendo as pesquisas
////		try{
////			list1 = fachada.listarTurmaPorProfessor(p1);
////			list2 = fachada.listarTurmaPorProfessor(p2);
////		}catch(ProfessorSemTurmaException e){
////			System.out.println(e.getMessage());
////		}
////		
////		//Verificando informações
////		assertEquals(2, list1.size());
////		assertEquals("Engenharia de Software I", list1.get(0).getDisciplina());
////		assertEquals("Cálculo Diferencial e Integral II", list1.get(1).getDisciplina());
////		
////		assertEquals(2, list2.size());
////		assertEquals("Engenharia de Software II", list2.get(0).getDisciplina());
////		assertEquals("Inglês Instrumental", list2.get(1).getDisciplina());
////		
////		//Fazendo duas desassociações
////		try{
////			list1 = fachada.listarTurmaPorProfessor(p5);
////		}catch(ProfessorSemTurmaException e){
////			System.out.println(e.getMessage());
////		}
////		
////	}
//}
