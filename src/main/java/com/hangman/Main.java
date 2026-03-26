package com.hangman;

import com.hangman.game.JogoDaForca;
import com.hangman.game.Painel;
import com.hangman.game.TelaJogo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static  void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaJogo().setVisible(true);
        });

//        Scanner sc = new Scanner(System.in);
//        JogoDaForca game = new JogoDaForca();
//        int op;
//        do {
//
//            System.out.println("[Jogo da Forca]");
//            System.out.println("[1] começar");
//            System.out.println("[0] sair");
//            op = sc.nextInt();
//            sc.nextLine();
//
//            switch (op) {
//                case 0:
//                    return;
//                case 1:
//                    game.iniciar();
//                    break;
//            }
//        } while (true);
    }
}
