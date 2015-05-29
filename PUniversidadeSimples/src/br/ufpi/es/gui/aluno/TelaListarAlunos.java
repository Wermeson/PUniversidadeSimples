package br.ufpi.es.gui.aluno;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.ufpi.es.controller.Fachada;
import br.ufpi.es.model.Aluno;
import br.ufpi.es.system.exception.AlunosNaoCadastradosException;

public class TelaListarAlunos extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private Fachada fachada;
	
	// Título do menu
	private JPanel painelSuperior;
	private JLabel labelTitulo;
	
	private JPanel painelCentral;
	private JTextArea txtAlunos;
	
	public TelaListarAlunos(Fachada f) {
		// Configurações do dialog
		setTitle("Listar Alunos");
		setModal(true);
		setSize(500, 250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new BorderLayout()); // Altera gerenciador de layout padrão
		
		fachada = f;
		
		// Insere os componentes no dialog
		painelSuperior = new JPanel();
		painelSuperior.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		labelTitulo = new JLabel("Listar Alunos");
		labelTitulo.setFont(new Font("sans-serif", Font.BOLD, 16));
		labelTitulo.setForeground(Color.BLUE);
		painelSuperior.add(labelTitulo);
		
		painelCentral = new JPanel(new BorderLayout());
		painelCentral.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtAlunos = new JTextArea();
		txtAlunos.setEditable(false);
		txtAlunos.setSelectedTextColor(Color.BLACK);
		txtAlunos.setSelectionColor(Color.WHITE);
		txtAlunos.setFont(new Font("monospaced", Font.PLAIN, 12));
		painelCentral.add(new JScrollPane(txtAlunos));
		
		try {
			List<Aluno> listaAlunos = fachada.listarAlunos(); // obtém a lista de alunos
			for (Aluno aluno : listaAlunos) {
				// Adiciona o aluno ao textArea
				txtAlunos.append(String.format("%-20s%-20s%-20s\n",
						"Nome: " + aluno.getNome(), "Matrícula: " + aluno.getMatricula(), "Curso: " + aluno.getCurso()));
			}
		} catch (AlunosNaoCadastradosException e) {
			JOptionPane.showMessageDialog(
					null,
					e.getMessage(),
					"Não há Alunos Cadastros",
					JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					null,
					e.getMessage(),
					"Erro",
					JOptionPane.ERROR_MESSAGE);
		}
		
		add(painelSuperior, BorderLayout.NORTH);
		add(painelCentral, BorderLayout.CENTER);
		
		setVisible(true); // Exibe o dialog
	}
}
