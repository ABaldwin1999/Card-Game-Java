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

    public void winGame(){
        if (snap == true) {
            System.out.println("You won");
        }
    }

    public void playSnap() {
        System.out.println("Press enter to play");
        for (int i = 0; i < 51; i++) {
            snapRound(i);
            Scanner scanner = new Scanner(System.in);
            String declare = "";
            try {
                declare = scanner.next();
            } catch (Exception e) {
            }
            if(declare.toLowerCase()=="snap"){
                winGame();
            }
        }

    }
}
