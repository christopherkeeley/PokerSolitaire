package com.company;
import java.util.*;
/**
 *
 * Created by christopherkeeley on 7/5/16.
 */
public class Deck {
    private List<Card> newDeck;
    private List<Card> usedCards;
    private List<Card> discardPile;

    public enum Suit{
        SPADES,
        HEARTS,
        DIAMONDS,
        CLUBS;
    }
    public enum Rank{
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE;
    }

    public Deck ()
    {

        usedCards = new ArrayList<>();
        newDeck = new ArrayList<>((Suit.values().length)*(Rank.values().length));
        discardPile = new ArrayList<>();
        reset();
        shuffle();
    }
    public void reset()
    {
        usedCards.clear();
        newDeck.clear();
        discardPile.clear();

        for (Suit s : Suit.values())
        {
            for (Rank r : Rank.values())
            {
                Card c = new Card(s,r);
                newDeck.add(c);
            }
        }
    }
    public void shuffle()
    {
        Collections.shuffle(this.newDeck); // this is awesome

    }
    public List<Card> getDeck()
    {
        return this.newDeck;
    }
    public List<Card> getDiscardPile()
    {
        return this.discardPile;
    }
    public void setDiscardPile(Card card)
    {
        System.out.println("SetDiscardPile Card is " + card.getRank() + " of " + card.getSuit());
        discardPile.add(card);
    }

    public void showCardsInDeck(){
        for (Card c : this.newDeck)
        {
            System.out.println(c.getRank() + " of " + c.getSuit());
        }
    }
    public void dealCard(){
        this.usedCards.add(newDeck.get(0));
        int len = usedCards.size() - 1;
        System.out.println("add this card to used cards " + usedCards.get(len).getRank() + " of " + usedCards.get(len).getSuit());
        System.out.println();
        this.newDeck.remove(0);


    }


    public class Card
    {


        private Suit mySuit;
        private Rank myRank;

        public Card (Suit suit,Rank rank )
        {
            this.mySuit = suit;
            this.myRank = rank;

        }
        public Suit getSuit (){
            return mySuit;
        }
        public Rank getRank(){
            return myRank;
        }
        public int getValue (){
            return myRank.ordinal() + 2;
        }

    }
}
