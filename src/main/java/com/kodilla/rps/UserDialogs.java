package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserDialogs {

    private static Scanner scanner = new Scanner(System.in);


    public static void dialogGameStart() {
        System.out.println(" WELCOME TO ROCK PAPER SCISSORS GAME");
    }

    public static int dialogGetRoundsNumber() {
        boolean isCorrect = false;
        int numberOfRounds = 0;
        System.out.println( " Please enter number of rounds!");
        while (!isCorrect) {
            try {
                numberOfRounds = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Please enter valid numeric value (larger then 0");
            }

            if (numberOfRounds > 0) {
                isCorrect = true;
            }
        }

        return numberOfRounds;
    }


    public static Weapon getUserMove() {
        while (true) {

            System.out.println("Select:  ROCK  PAPER SCISSOR");

            String input = scanner.next();
            input = input.toUpperCase();
            char c = input.charAt(0);
            if (c == 'R')
                return Weapon.ROCK;
            else if (c == 'P')
                return Weapon.PAPER;
            else if (c == 'S')
                return Weapon.SCISSORS;
            else {
                System.out.println(" Wrong move!! ");
            }
        }
    }

    public static boolean playAgain() {
        System.out.print("Do you want to play again?: ");
        String userInput = scanner.nextLine();
        userInput = userInput.toUpperCase();
        return userInput.charAt(0) == 'Y';
    }

    public static String dialogGetUserName() {
        System.out.println("Enter your name: ");
        return scanner.nextLine();
    }

    public static void dialogSelection(Weapon userSelection, Weapon computerSelection) {
        System.out.println(" User selected: " + userSelection.name());
        System.out.println(" Computer selected: " + computerSelection.name());
    }

    public static void winner(Winner winner) {
        System.out.println(" Winner: " + winner.name());
    }

    public static void dialogScore(int computerScore, int humanScore) {
        System.out.println(" Computer score: " + computerScore);
        System.out.println(" User score: " + humanScore);
    }

    public static void dialogEndRound(int round, int numberOfRounds) {
        System.out.println(" Round " + round + " of " + numberOfRounds + " is finished.");
    }
}
