import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TelaJogo extends JFrame {

    private JPanel contentPane;
    private JogoDaForca game;

    private JLabel lblPalavra;
    private JTextField letraUsuario;
    private JLabel resultado;
    private JLabel resultadoFinal;
    private JLabel lblTitulo;
    private JLabel lblDica;
    private JLabel lblPenalidade;
    private JLabel lblImagem;
    private JLabel lblAcertos;       
    private JButton btnEnviar;
    private JButton btnIniciar;     
    private JTextArea taHistorico;  

    private static final Color COR_FUNDO       = new Color(30, 30, 46);
    private static final Color COR_PAINEL      = new Color(49, 50, 68);
    private static final Color COR_DESTAQUE    = new Color(245, 194, 97);
    private static final Color COR_TEXTO_CLARO = new Color(205, 214, 244);
    private static final Color COR_ACERTO      = new Color(166, 227, 161);
    private static final Color COR_ERRO        = new Color(243, 139, 168);
    private static final Color COR_CAMPO       = new Color(69, 71, 90);
    private static final Color COR_BTN         = new Color(137, 180, 250);
    private static final Color COR_BTN_DIS     = new Color(88, 91, 112);

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
        setBounds(100, 100, 580, 720);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBackground(COR_FUNDO);
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Titulo 
        lblTitulo = new JLabel("JOGO DA FORCA");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(COR_DESTAQUE);
        lblTitulo.setFont(new Font("Monospaced", Font.BOLD, 22));
        lblTitulo.setBounds(80, 15, 410, 35);
        contentPane.add(lblTitulo);

        // Separador
        JSeparator sep = new JSeparator();
        sep.setForeground(COR_DESTAQUE);
        sep.setBounds(40, 55, 490, 2);
        contentPane.add(sep);

        // Botao Iniciar 
        btnIniciar = new JButton("INICIAR");
        btnIniciar.setBounds(155, 63, 260, 30);
        btnIniciar.setBackground(COR_DESTAQUE);
        btnIniciar.setForeground(COR_FUNDO);
        btnIniciar.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnIniciar.setBorder(new LineBorder(COR_DESTAQUE, 1, true));
        btnIniciar.setFocusPainted(false);
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnIniciar);

        // Separador apos botao iniciar
        JSeparator sep2 = new JSeparator();
        sep2.setForeground(new Color(88, 91, 112));
        sep2.setBounds(40, 100, 490, 2);
        contentPane.add(sep2);

        // Inicializa o jogo
        game = new JogoDaForca();

        // Card central 
        JPanel painelCentral = new JPanel();
        painelCentral.setBackground(COR_PAINEL);
        painelCentral.setBorder(new LineBorder(new Color(88, 91, 112), 1, true));
        painelCentral.setLayout(null);
        painelCentral.setBounds(40, 108, 490, 290);
        contentPane.add(painelCentral);

        // Imagem da forca 
        lblImagem = new JLabel();
        lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagem.setVerticalAlignment(SwingConstants.CENTER);
        lblImagem.setBounds(15, 15, 155, 200);
        lblImagem.setBorder(new LineBorder(new Color(88, 91, 112), 1));
        painelCentral.add(lblImagem);

        // Palavra sorteada 
        lblPalavra = new JLabel("- - -");
        lblPalavra.setHorizontalAlignment(SwingConstants.CENTER);
        lblPalavra.setForeground(COR_DESTAQUE);
        lblPalavra.setFont(new Font("Monospaced", Font.BOLD, 20));
        lblPalavra.setBounds(185, 15, 290, 40);
        painelCentral.add(lblPalavra);

        // Dica 
        lblDica = new JLabel("Dica: —");
        lblDica.setForeground(COR_TEXTO_CLARO);
        lblDica.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblDica.setBounds(185, 65, 290, 20);
        painelCentral.add(lblDica);

        // Penalidade 
        lblPenalidade = new JLabel("Penalidade: — ");
        lblPenalidade.setForeground(COR_ERRO);
        lblPenalidade.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblPenalidade.setBounds(185, 95, 290, 20);
        painelCentral.add(lblPenalidade);

        // Acertos 
        lblAcertos = new JLabel("Acertos: —");
        lblAcertos.setForeground(COR_ACERTO);
        lblAcertos.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblAcertos.setBounds(185, 120, 290, 20);
        painelCentral.add(lblAcertos);

        // Resultado da jogada
        resultado = new JLabel("");
        resultado.setHorizontalAlignment(SwingConstants.LEFT);
        resultado.setFont(new Font("SansSerif", Font.BOLD, 13));
        resultado.setBounds(185, 150, 290, 25);
        painelCentral.add(resultado);

        // Resultado final 
        resultadoFinal = new JLabel("");
        resultadoFinal.setHorizontalAlignment(SwingConstants.CENTER);
        resultadoFinal.setFont(new Font("SansSerif", Font.BOLD, 13));
        resultadoFinal.setBounds(15, 240, 460, 35);
        painelCentral.add(resultadoFinal);

        // Campo de entrada da letra 
        JLabel lblDigite = new JLabel("Digite uma letra:");
        lblDigite.setForeground(COR_TEXTO_CLARO);
        lblDigite.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblDigite.setBounds(55, 415, 155, 25);
        contentPane.add(lblDigite);

        letraUsuario = new JTextField();
        letraUsuario.setBounds(213, 415, 55, 28);
        letraUsuario.setBackground(COR_CAMPO);
        letraUsuario.setForeground(COR_DESTAQUE);
        letraUsuario.setCaretColor(COR_DESTAQUE);
        letraUsuario.setFont(new Font("Monospaced", Font.BOLD, 16));
        letraUsuario.setBorder(new LineBorder(COR_BTN, 1, true));
        letraUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        letraUsuario.setEnabled(false);
        contentPane.add(letraUsuario);

        // Botao Adivinhar 
        btnEnviar = new JButton("ADIVINHAR >");
        btnEnviar.setBounds(280, 414, 130, 30);
        btnEnviar.setBackground(COR_BTN);
        btnEnviar.setForeground(COR_FUNDO);
        btnEnviar.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnEnviar.setBorder(new LineBorder(COR_BTN, 1, true));
        btnEnviar.setFocusPainted(false);
        btnEnviar.setEnabled(false);
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEnviar);

        // Separador antes do historico
        JSeparator sep3 = new JSeparator();
        sep3.setForeground(new Color(88, 91, 112));
        sep3.setBounds(40, 455, 490, 2);
        contentPane.add(sep3);

        // Historico 
        JLabel lblHistTitulo = new JLabel("Historico de partidas:");
        lblHistTitulo.setForeground(COR_TEXTO_CLARO);
        lblHistTitulo.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblHistTitulo.setBounds(40, 462, 200, 20);
        contentPane.add(lblHistTitulo);

        taHistorico = new JTextArea();
        taHistorico.setEditable(false);
        taHistorico.setBackground(COR_PAINEL);
        taHistorico.setForeground(COR_TEXTO_CLARO);
        taHistorico.setFont(new Font("Monospaced", Font.PLAIN, 12));
        taHistorico.setBorder(new EmptyBorder(5, 8, 5, 8));

        JScrollPane scrollHistorico = new JScrollPane(taHistorico);
        scrollHistorico.setBounds(40, 485, 490, 155);
        scrollHistorico.setBorder(new LineBorder(new Color(88, 91, 112), 1));
        scrollHistorico.getViewport().setBackground(COR_PAINEL);
        contentPane.add(scrollHistorico);

        // Rodape
        JLabel lblRodape = new JLabel("Jogo da Forca — POO-projeto1");
        lblRodape.setHorizontalAlignment(SwingConstants.CENTER);
        lblRodape.setForeground(new Color(88, 91, 112));
        lblRodape.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblRodape.setBounds(80, 648, 410, 18);
        contentPane.add(lblRodape);

        // Iniciar
        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.iniciar();

                lblPalavra.setText(formatarPalavra(game.getPalavra()));
                lblDica.setText("Dica: " + game.getDica());
                lblPenalidade.setText("Penalidade: 0 / 6  -  Sem penalidade");
                lblAcertos.setText("Acertos: 0");
                resultado.setText("");
                resultadoFinal.setText("");

                atualizarImagem();

                letraUsuario.setEnabled(true);
                letraUsuario.setText("");
                letraUsuario.requestFocus();

                btnEnviar.setEnabled(true);
                btnEnviar.setBackground(COR_BTN);
                btnEnviar.setBorder(new LineBorder(COR_BTN, 1, true));
            }
        });

        // Adivinhar letra 
        ActionListener acaoAdivinhar = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String letra = letraUsuario.getText().trim();
                    var posicoes = game.getOcorrencias(letra);

                    if (posicoes.isEmpty()) {
                        resultado.setText("ERROU! '" + letra.toUpperCase() + "' nao esta na palavra.");
                        resultado.setForeground(COR_ERRO);
                    } else {
                        resultado.setText("ACERTOU! '" + letra.toUpperCase() + "' em " + posicoes.size() + " posicao(oes).");
                        resultado.setForeground(COR_ACERTO);
                    }

                    lblPalavra.setText(formatarPalavra(game.getPalavra()));
                    int erros = game.getCodigoPenalidade();
                    lblPenalidade.setText("Penalidade: " + erros + " / 6  -  " + game.getNomePenalidade());
                    lblAcertos.setText("Acertos: " + game.getAcertos());
                    atualizarImagem();
                    letraUsuario.setText("");

                } catch (Exception ex) {
                    resultado.setText("Digite apenas uma letra!");
                    resultado.setForeground(COR_DESTAQUE);
                }

                // Verifica fim de jogo
                if (game.terminou()) {
                    String res = game.getResultado();
                    if (res.equals("venceu")) {
                        resultadoFinal.setText("<html><center>PARABENS! Voce venceu! &nbsp; Palavra: <b>"
                            + game.getPalavraCompleta() + "</b></center></html>");
                        resultadoFinal.setForeground(COR_ACERTO);
                    } else {
                        resultadoFinal.setText("<html><center>Voce perdeu! &nbsp; A palavra era: <b>"
                            + game.getPalavraCompleta() + "</b></center></html>");
                        resultadoFinal.setForeground(COR_ERRO);
                    }
                    resultado.setText("");
                    letraUsuario.setEnabled(false);
                    btnEnviar.setEnabled(false);
                    btnEnviar.setBackground(COR_BTN_DIS);
                    btnEnviar.setBorder(new LineBorder(COR_BTN_DIS, 1, true));

                    atualizarHistorico();
                }
            }
        };

        btnEnviar.addActionListener(acaoAdivinhar);
        letraUsuario.addActionListener(acaoAdivinhar);
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

    // Atualiza o JTextArea com o historico retornado por getResultados()
    private void atualizarHistorico() {
        var lista = game.getResultados();
        if (lista.isEmpty()) {
            taHistorico.setText("Nenhuma partida finalizada ainda.");
            return;
        }
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
            if (w <= 0) w = 155;
            if (h <= 0) h = 200;
            Image scaled = original.getImage()
                .getScaledInstance(w - 4, h - 4, Image.SCALE_SMOOTH);
            lblImagem.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            System.out.println("Erro ao carregar imagem: " + e.getMessage());
        }
    }
}