package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by christopherkeeley on 7/6/16.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to poker solitaire");
        System.out.println();

        Game game = new Game();
        Boolean anotherRound;
        do {
            Round round = new Round();
            game.setRoundsPlayed();
            round.playRound();
            anotherRound = round.doPlayAgain();

        }
        while(anotherRound);






    }
}

