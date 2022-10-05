package org.example;

import java.util.Scanner;

public class Snap extends CardGame {
    private boolean snap = false;

    public void snapRound(int i){
        System.out.println(dealCard(i).toString()+""+dealCard(i+1).toString());
        if(dealCard(i).getValue() == dealCard(i+1).getValue()){
            snap = true;
        }
    }

    public void winGame(Player currentPlayer){
        if (snap) {
            System.out.println("You won"+currentPlayer.getPlayerName());
        }
    }

    public void playSnap() {
        Player player1 = new Player(Player.inputName(1));
        Player player2 = new Player(Player.inputName(2));
        System.out.println("Press enter to play");
        for (int i = 0; i < 51; i++) {
            Player currentPlayer = Player.chooseCurrentPlayer(player1,player2,i);
            snapRound(i);
            Scanner scanner = new Scanner(System.in);
            String declare = "";
            try {
                declare = scanner.next();
            } catch (Exception e) {}
            if(declare.equalsIgnoreCase("snap")){
                winGame(currentPlayer);
            }
        }

    }
}
