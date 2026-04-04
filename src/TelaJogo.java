import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TelaJogo extends JFrame {

    private JPanel contentPane;
    private JogoDaForca game;

    private JLabel lblPalavra;
    private JTextField letraUsuario;
    private JLabel lblResultado;
    private JLabel lblResultadoFinal;
    private JLabel lblTitulo;
    private JLabel lblDica;
    private JLabel lblPenalidade;
    private JLabel lblImagem;
    private JLabel lblAcertos;
    private JButton btnEnviar;
    private JButton btnIniciar;
    private JButton btnDesistir;
    private JTextArea taHistorico;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaJogo frame = new TelaJogo();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TelaJogo() {
        setTitle("Jogo da Forca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 570, 680);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 240, 240));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        game = new JogoDaForca();

        // Titulo
        lblTitulo = new JLabel("Jogo da Forca");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitulo.setBounds(150, 10, 260, 30);
        contentPane.add(lblTitulo);

        // Painel de controle (Iniciar / Desistir)
        JPanel painelControle = new JPanel();
        painelControle.setLayout(null);
        painelControle.setBackground(new Color(240, 240, 240));
        painelControle.setBorder(new TitledBorder("Controle"));
        painelControle.setBounds(10, 48, 540, 55);
        contentPane.add(painelControle);

        btnIniciar = new JButton("Iniciar Jogo");
        btnIniciar.setBounds(140, 18, 130, 25);
        painelControle.add(btnIniciar);

        btnDesistir = new JButton("Desistir");
        btnDesistir.setBounds(285, 18, 100, 25);
        btnDesistir.setEnabled(false);
        painelControle.add(btnDesistir);

        // Painel do jogo 
        JPanel painelJogo = new JPanel();
        painelJogo.setLayout(null);
        painelJogo.setBackground(new Color(240, 240, 240));
        painelJogo.setBorder(new TitledBorder("Partida"));
        painelJogo.setBounds(10, 110, 540, 310);
        contentPane.add(painelJogo);

        // Imagem da forca
        lblImagem = new JLabel();
        lblImagem.setBounds(15, 20, 160, 200);
        lblImagem.setBorder(new LineBorder(Color.GRAY, 1));
        lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagem.setVerticalAlignment(SwingConstants.CENTER);
        painelJogo.add(lblImagem);

        // Palavra
        JLabel lblRotPalavra = new JLabel("Palavra:");
        lblRotPalavra.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblRotPalavra.setBounds(190, 22, 70, 20);
        painelJogo.add(lblRotPalavra);

        lblPalavra = new JLabel("---");
        lblPalavra.setFont(new Font("Monospaced", Font.BOLD, 18));
        lblPalavra.setBounds(190, 42, 335, 28);
        painelJogo.add(lblPalavra);

        // Dica
        JLabel lblRotDica = new JLabel("Dica:");
        lblRotDica.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblRotDica.setBounds(190, 78, 50, 20);
        painelJogo.add(lblRotDica);

        lblDica = new JLabel("---");
        lblDica.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblDica.setBounds(190, 96, 335, 20);
        painelJogo.add(lblDica);

        // Penalidade
        JLabel lblRotPen = new JLabel("Penalidade:");
        lblRotPen.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblRotPen.setBounds(190, 122, 90, 20);
        painelJogo.add(lblRotPen);

        lblPenalidade = new JLabel("---");
        lblPenalidade.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblPenalidade.setBounds(190, 140, 335, 20);
        painelJogo.add(lblPenalidade);

        // Acertos
        JLabel lblRotAcertos = new JLabel("Acertos:");
        lblRotAcertos.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblRotAcertos.setBounds(190, 166, 70, 20);
        painelJogo.add(lblRotAcertos);

        lblAcertos = new JLabel("---");
        lblAcertos.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblAcertos.setBounds(190, 184, 335, 20);
        painelJogo.add(lblAcertos);

        // Resultado da jogada
        lblResultado = new JLabel("");
        lblResultado.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblResultado.setBounds(190, 210, 335, 20);
        painelJogo.add(lblResultado);

        // Resultado final
        lblResultadoFinal = new JLabel("");
        lblResultadoFinal.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblResultadoFinal.setHorizontalAlignment(SwingConstants.CENTER);
        lblResultadoFinal.setBounds(10, 270, 520, 28);
        painelJogo.add(lblResultadoFinal);

        // Painel de entrada 
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(null);
        painelEntrada.setBackground(new Color(240, 240, 240));
        painelEntrada.setBorder(new TitledBorder("Adivinhar"));
        painelEntrada.setBounds(10, 427, 540, 60);
        contentPane.add(painelEntrada);

        // Campo de texto
        JLabel lblDigite = new JLabel("Digite a letra:");
        lblDigite.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblDigite.setBounds(80, 22, 100, 22);
        painelEntrada.add(lblDigite);

        letraUsuario = new JTextField();
        letraUsuario.setBounds(183, 22, 40, 22);
        letraUsuario.setFont(new Font("Monospaced", Font.BOLD, 14));
        letraUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        letraUsuario.setEnabled(false);
        painelEntrada.add(letraUsuario);

        // Botao Adivinhar
        btnEnviar = new JButton("Adivinhar");
        btnEnviar.setBounds(235, 21, 100, 24);
        btnEnviar.setEnabled(false);
        painelEntrada.add(btnEnviar);

        // Painel historico 
        JPanel painelHistorico = new JPanel();
        painelHistorico.setLayout(null);
        painelHistorico.setBackground(new Color(240, 240, 240));
        painelHistorico.setBorder(new TitledBorder("Historico de partidas"));
        painelHistorico.setBounds(10, 495, 540, 150);
        contentPane.add(painelHistorico);

        // TextArea historico
        taHistorico = new JTextArea();
        taHistorico.setEditable(false);
        taHistorico.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollHistorico = new JScrollPane(taHistorico);
        scrollHistorico.setBounds(10, 18, 518, 118);
        painelHistorico.add(scrollHistorico);

        // Acoes

        // Botao Iniciar
        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.iniciar();

                lblPalavra.setText(formatarPalavra(game.getPalavra()));
                lblDica.setText(game.getDica());
                lblPenalidade.setText("0 / 6  -  " + game.getNomePenalidade());
                lblAcertos.setText("0");
                lblResultado.setText("");
                lblResultadoFinal.setText("");
                lblResultadoFinal.setForeground(Color.BLACK);

                atualizarImagem();

                // Habilita campo e botoes de jogo
                letraUsuario.setEnabled(true);
                letraUsuario.setText("");
                letraUsuario.requestFocus();
                btnEnviar.setEnabled(true);
                btnDesistir.setEnabled(true);

                // Bloqueia iniciar
                btnIniciar.setEnabled(false);
            }
        });

        // Botao Desistir
        btnDesistir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                    contentPane,
                    "Tem certeza que deseja desistir?\nA palavra sera revelada.",
                    "Desistir",
                    JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    lblResultadoFinal.setText("Voce desistiu! A palavra era: " + game.getPalavraCompleta());
                    lblResultadoFinal.setForeground(new Color(180, 0, 0));
                    game.desistir();
                    encerrarPartida();
                    atualizarHistorico();
                }
            }
        });

        // Botao Adivinhar / campo Enter
        ActionListener acaoAdivinhar = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String letra = letraUsuario.getText().trim();
                    if (letra.isEmpty()) {
                        lblResultado.setText("Atencao: o campo esta vazio, digite uma letra!");
                        lblResultado.setForeground(new Color(150, 100, 0));
                        return;
                    }
                    if (letra.length() > 1) {
                        lblResultado.setText("Atencao: digite apenas uma letra por vez!");
                        lblResultado.setForeground(new Color(150, 100, 0));
                        return;
                    }
                    if (!Character.isLetter(letra.charAt(0))) {
                        lblResultado.setText("Atencao: digite apenas letras!");
                        lblResultado.setForeground(new Color(150, 100, 0));
                        return;
                    }
                    var posicoes = game.getOcorrencias(letra);

                    if (posicoes.isEmpty()) {
                        lblResultado.setText("ERROU! '" + letra.toUpperCase() + "' nao esta na palavra.");
                        lblResultado.setForeground(new Color(180, 0, 0));
                    } else {
                        lblResultado.setText("ACERTOU! '" + letra.toUpperCase() + "' encontrada em " + posicoes.size() + " posicao(oes).");
                        lblResultado.setForeground(new Color(0, 120, 0));
                    }

                    lblPalavra.setText(formatarPalavra(game.getPalavra()));
                    int erros = game.getCodigoPenalidade();
                    lblPenalidade.setText(erros + " / 6  -  " + game.getNomePenalidade());
                    lblAcertos.setText(String.valueOf(game.getAcertos()));
                    atualizarImagem();
                    letraUsuario.setText("");

                } catch (Exception ex) {
                    lblResultado.setText("Atencao: entrada invalida!");
                    lblResultado.setForeground(new Color(150, 100, 0));
                }

                if (game.terminou()) {
                    String res = game.getResultado();
                    if (res.equals("venceu")) {
                        lblResultadoFinal.setText("Parabens! Voce venceu! Palavra: " + game.getPalavraCompleta());
                        lblResultadoFinal.setForeground(new Color(0, 120, 0));
                    } else {
                        lblResultadoFinal.setText("Voce perdeu! A palavra era: " + game.getPalavraCompleta());
                        lblResultadoFinal.setForeground(new Color(180, 0, 0));
                    }
                    lblResultado.setText("");
                    encerrarPartida();
                    atualizarHistorico();
                }
            }
        };

        btnEnviar.addActionListener(acaoAdivinhar);
        letraUsuario.addActionListener(acaoAdivinhar);
    }

    // Encerra a partida: desabilita jogo e reabilita Iniciar
    private void encerrarPartida() {
        letraUsuario.setEnabled(false);
        btnEnviar.setEnabled(false);
        btnDesistir.setEnabled(false);
        btnIniciar.setEnabled(true);
    }

    // Formata
    private String formatarPalavra(String raw) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < raw.length(); i++) {
            if (i > 0) sb.append("  ");
            char c = raw.charAt(i);
            sb.append(c == '*' ? '_' : c);
        }
        return sb.toString();
    }

    // Atualiza historico apos fim de partida normal
    private void atualizarHistorico() {
        var lista = game.getResultados();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {
            sb.append((i + 1)).append(". ").append(lista.get(i)).append("\n");
        }
        taHistorico.setText(sb.toString());
        taHistorico.setCaretPosition(taHistorico.getDocument().getLength());
    }


    // Carrega e escala a imagem da forca
    private void atualizarImagem() {
        try {
            int p = game.getCodigoPenalidade();
            ImageIcon original = new ImageIcon(
                getClass().getResource("/imagens/" + p + ".png")
            );
            int w = lblImagem.getWidth();
            int h = lblImagem.getHeight();
            if (w <= 0) w = 160;
            if (h <= 0) h = 200;
            Image scaled = original.getImage()
                .getScaledInstance(w - 4, h - 4, Image.SCALE_SMOOTH);
            lblImagem.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            System.out.println("Erro ao carregar imagem: " + e.getMessage());
        }
    }
}