package com.company;

import java.util.ArrayList;
import java.util.List;
import com.company.Deck.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by christopherkeeley on 7/5/16.
 */


public class Hand
{
    private List<Card> myHand;

    public Hand()
    {
        myHand = new ArrayList<>();

    }
    public void drawCards(int numberOfCards, Deck myDeck)
    {
        List<Card> shuffledDeck =  myDeck.getDeck();
        for (int i = 0; i < numberOfCards; i++)
        {

            Card c = shuffledDeck.get(0); // always get top card in deck, duh :)
            myHand.add(c);
            myDeck.dealCard();

        }
        for (Card c : myHand)
        {
            System.out.println(c.getRank() + " of " + c.getSuit() + " is card " + myHand.indexOf(c) + " in my hand.");
        }
    }
    public List<Card> getHand()
    {
        return this.myHand;
    }

    public void discardCard(Card card, Deck myDeck)
    {
        myHand.remove(card);
        myDeck.setDiscardPile(card);
        for (Card c : myHand)
        {
            System.out.println(c.getRank() + " of " + c.getSuit() +" is card " + myHand.indexOf(c) + " in my hand.");
        }
    }
    public ArrayList<Integer> cardsToDiscard() throws Exception
    {
        for (Card c : myHand)
        {
            System.out.println(c.getRank() + " of " + c.getSuit() +" is card " + myHand.indexOf(c) + " in my hand.");
        }
        System.out.println("Please pick the cards you want to discard, separated by spaces");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayList<Integer> discardList = stringToIntegerArrayList(s);

        return discardList;



    }
    private ArrayList<Integer> stringToIntegerArrayList (String s)
    {
        String [] arr = s.split(" ");
        ArrayList<Integer> convertedToInt = new ArrayList<>();
        for (String item : arr)
        {
            convertedToInt.add(Integer.parseInt(item));
        }
        return convertedToInt;
    }

}