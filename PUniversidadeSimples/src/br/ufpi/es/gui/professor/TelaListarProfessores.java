package br.ufpi.es.gui.professor;

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
import br.ufpi.es.model.Professor;
import br.ufpi.es.system.exception.ProfessoresNaoCadastradosException;

public class TelaListarProfessores extends JDialog {

	private static final long serialVersionUID = 1L;

	private Fachada fachada;

	// Título do menu
	private JPanel painelSuperior;
	private JLabel labelTitulo;

	private JPanel painelCentral;
	private JTextArea txtProfessores;

	public TelaListarProfessores(Fachada f) {
		// Configurações do dialog
		setTitle("Listar Professores");
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
		labelTitulo = new JLabel("Listar Professores");
		labelTitulo.setFont(new Font("sans-serif", Font.BOLD, 16));
		labelTitulo.setForeground(Color.BLUE);
		painelSuperior.add(labelTitulo);

		painelCentral = new JPanel(new BorderLayout());
		painelCentral.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtProfessores = new JTextArea();
		txtProfessores.setEditable(false);
		txtProfessores.setSelectedTextColor(Color.BLACK);
		txtProfessores.setSelectionColor(Color.WHITE);
		txtProfessores.setFont(new Font("monospaced", Font.PLAIN, 12));
		painelCentral.add(new JScrollPane(txtProfessores));

		try {
			List<Professor> listaProfessores = fachada.listarProfessores(); // obtém a lista de professores
			
			for (Professor professor : listaProfessores) {
				// Adiciona o aluno ao textArea
				txtProfessores.append(String.format("%-20s%-20s%-20s\n",
						"CPF: " + professor.getCpf(),
						"Nome: " + professor.getNome(),
						"Matrícula: " + professor.getLotacao(),
						"Título: " + professor.getTitulo()));
			}
		} catch (ProfessoresNaoCadastradosException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Não há Professores Cadastros", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

		add(painelSuperior, BorderLayout.NORTH);
		add(painelCentral, BorderLayout.CENTER);

		setVisible(true); // Exibe o dialog
	}
}
