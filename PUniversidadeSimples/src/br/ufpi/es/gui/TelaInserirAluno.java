package br.ufpi.es.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaInserirAluno extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel painelSuperior;
	private JLabel labelTitulo;
	
	private JPanel painelForm;
	
	private JPanel painelEsquerda;
	private JLabel labelNome;
	private JLabel labelMatricula;
	private JLabel labelCurso;
	
	private JPanel painelDireita;
	private JTextField txtNome;
	private JTextField txtMatricula;
	private JTextField txtCurso;
	
	private JPanel painelInferior;
	private JButton botaoLimpar;
	private JButton botaoInserir;
	
	public TelaInserirAluno() {
		setTitle("Inserir Aluno");
		setModal(true);
		setSize(500, 250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new BorderLayout());
		
		painelSuperior = new JPanel();
		painelSuperior.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		labelTitulo = new JLabel("Inserir Aluno");
		labelTitulo.setFont(new Font("sans-serif", Font.BOLD, 16));
		labelTitulo.setForeground(Color.BLUE);
		painelSuperior.add(labelTitulo);
		
		painelForm = new JPanel(new BorderLayout(10, 10));
		painelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		painelEsquerda = new JPanel(new GridLayout(3, 1, 10, 10));
		labelNome = new JLabel("Informe o nome:");
		labelNome.setFont(new Font("sans-serif", Font.BOLD, 12));
		labelMatricula = new JLabel("Informe a matrícula:");
		labelMatricula.setFont(new Font("sans-serif", Font.BOLD, 12));
		labelCurso = new JLabel("Informe o curso:");
		labelCurso.setFont(new Font("sans-serif", Font.BOLD, 12));
		painelEsquerda.add(labelNome);
		painelEsquerda.add(labelMatricula);
		painelEsquerda.add(labelCurso);
		
		painelDireita = new JPanel(new GridLayout(3, 1, 10, 10));
		txtNome = new JTextField();
		txtMatricula = new JTextField();
		txtCurso = new JTextField();
		painelDireita.add(txtNome);
		painelDireita.add(txtMatricula);
		painelDireita.add(txtCurso);
		
		painelInferior = new JPanel();
		painelInferior.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		botaoLimpar = new JButton("Limpar");
		botaoLimpar.setFont(new Font("sans-serif", Font.BOLD, 13));
		botaoInserir = new JButton("Inserir");
		botaoInserir.setFont(new Font("sans-serif", Font.BOLD, 13));
		painelInferior.add(botaoLimpar);
		painelInferior.add(botaoInserir);
		
		painelForm.add(painelEsquerda, BorderLayout.WEST);
		painelForm.add(painelDireita, BorderLayout.CENTER);
		
		add(painelSuperior, BorderLayout.NORTH);
		add(painelForm, BorderLayout.CENTER);
		add(painelInferior, BorderLayout.SOUTH);
		
		setVisible(true);
	}

}
