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
import javax.swing.JTextField;

public class TelaJogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JogoDaForca game;
	private JLabel lblPalavra;
	private JTextField letraUsuario;
	private JLabel resultado;
	private JLabel resultadoFinal;
	

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
		setTitle("Jogo da Forca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblTitulo = new JLabel("Jogo da Forca");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(123, 11, 144, 14);
		contentPane.add(lblTitulo);
		game = new JogoDaForca();
		game.iniciar();
		JButton button1 = new JButton("Enviar");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					char letraTestar = letraUsuario.getText().toUpperCase().charAt(0);
					if (game.testarLetra(letraTestar)) {
						lblPalavra.setText(game.getLetrasDescobertas());
						letraUsuario.setText("");
						resultado.setText("ACERTOU!!!");
					} else {
						resultado.setText("ERROU!!!");
					}
					resultado.setVisible(true);
				} catch (Exception letraError) {
					System.out.println(letraError.getMessage());
				}

				
				lblTitulo.setText(game.getPalavra());
				lblPalavra.setVisible(true);
				
				if (game.acabou()) {
					lblTitulo.setVisible(false);
					lblPalavra.setVisible(true);
					letraUsuario.setVisible(false);
					resultado.setVisible(true);
					resultadoFinal.setVisible(true);
				}
				
				
			}
		});
		button1.setBounds(154, 227, 89, 23);
		contentPane.add(button1);
		
		lblPalavra = new JLabel(game.getLetrasDescobertas());
		lblPalavra.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalavra.setBounds(133, 46, 134, 14);
		contentPane.add(lblPalavra);
		
		letraUsuario = new JTextField();
		letraUsuario.setBounds(154, 196, 86, 20);
		contentPane.add(letraUsuario);
		letraUsuario.setColumns(10);
		
		resultado = new JLabel("New label");
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setBounds(133, 171, 134, 14);
		contentPane.add(resultado);
		
		resultadoFinal = new JLabel("ACABOU!!!!");
		resultadoFinal.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoFinal.setBounds(116, 108, 170, 14);
		contentPane.add(resultadoFinal);
		resultado.setVisible(false);
		resultadoFinal.setVisible(false);
		

	}
}
