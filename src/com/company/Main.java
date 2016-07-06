package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class Main {

    public static void main(String[] args) throws Exception {
	System.out.println("Welcome to poker solitaire");

        Deck deck = new Deck();
        Hand hand = new Hand();
        deck.getDeck();
        deck.showCardsInDeck();
        hand.drawCards(5,deck);
        hand.cardsToDiscard();
        hand.discardCard(hand.getHand().get(0), deck); //discard first card in hand




    }
}
