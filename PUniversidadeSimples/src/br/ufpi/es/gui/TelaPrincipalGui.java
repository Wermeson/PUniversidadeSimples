package br.ufpi.es.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import br.ufpi.es.controller.Fachada;
import br.ufpi.es.gui.aluno.TelaMenuAluno;
import br.ufpi.es.gui.professor.TelaMenuProfessor;
import br.ufpi.es.gui.turma.TelaMenuTurma;

public class TelaPrincipalGui extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel painelSuperior;
	private JLabel labelMenu;
	
	private JPanel painelMenu;
	private JButton botaoAluno;
	private JButton botaoProfessor;
	private JButton botaoTurma;
	private JButton botaoSair;
	
	private Icon iconeAluno;
	private Icon iconeProfessor;
	private Icon iconeTurma;
	private Icon iconeSair;
	
	private JPanel painelInferior;
	private JButton botaoSobre;
	
	private Fachada fachada;
	
	public TelaPrincipalGui() {
		super("Universidade Simples");
		
		fachada = new Fachada();
		
		configuraNimbus();
		
		painelSuperior = new JPanel(new FlowLayout());
		painelSuperior.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		labelMenu = new JLabel("Menu Principal");
		labelMenu.setFont(new Font("sans-serif", Font.BOLD, 16));
		labelMenu.setForeground(Color.BLUE);
		painelSuperior.add(labelMenu);
		
		painelMenu = new JPanel(new GridLayout(2, 2, 10, 10));
		painelMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		iconeAluno = new ImageIcon(getClass().getResource("/icons/student.png"));
		botaoAluno = new JButton("Aluno");
		botaoAluno.setFont(new Font("sans-serif", Font.BOLD, 12));
		botaoAluno.setVerticalTextPosition(SwingConstants.BOTTOM);
		botaoAluno.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoAluno.setIcon(iconeAluno);
		// Adiciona listener ao botao "Aluno"
		botaoAluno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaMenuAluno(fachada);
			}
		});
		
		iconeProfessor = new ImageIcon(getClass().getResource("/icons/professor.png"));
		botaoProfessor = new JButton("Professor");
		botaoProfessor.setFont(new Font("sans-serif", Font.BOLD, 12));
		botaoProfessor.setVerticalTextPosition(SwingConstants.BOTTOM);
		botaoProfessor.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoProfessor.setIcon(iconeProfessor);
		// Adiciona listener ao botao "Professor"
		botaoProfessor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaMenuProfessor(fachada);
			}
		});
		
		iconeTurma = new ImageIcon(getClass().getResource("/icons/classroom.png"));
		botaoTurma = new JButton("Turma");
		botaoTurma.setFont(new Font("sans-serif", Font.BOLD, 12));
		botaoTurma.setVerticalTextPosition(SwingConstants.BOTTOM);
		botaoTurma.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoTurma.setIcon(iconeTurma);
		// Adiciona listener ao botao "Aluno"
		botaoTurma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaMenuTurma(fachada);
			}
		});
		
		iconeSair = new ImageIcon(getClass().getResource("/icons/exit.png"));
		botaoSair = new JButton("Sair");
		botaoSair.setFont(new Font("sans-serif", Font.BOLD, 12));
		botaoSair.setVerticalTextPosition(SwingConstants.BOTTOM);
		botaoSair.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoSair.setIcon(iconeSair);
		// Adiciona listener ao botao "Sair"
		botaoSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		painelMenu.add(botaoAluno);
		painelMenu.add(botaoProfessor);
		painelMenu.add(botaoTurma);
		painelMenu.add(botaoSair);
		
		painelInferior = new JPanel(new BorderLayout());
		painelInferior.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
		botaoSobre = new JButton("Sobre");
		botaoSobre.setFont(new Font("sans-serif", Font.BOLD, 12));
		// Adiciona listener ao botao "Sobre"
		botaoSobre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mensagem = "";
				mensagem += "Colaboradores:\n\n";
				mensagem += "Armando Soares\n";
				mensagem += "Francisco Neto\n";
				mensagem += "Francisco Wermeson\n";
				mensagem += "Francisco Wender\n";
				mensagem += "Hugo Santos\n";
				mensagem += "Saulo de Tarso\n";
				mensagem += "Roney Lira\n";
				mensagem += "Alan Melão\n";
				mensagem += "Joselito Junior";
				
				JOptionPane.showMessageDialog(null, mensagem, "Sobre", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		painelInferior.add(botaoSobre);
		
		add(painelSuperior, BorderLayout.NORTH);
		add(painelMenu, BorderLayout.CENTER);
		add(painelInferior, BorderLayout.SOUTH);
	}
	
	private void configuraNimbus() {
		for (UIManager.LookAndFeelInfo look : UIManager
				.getInstalledLookAndFeels()) {
			if ("javax.swing.plaf.nimbus.NimbusLookAndFeel".equals(look
					.getClassName())) {
				try {
					UIManager.setLookAndFeel(look.getClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}
	
}
