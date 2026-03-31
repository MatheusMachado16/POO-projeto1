package com.hangman.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class JogoDaForca {
    private static List<String[]> palavras = new ArrayList<>();

    static {
        try (BufferedReader br = new BufferedReader(new FileReader("src/java/com/hangman/dados/palavras.csv"))) {
             String linha;
             while ((linha = br.readLine()) != null){
                palavras.add(linha.split(";"));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<String[]> getPalavras() {
        return palavras;
    }

    public void iniciar() {
        System.out.println(
                "  +---+\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "========="
        );
        for (int i = 0; i < 5; i++) {
            System.out.println("PALAVRA SORTEADA: " + getPalavra());
        }
    }
    public String getPalavra() {
        Random random = new Random();
        int i = random.nextInt(palavras.size());
        return palavras.get(i)[0];
    }
    public String getDica() {
        return null;
    }

    public String getTipo() {
        return null;
    }
    public ArrayList<String> getResultados() {
        return null;
    }
    public ArrayList<Integer> getOcorrencia(String letra) throws Exception {
        return null;
    }
    public boolean terminou() {
        return false;
    }
    public int getAcertos() {
        return 0;
    }
    public int getCodigoPenalidade() {
        return 0;
    }
    public String getNomePenalidade() {
        return null;
    }
    public String getResultado() {
        return null;
    }
}
