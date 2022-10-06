package org.example;

import java.util.Scanner;
import java.util.concurrent.*;

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
                Scanner scanner = new Scanner(System.in);
                String declare =getChoiceWithTimer();
                long startTime = System.currentTimeMillis();
//                try {
//                    declare = scanner.nextLine();
//                } catch (Exception e) {
//                }

                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime-startTime;
                if (declare.equalsIgnoreCase("snap")) {
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
                System.out.println("Unlucky! no matches!");
                return;
            }
        }
    }
    private String getChoiceWithTimer(){
        Callable<String> k = () -> new Scanner(System.in).nextLine();
        long start= System.currentTimeMillis();
        String choice="";
        ExecutorService l = Executors.newFixedThreadPool(1);
        Future<String> g;
        g= l.submit(k);
        while(System.currentTimeMillis()-start<3000 && !g.isDone()){
            // Wait for future
        }
        if(g.isDone()){
            try {
                choice=g.get();
            } catch (InterruptedException | ExecutionException e) {
            }
        }
        g.cancel(true);
        return choice;
    }
}
