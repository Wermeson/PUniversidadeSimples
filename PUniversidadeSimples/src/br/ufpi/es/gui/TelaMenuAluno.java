package br.ufpi.es.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaMenuAluno extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel painelSuperior;
	private JLabel labelMenu;
	
	private JPanel painelMenu;
	private JButton botaoInserir;
	private JButton botaoListar;
	private JButton botaoBuscar;
	private JButton botaoRemover;
	private JButton botaoAlterar;
	private JButton botaoQtdAlunos;
	
	public TelaMenuAluno() {
		// configurações do dialog
		setTitle("Menu Aluno");
		setModal(true);
		setSize(400, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		setLayout(new BorderLayout()); // Altera gerenciador de layout padrão
		
		// Insere os componentes no dialog
		painelSuperior = new JPanel(new FlowLayout());
		painelSuperior.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		labelMenu = new JLabel("Menu Aluno");
		labelMenu.setFont(new Font("sans-serif", Font.BOLD, 16));
		labelMenu.setForeground(Color.BLUE);
		painelSuperior.add(labelMenu);
		
		painelMenu = new JPanel(new GridLayout(3, 2, 10, 10));
		painelMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		botaoInserir = new JButton("Inserir");
		botaoInserir.setFont(new Font("sans-serif", Font.BOLD, 12));
		// Adiciona o listener do botão "Inserir"
		botaoInserir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaInserirAluno(); // Exibe a tela Inserir Aluno
			}
		});
		
		botaoListar = new JButton("Listar");
		botaoListar.setFont(new Font("sans-serif", Font.BOLD, 12));
		
		botaoBuscar = new JButton("Buscar");
		botaoBuscar.setFont(new Font("sans-serif", Font.BOLD, 12));
		// Adiciona o listener do botão "Buscar"
		botaoBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaBuscarAluno(); // Exibe a tela Buscar Aluno
			}
		});
		
		botaoRemover = new JButton("Remover");
		botaoRemover.setFont(new Font("sans-serif", Font.BOLD, 12));
		// Adiciona o listener do botão "Remover"
		botaoRemover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaRemoverAluno();
			}
		});
		
		botaoAlterar = new JButton("Alterar");
		botaoAlterar.setFont(new Font("sans-serif", Font.BOLD, 12));
		
		botaoQtdAlunos = new JButton("Quantidade de alunos");
		botaoQtdAlunos.setFont(new Font("sans-serif", Font.BOLD, 12));
		
		painelMenu.add(botaoInserir);
		painelMenu.add(botaoListar);
		painelMenu.add(botaoBuscar);
		painelMenu.add(botaoRemover);
		painelMenu.add(botaoAlterar);
		painelMenu.add(botaoQtdAlunos);
		
		add(painelSuperior, BorderLayout.NORTH);
		add(painelMenu, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
}
