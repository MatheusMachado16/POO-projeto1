package com.hangman.game;

import javax.swing.*;
import java.io.InputStream;
import java.util.Scanner;

public class JogoDaForca {
    private Scanner arquivo;

    public JogoDaForca() {
        InputStream stream = this.getClass().getResourceAsStream("../dados/palavras.txt");
        if (stream == null) {
            JOptionPane.showMessageDialog(null, "Arquivo de palavras inexistente!");
            System.exit(0);
        }
        this.arquivo = new Scanner(stream);
        String linha;
        while (arquivo.hasNext()) {
            linha = arquivo.nextLine();
            //processar linha
        }
        arquivo.close();
    }

    public void iniciar() {
        imprimirForca(0);
    }

    public static void imprimirForca(int erros) {
        String[] estagios = {
                // Estágio 0: 0 erros (Apenas a forca)
                "  +---+\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",

                // Estágio 1: 1 erro (Cabeça)
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",

                // Estágio 2: 2 erros (Corpo)
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",

                // Estágio 3: 3 erros (Braço esquerdo)
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",

                // Estágio 4: 4 erros (Braço direito)
                // Nota: O caractere '\' precisa ser escapado com '\\' no Java
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",

                // Estágio 5: 5 erros (Perna esquerda)
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " /    |\n" +
                        "      |\n" +
                        "=========",

                // Estágio 6: 6 erros (Perna direita - Game Over)
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " / \\  |\n" +
                        "      |\n" +
                        "========="
        };
        System.out.println(estagios[erros]);
    }

    public Scanner getArquivo() {
        return arquivo;
    }

    public void setArquivo(Scanner arquivo) {
        this.arquivo = arquivo;
    }
}
