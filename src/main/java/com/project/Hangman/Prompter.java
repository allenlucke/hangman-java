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
            try {
                isHit = game.applyGuess(guessInput);
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

    public void displayOutcome() {
        if(game.isWon()){
            System.out.printf("You have won the game with %d tries remaining, Congratulations!!!%n",
                    game.getRemainingTries());
        }else {
            System.out.printf("Sorry, you have lost :(  The word was %s",
                    game.getAnswer());
        }
    }
}
