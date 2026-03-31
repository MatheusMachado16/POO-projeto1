package com.hangman.game;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaJogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JogoDaForca game;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogo frame = new TelaJogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaJogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblPalavra = new JLabel("teste");
		lblPalavra.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalavra.setBounds(132, 47, 144, 14);
		contentPane.add(lblPalavra);

		
		JButton btnNewButton = new JButton("Jogar\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game = new JogoDaForca();
				game.iniciar();
				lblPalavra.setText(game.getPalavra());
			}
		});
		btnNewButton.setBounds(160, 135, 89, 23);
		contentPane.add(btnNewButton);
		

	}
}
