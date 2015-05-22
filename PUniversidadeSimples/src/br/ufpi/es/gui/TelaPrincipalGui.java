package br.ufpi.es.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

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
	
	public TelaPrincipalGui() {
		super("Universidade Simples");
		
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
		botaoAluno.setVerticalTextPosition(SwingConstants.BOTTOM);
		botaoAluno.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoAluno.setIcon(iconeAluno);
		
		iconeProfessor = new ImageIcon(getClass().getResource("/icons/professor.png"));
		botaoProfessor = new JButton("Professor");
		botaoProfessor.setVerticalTextPosition(SwingConstants.BOTTOM);
		botaoProfessor.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoProfessor.setIcon(iconeProfessor);
		
		iconeTurma = new ImageIcon(getClass().getResource("/icons/classroom.png"));
		botaoTurma = new JButton("Turma");
		botaoTurma.setVerticalTextPosition(SwingConstants.BOTTOM);
		botaoTurma.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoTurma.setIcon(iconeTurma);
		
		iconeSair = new ImageIcon(getClass().getResource("/icons/exit.png"));
		botaoSair = new JButton("Sair");
		botaoSair.setVerticalTextPosition(SwingConstants.BOTTOM);
		botaoSair.setHorizontalTextPosition(SwingConstants.CENTER);
		botaoSair.setIcon(iconeSair);
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
		
		add(painelSuperior, BorderLayout.NORTH);
		add(painelMenu, BorderLayout.CENTER);
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
