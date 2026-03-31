package com.hangman;

import java.util.Scanner;

import com.hangman.game.JogoDaForca;


public class Main {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JogoDaForca game = new JogoDaForca();
        int op;
        do {

            System.out.println("[Jogo da Forca]");
            System.out.println("[1] começar");
            System.out.println("[0] sair");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 0:
                	sc.close();
                    return;
                case 1:
                    game.iniciar();
                    break;
            }
        } while (true);
        
    }
}
