package com.hangman.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class JogoDaForca {
    private static List<String[]> palavras = new ArrayList<>();
    private String palavraSorteada;
    private String dica;
    private String tipo;
    private char[] letrasDescobertas; // Vai guardar os "_ _ _" e as letras certas
    private int acertos = 0;
    private int erros = 0;
    private final int MAX_ERROS = 6; // O limite para ser enforcado

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
        Random random = new Random();
        int i = random.nextInt(palavras.size());
        String[] linha = palavras.get(i);
        this.palavraSorteada = linha[0].toUpperCase();
        this.dica = linha.length > 1 ? linha[1] : "Sem dica";
        this.tipo = linha.length > 2 ? linha[2] : "Sem tipo";
        this.erros = 0;
        this.acertos = 0;
        
        this.letrasDescobertas = new char[palavraSorteada.length()];
        for (int j = 0; j < letrasDescobertas.length; j++) {
            letrasDescobertas[j] = '_';
        }
    }
    public String getPalavra() {
        return this.palavraSorteada;
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
