package com.project.Hangman;

import java.util.Scanner;

public class Prompter {
    private Game game;

    public Prompter(Game game) {
        this.game = game;
    }

    //Prompts the user to make a guess
    public boolean promptForGuess() {
        boolean isHit = false;
        Scanner scanner = new Scanner(System.in);
        boolean isAcceptable = false;
        do{
            System.out.print("Enter a letter:  ");
            String guessInput = scanner.nextLine();
            char guess = guessInput.charAt(0);

            try {
                isHit = game.applyGuess(guess);
                isAcceptable = true;
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s.  Please try again.  %n", iae.getMessage());
            }
        }while(! isAcceptable);
        return isHit;
    }

    //Gets the remaining tries and displays current progress
    public void displayProgress() {
        System.out.printf("You have %d guesses left. Try to solve:  %s%n",
                game.getRemainingTries(),
                game.getCurrentProgress());
    }
}
