package br.ufpi.es.gui;

import javax.swing.JFrame;

public class MainGui {

	public static void main(String[] args) {
		TelaPrincipalGui tp = new TelaPrincipalGui();
		tp.setSize(400, 375);
		tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//tp.setLocationRelativeTo(null);
		tp.setResizable(false);
		tp.setVisible(true);
	}

}
