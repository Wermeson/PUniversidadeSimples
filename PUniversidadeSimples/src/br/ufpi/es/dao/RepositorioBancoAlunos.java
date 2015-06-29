//package br.ufpi.es.dao;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import br.ufpi.es.model.Aluno;
//import br.ufpi.es.system.exception.AlunoNaoExistenteException;
//import br.ufpi.es.system.exception.AlunosNaoCadastradosException;
//import br.ufpi.es.system.util.ConnectionManager;
//
///**
// * @author Jordao
// */
//public class RepositorioBancoAlunos implements IRepositorioAlunos {
//
//	public RepositorioBancoAlunos() {
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * Metodo que insere um aluno no banco.
//	 * 
//	 * @param aluno
//	 *            .
//	 */
//	@Override
//	public void insereAluno(Aluno aluno) throws SQLException {
//		// TODO Auto-generated method stub
//		String inserir = "insert into aluno values (0, ?, ?, ?)";
//
//		PreparedStatement statement = ConnectionManager
//				.reservaPreparedStatement(inserir);
//
//		statement.setString(1, aluno.getNome());
//		statement.setString(2, aluno.getMatricula());
//		statement.setString(3, aluno.getCurso());
//
//		statement.execute();
//		statement.close();
//	}
//
//	/**
//	 * Metodo que busca um aluno no banco atraves de sua matricula.
//	 * 
//	 * @param matricula
//	 * @return aluno
//	 */
//	@Override
//	public Aluno buscarAluno(String matricula)
//			throws AlunoNaoExistenteException, SQLException {
//
//		// TODO Auto-generated method stub
//		// return null;
//		if (!(this.verificaExistenciaAluno(matricula))) {
//			throw new AlunoNaoExistenteException();
//		}
//		Aluno a = null;
//		String buscar = "select * from aluno where matricula = ?";
//		PreparedStatement statement = ConnectionManager
//				.reservaPreparedStatement(buscar);
//		statement.setString(1, matricula);
//		ResultSet result = statement.executeQuery();
//
//		while (result.next()) {
//			a = new Aluno(result.getString("matricula"),
//					result.getString("nome"), result.getString("curso"));
//			a.setIdAluno(result.getInt("id"));
//		}
//		result.close();
//		statement.close();
//		return a;
//	}
//
//	/**
//	 * Metodo que verifica a existencia de um aluno no banco atraves de sua
//	 * matricula.
//	 * 
//	 * @param matricula
//	 * @return true se existir o aluno.
//	 * @return false se nao existir.
//	 */
//	@Override
//	public boolean verificaExistenciaAluno(String matricula)
//			throws SQLException {
//		String verificaexistencia = "select * from aluno where matricula = ?";
//		PreparedStatement statement = ConnectionManager
//				.reservaPreparedStatement(verificaexistencia);
//		statement.setString(1, matricula);
//		ResultSet result = statement.executeQuery();
//
//		while (result.next()) {
//			return true;
//		}
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	/**
//	 * Metodo que altera as informacoes de um aluno.
//	 * @param aluno
//	 */
//	public void alterarAluno(Aluno a) throws SQLException {
//		String alterar = "update aluno set nome=?, curso=?, matricula=? where id=?";
//
//		PreparedStatement statement = ConnectionManager
//				.reservaPreparedStatement(alterar);
//		if ((a.getNome().length() == 0) || (a.getNome().charAt(0) == ' ')
//				|| (a.getCurso().charAt(0) == ' ')
//				|| (a.getCurso().charAt(0) == ' ')
//				|| (a.getCurso().length() == 0)
//				|| (a.getMatricula().length() == 0)) {
//
//			statement.setString(1, null);
//			statement.setString(2, null);
//			statement.setString(3, null);
//			statement.setInt(4, a.getIdAluno());
//		} else {
//
//			statement.setString(1, a.getNome());
//			statement.setString(2, a.getCurso());
//			statement.setString(3, a.getMatricula());
//			statement.setInt(4, a.getIdAluno());
//		}
//
//		statement.execute();
//		statement.close();
//	}
//
//	/**
//	 * Metodo que remove um aluno do banco de dados.
//	 * 
//	 * @param matricula
//	 */
//	@Override
//	public void removerAluno(String matricula)
//			throws AlunoNaoExistenteException, SQLException {
//		// TODO Auto-generated method stub
//
//		if (this.verificaExistenciaAluno(matricula) == false) {
//			throw new AlunoNaoExistenteException();
//		}
//
//		String remover = "delete from aluno where matricula=?";
//		PreparedStatement statement = ConnectionManager
//				.reservaPreparedStatement(remover);
//		statement.setString(1, matricula);
//
//		statement.execute();
//		statement.close();
//	}
//
//	/**
//	 * Metodo que retorna uma lista com todos os alunos cadastrados no banco.
//	 * 
//	 * @return alunos
//	 */
//	@Override
//	public ArrayList<Aluno> listarAlunos()
//			throws AlunosNaoCadastradosException, SQLException {
//		// TODO Auto-generated method stub
//
//		if (this.quantidadeAlunos() == 0) {
//			throw new AlunosNaoCadastradosException();
//		}
//
//		String listar = "select * from aluno";
//		PreparedStatement statement = ConnectionManager
//				.reservaPreparedStatement(listar);
//		ResultSet result = statement.executeQuery();
//
//		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
//
//		while (result.next()) {
//			Aluno aluno = new Aluno(result.getString("matricula"),
//					result.getString("nome"), result.getString("curso"));
//			alunos.add(aluno);
//		}
//
//		result.close();
//		statement.close();
//		return alunos;
//	}
//
//	/**
//	 * Mwtodo que retorna a quantidade de alunos cadastrados no banco.
//	 * 
//	 * @return cont
//	 */
//	@Override
//	public int quantidadeAlunos() throws SQLException {
//		// TODO Auto-generated method stub
//		int cont = 0;
//		String quantidade = "select COUNT(*) AS total from aluno";
//		PreparedStatement statement = ConnectionManager
//				.reservaPreparedStatement(quantidade);
//		ResultSet result = statement.executeQuery();
//		// statement.setInt(arg0, arg1);
//		while (result.next()) {
//
//			cont = result.getInt("total");
//		}
//		result.close();
//		statement.close();
//		return cont;
//	}
//
//}
