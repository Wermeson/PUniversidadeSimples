package br.ufpi.es.gui.turma;

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
import br.ufpi.es.model.Turma;
import br.ufpi.es.system.exception.AlunosNaoCadastradosException;
import br.ufpi.es.system.exception.TurmasNaoCadastradasException;

public class TelaListarTurmas extends JDialog {
	
private static final long serialVersionUID = 1L;
	
	private Fachada fachada;
	
	// Título do menu
	private JPanel painelSuperior;
	private JLabel labelTitulo;
	
	private JPanel painelCentral;
	private JTextArea txtTurmas;
	
	public TelaListarTurmas(Fachada f) {
		// Configurações do dialog
		setTitle("Listar Turmas");
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
		labelTitulo = new JLabel("Listar Turmas");
		labelTitulo.setFont(new Font("sans-serif", Font.BOLD, 16));
		labelTitulo.setForeground(Color.BLUE);
		painelSuperior.add(labelTitulo);
		
		painelCentral = new JPanel(new BorderLayout());
		painelCentral.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtTurmas = new JTextArea();
		txtTurmas.setEditable(false);
		txtTurmas.setSelectedTextColor(Color.BLACK);
		txtTurmas.setSelectionColor(Color.WHITE);
		txtTurmas.setFont(new Font("monospaced", Font.PLAIN, 12));
		painelCentral.add(new JScrollPane(txtTurmas));
		
		try {
			List<Turma> listaTurmas = fachada.listarTurmas(); // obtém a lista de alunos
			for (Turma turma : listaTurmas) {
				// Adiciona o aluno ao textArea
				txtTurmas.append(String.format("%-20s%-20s%-20s\n",
						"Departamento: " + turma.getDepartamento(), 
						"Disciplina: " + turma.getDisciplina(), 
						"CH: " + turma.getCargaHoraria()));
			}
		} catch (TurmasNaoCadastradasException e) {
			JOptionPane.showMessageDialog(
					null,
					e.getMessage(),
					"Não há Turmas Cadastras",
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
