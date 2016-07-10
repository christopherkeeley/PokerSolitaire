package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;


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


    public List<Card> getHand()
    {

        return this.myHand;
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
        for (Card c : myHand) {
            //System.out.println("before sort: " + c.getRank() + " of " + c.getSuit() + " is card " + myHand.indexOf(c) + " in my hand.");
        }
        Collections.sort(myHand, Card.CardValueComparator);
        for (Card c : myHand)
        {
           // System.out.println("after sort: " +  c.getRank() + " of " + c.getSuit() + " is card " + myHand.indexOf(c) + " in my hand.");
        }

    }

    public void showHand()
    {
        for (Card c : myHand)
        {
            System.out.println(c.getRank() + " of " + c.getSuit() + " is card " + myHand.indexOf(c) + " in my hand.");
        }
        System.out.println();
    }

    public void discardCards(ArrayList<Integer> cards, Deck myDeck)
    {

        for (int i = cards.size(); i > 0; i--)
        {

            Card card = myHand.get(cards.get(i - 1));
            myHand.remove(card);
            myDeck.setDiscardPile(card);
        }



        for (Card c : myHand)
        {
            System.out.println(c.getRank() + " of " + c.getSuit() +" is card " + myHand.indexOf(c) + " in my hand.");
        }
        System.out.println();
    }
    public ArrayList<Integer> cardsToDiscard() throws Exception
    {
        boolean bError = true;
        System.out.println();
        ArrayList<Integer> discardList  = new ArrayList<>();
        do {
        try {
            System.out.println("Please pick the cards you want to discard, separated by spaces");
            System.out.println();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            discardList = stringToIntegerArrayList(s);
            Collections.sort(discardList);
            bError = false;

        } catch (Exception e) {
            System.out.println("Error " + e + " Please Try again");
        }
    } while (bError);
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