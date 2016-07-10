package com.company;

import java.util.ArrayList;

/**
 * Created by christopherkeeley on 7/6/16.
 */
public class Game {
    private static int highScore;
    private static int roundsPlayed;
    private static int currentScore = 100;
    public enum HandValue
    {
        BadHand, JackOrBetterPair, TwoPair, ThreeOFAKind, Straight, Flush, FullHouse, FourOfKind, StraightFlush, RoyalFlush;

    }
    public Game ()
    {

    }
    public void setRoundsPlayed ()
    {
        roundsPlayed += 1;
    }
    public int getRoundsPlayed () {return roundsPlayed;}
    public int getCurrentScore()
    {
        return currentScore;
    }
    public void setCurrentScore(int updatedScore)
    {
        currentScore = updatedScore;
    }





}
