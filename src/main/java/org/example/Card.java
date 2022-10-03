package org.example;

public class Card {
    private String suit;
    private String Symbol;
    private int value;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        Symbol = symbol;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + suit  +
                "" + Symbol  + "";
    }
}
