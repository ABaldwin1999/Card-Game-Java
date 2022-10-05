package org.example;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class Player {
    private String playerName;
    //private ArrayList<Card> playerDeck = new ArrayList<>();

    public String getPlayerName() {
        return playerName;
    }

    public Player(String playerName) {
        this.playerName = playerName;
    }
    public static String inputName(int num){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input player name");
        String name = "";
        try {
            name =scanner.nextLine();
        }
        catch(Exception e) {
            inputName(num);
        }
        if (name ==""){
            inputName(num);
        }
        System.out.println("Player " + num + ": " + scanner.next());
        return name;
    }
    public static Player chooseCurrentPlayer(Player player1, Player player2, int i){
        if((i+1)%2 ==0){
            return player1 ;
        }
        else{
            return player2;
        }
    }
}
