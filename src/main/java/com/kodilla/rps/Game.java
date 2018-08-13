package com.kodilla.rps;

import com.kodilla.rps.UserDialogs;
import com.kodilla.rps.Weapon;
import com.kodilla.rps.Winner;
import com.kodilla.rps.WinnerResolver;

import java.util.*;
import java.lang.*;

public class Game {
    private int numberOfRounds;
    private String userName;
    private int humanScore=0;
    private int computerScore=0;

    public void playGame() {
        UserDialogs.dialogGameStart();
        userName=UserDialogs.dialogGetUserName();
        numberOfRounds=UserDialogs.dialogGetRoundsNumber();
        int round=1;
        while(round<=numberOfRounds) {
            Weapon userSelection = UserDialogs.getUserMove();
            Weapon computerSelection = getRandomWeapon();
            UserDialogs.dialogSelection(userSelection, computerSelection);
            Winner winner = WinnerResolver.getWinner(userSelection, computerSelection);
            UserDialogs.winner(winner);
            if(winner== Winner.HUMAN){
                humanScore++;
            } else if(winner==Winner.COMPUTER){
               computerScore++;
            }else {
                computerScore++;
                humanScore++;
            }
            UserDialogs.dialogScore(computerScore, humanScore);
            UserDialogs.dialogEndRound(round,numberOfRounds);
            round++;
        }
    }

    private Weapon getRandomWeapon() {
        Random random = new Random();
        int result = random.nextInt(90);
        if(result<30){
            return Weapon.ROCK;
        }else if(result>=60){
            return Weapon.PAPER;
        }else{
            return Weapon.SCISSORS;
        }
    }
}

