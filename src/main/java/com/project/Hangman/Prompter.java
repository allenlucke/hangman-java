package com.project.Hangman;

import java.util.Scanner;

public class Prompter {
    private Game game;

    public Prompter(Game game) {
        this.game = game;
    }

    //Prompts the user to make a guess
    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter:  ");
        String guessInput = scanner.nextLine();
        char guess = guessInput.charAt(0);
        boolean isHit = false;
        try{
            isHit = game.applyGuess(guess);
        }catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        return isHit;
    }

    //Gets the remaining tries and displays current progress
    public void displayProgress() {
        System.out.printf("You have %d guesses left. Try to solve:  %s%n",
                game.getRemainingTries(),
                game.getCurrentProgress());
    }
}
