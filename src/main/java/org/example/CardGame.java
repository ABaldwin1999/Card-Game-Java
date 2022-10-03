package org.example;
import java.util.*;
import java.util.ArrayList;

public class CardGame {
    private static final ArrayList<Card> deck = new ArrayList<>();
    private static final String [] suits= {"♡","♢","♤","♧"};

    static void getDeck() {
        for( Card card : deck){
            System.out.println(card.toString());
        }
    }

    static void makeDeck(){
        Card card;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                switch (j){
                    case 9:
                        card = new Card(suits[i],"J",11);
                    case 10:
                        card = new Card(suits[i],"Q",12);
                    case 11:
                        card = new Card(suits[i],"K",13);
                    case 12:
                        card = new Card(suits[i],"A",14);
                    default:
                        card = new Card(suits[i],""+(j+2)+"",j+2);
                }
                deck.add(card);
            }
        }
    }
    public Card dealCard(){
        return deck.get(0);
    }
    public void sortDeckInNumberOrder(){
        for (int i = 0; i < deck.size(); i++) {
            for (int j = 0; j < deck.size(); j++) {
                if(deck.get(i).getValue()>deck.get(j).getValue()){
                    Collections.swap(deck,j,i);
                }
            }
        }
    }
    public void sortDeckIntoSuits(){
        for (int i = 0; i < 52; i++) {
            switch(deck.get(i).getSuit()){
                case "♡":
                    Collections.swap(deck,deck.get(i).getValue()-2,i);
                case "♢":
                    Collections.swap(deck,deck.get(i).getValue()+10,i);
                case "♤":
                    Collections.swap(deck,deck.get(i).getValue()+23,i);
                case "♧":
                    Collections.swap(deck,deck.get(i).getValue()+36,i);
            }

        }
    }
}

