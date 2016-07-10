package com.company;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.company.Deck.*;

import java.util.Collections;


/**
 * Created by christopherkeeley on 7/6/16.
 */
public class Round extends Game {
        private int points;
        private Deck deck = new Deck();
        private Hand hand = new Hand();

        public Round ()
        {

        }
        public void playRound() throws Exception
        {

            System.out.println("Your current score is: " + getCurrentScore() + "          Round: " + getRoundsPlayed());
            deck.getDeck();
            //deck.showCardsInDeck();
            hand.drawCards(5,deck);
            hand.showHand();
            ArrayList<Integer> cardsToDiscard = hand.cardsToDiscard();
            int cardsToDraw = cardsToDiscard.size();
            hand.discardCards(cardsToDiscard, deck); //discard cards
            hand.drawCards(cardsToDraw, deck);
            hand.showHand();
            HandValue handValue = checkHand();
            System.out.println("Your final hand is " + handValue);
            System.out.println("Your score has changed by " + points);
            int updatedScore = getCurrentScore() + points;
            setCurrentScore(updatedScore);
            System.out.println("Your new score is: " + updatedScore);

        }

        public Boolean doPlayAgain() throws Exception
        {
            System.out.println("Do you want to play again? Input N or No if not");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            System.out.println("string s is " + s);
            switch (s)
            {
                case "No":
                    return false;

                case "N":
                    return false;

                case "n":
                    return false;

                default:
                    return true;
            }
        }

        public HandValue checkHand ()
        {
            if (isRoyalFlush())
            {   points += 200000;
               return HandValue.RoyalFlush;
            }
            if (isStraightFlush())
            {
                points += 30000;
                return HandValue.StraightFlush;
            }
            if (isFourOfKind())
            {
                points += 2000;
                return HandValue.FourOfKind;
            }
            if (isFullHouse())
            {
                points += 500;
                return HandValue.FullHouse;
            }
            if (isFlush())
            {


                points += 200;
                return HandValue.Flush;
            }
            if (isStraight())
            {
                points += 100;
                return HandValue.Straight;
            }
            if (isThreeOfAKind())
            {
                points += 50;
                return HandValue.ThreeOFAKind;
            }
            if (isTwoPair())
            {
                points += 25;
                return HandValue.TwoPair;
            }
            if (isJackHighPair()){
                points += 10;
                return HandValue.JackOrBetterPair;
            }
            points -= 5;
            return HandValue.BadHand;
        }


        private boolean isRoyalFlush()
        {
            ArrayList<Integer> cards = new ArrayList<>();
            for (Card c: hand.getHand())
            {
                cards.add(c.getValue());


            }

            return (isStraightFlush() && (Collections.max(cards) == 14)); // checks for straight flush with high card of an ace
        }


        private boolean isStraightFlush()
        {

            return (isStraight() && isFlush());
        }
        private boolean isFourOfKind()
        {
            ArrayList<Integer> cards = new ArrayList<>();
            boolean check1, check2;
            for (Card c: hand.getHand())
            {
                cards.add(c.getValue());


            }
            //Collections.sort(cards);

            check1 =  cards.get(0).equals(cards.get(1)) && cards.get(2).equals(cards.get(3)) && cards.get(0).equals(cards.get(3));
            check2 =  cards.get(1).equals(cards.get(2)) && cards.get(3).equals(cards.get(4)) && cards.get(1).equals(cards.get(4));
            return check1 || check2;
        }
        private boolean isFullHouse()
        {
            ArrayList<Integer> cards = new ArrayList<>();
            boolean check1, check2;
            for (Card c: hand.getHand())
            {
                cards.add(c.getValue());


            }
            //Collections.sort(cards);
            check1 = cards.get(0).equals(cards.get(1)) && cards.get(1).equals(cards.get(2)) && cards.get(3).equals(cards.get(4));
            check2 = cards.get(0).equals(cards.get(1)) && cards.get(2).equals(cards.get(3)) && cards.get(3).equals(cards.get(4));
            return check1 || check2;
        }
        private boolean isFlush()
        {
            ArrayList<Suit> suits = new ArrayList<>();
            for (Card c: hand.getHand())
            {
                suits.add(c.getSuit());
            }
            int frequency = Collections.frequency(suits, suits.get(0));
            return (frequency == suits.size());

        }
        private boolean isStraight()
        {
            ArrayList<Integer> cards = new ArrayList<>();

            for (Card c: hand.getHand())
            {
                cards.add(c.getValue());


            }
            //Collections.sort(cards);
            for (int i = 0; i < cards.size() - 1; i++)
            {
               if ((cards.get(i) + 1)!= cards.get(i+1))
                {
                    return false;
                }
            }

            return true;
        }
        private boolean isThreeOfAKind()
        {
            ArrayList<Rank> cards = new ArrayList<>();
            int i = 0;
            for (Card c: hand.getHand())
            {

                cards.add(c.getRank());
                int frequency = Collections.frequency(cards, cards.get(i));
                i++;
                if (frequency == 3)
                {
                    return true;
                }

            }
            return false;
        }
        private boolean isTwoPair()
        {
            ArrayList<Integer> cards = new ArrayList<>();
            boolean check1, check2, check3;

            for (Card c: hand.getHand())
            {
                cards.add(c.getValue());

            }
           // Collections.sort(cards);
            check1 = (cards.get(0).equals(cards.get(1))) && (cards.get(2).equals(cards.get(3)));
            check2 = (cards.get(0).equals(cards.get(1))) && (cards.get(3).equals(cards.get(4)));
            check3 = (cards.get(1).equals(cards.get(2))) && (cards.get(3).equals(cards.get(4)));
            return (check1 || check2 || check3);

        }


        private boolean isJackHighPair()
        {
            ArrayList<Integer> cards = new ArrayList<>();
            boolean check1, check2, check3, check4;

            for (Card c: hand.getHand())
            {
                cards.add(c.getValue());


            }
            //Collections.sort(cards);
            check1 = (cards.get(0).equals(cards.get(1)));
                if (check1)
                {
                    return cards.get(1) > 10; //returning true if check1 is true and the pair contains higher than a 10
                }
            check2 = (cards.get(1).equals(cards.get(2)));
            if (check2)
            {
                return cards.get(2) > 10; //returning true if check1 is true and the pair contains higher than a 10
            }
            check3 = (cards.get(2).equals(cards.get(3)));
            if (check3)
            {
                return cards.get(3) > 10; //returning true if check1 is true and the pair contains higher than a 10
            }
            check4 = (cards.get(3).equals(cards.get(4)));
            if (check4)
            {
                return cards.get(4) > 10; //returning true if check1 is true and the pair contains higher than a 10
            }
            return false;

        }




}
