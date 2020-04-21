package com.project.Hangman;
import com.project.Hangman.Game;

public class Hangman {
    public static void main(String[] args) {

        Game game = new Game("beginning");
        Prompter prompter = new Prompter(game);
        while(game.getRemainingTries() > 0) {
            prompter.displayProgress();
            prompter.promptForGuess();
        }
//        boolean isHit = prompter.promptForGuess();
//        if (isHit) {
//            System.out.println("We have a hit!");
//        }else {
//            System.out.println("Missed!");
//        }
    }
}
