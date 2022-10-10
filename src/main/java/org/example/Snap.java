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
            System.out.println("You won "+currentPlayer.getPlayerName()+"!");
        }
    }

    public void playSnap() {
        Player player1 = new Player(Player.inputName(1));
        System.out.println(player1.getPlayerName());
        Player player2 = new Player(Player.inputName(2));
        System.out.println("Press enter to play");
        sortDeckRandomly();
        for (int i = 0; i < 51; i++) {
            if(!snap) {
                Player currentPlayer = Player.chooseCurrentPlayer(player1, player2, i);
                snapRound(i);
                String choice =getChoiceWithTimer();
                if (choice.equalsIgnoreCase("snap")) {
                    winGame(currentPlayer);
                    if(snap){
                        return;
                    }
                }
                else{
                    snap =false;
                }
            }
            else{
                System.out.println("Unlucky! No snaps!");
                return;
            }
        }
    }
    private String getChoiceWithTimer() {
        Scanner scan = new Scanner(System.in);
        long start= System.currentTimeMillis();
        String choice="";
        try{
            choice = scan.nextLine();
        } catch (Exception e) {}
        long end = System.currentTimeMillis();
        if(end-start>3000 && choice.equalsIgnoreCase("snap")&&snap){
            choice ="";
            System.out.println("Too slow!");
        }
        return choice;
    }

}
