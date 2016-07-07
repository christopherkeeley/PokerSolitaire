package com.company;
import java.util.ArrayList;
/**
 * Created by christopherkeeley on 7/6/16.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to poker solitaire");
        System.out.println();

        Deck deck = new Deck();
        Hand hand = new Hand();
        deck.getDeck();
        deck.showCardsInDeck();
        hand.drawCards(5,deck);
        ArrayList<Integer> cardsToDiscard = new ArrayList<>();
        cardsToDiscard = hand.cardsToDiscard();
        int cardsToDraw = cardsToDiscard.size();
        hand.discardCards(cardsToDiscard, deck); //discard first card in hand
        hand.drawCards(cardsToDraw, deck);



    }
}

