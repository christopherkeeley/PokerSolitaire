package com.company;

import java.util.Comparator;

/**
 * Created by christopherkeeley on 7/7/16.
 */
public class Card implements Comparable<Card> {


    private Deck.Suit mySuit;
    private Deck.Rank myRank;
    private int myValue;

    public Card(Deck.Suit suit, Deck.Rank rank) {

        this.mySuit = suit;
        this.myRank = rank;
        this.myValue = myRank.ordinal() + 2;
    }

    public Deck.Suit getSuit() {
        return mySuit;
    }

    public Deck.Rank getRank() {
        return myRank;
    }

    public int getValue() {
        return myValue;
    }

    public int compareTo(Card c) {
        int compareValue = c.getValue();
        return this.myValue - compareValue;
    }

    public static Comparator<Card> CardValueComparator = new Comparator<Card>() {
        public int compare(Card o1, Card o2) {

            return o1.compareTo(o2);
        }
    };
}
