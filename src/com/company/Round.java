package com.company;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.company.Deck.*;

import java.util.Collections;
import java.util.List;

/**
 * Created by christopherkeeley on 7/6/16.
 */
public class Round extends Game{
        private int points;
        private Deck deck = new Deck();
        private Hand hand = new Hand();

        public Round ()
        {

        }
        public void playRound() throws Exception
        {


            deck.getDeck();
            deck.showCardsInDeck();
            hand.drawCards(5,deck);
            ArrayList<Integer> cardsToDiscard = hand.cardsToDiscard();
            int cardsToDraw = cardsToDiscard.size();
            hand.discardCards(cardsToDiscard, deck); //discard first card in hand
            hand.drawCards(cardsToDraw, deck);
            HandValue handValue = checkHand();
            System.out.println("Your final hand is " + handValue);
            System.out.println("Your score has changed by " + points);
            System.out.println(getCurrentScore());
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
            return false;
        }
        private boolean isStraightFlush()
        {

            return (isStraight() && isFlush());
        }
        private boolean isFourOfKind()
        {
            return false;
        }
        private boolean isFullHouse()
        {
            return false;
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
                Collections.sort(cards);

            }
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

            for (Card c: hand.getHand())
            {
                int i = 0;
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
            return false;
        }
        private boolean isJackHighPair()
        {
            return false;
        }



}
