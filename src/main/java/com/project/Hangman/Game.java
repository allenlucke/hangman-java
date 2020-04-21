package com.project.Hangman;

import com.project.Hangman.Hangman;

public class Game {
    public static final int MAX_MISSES = 7;
    private String answer;
    private String hits;
    private String misses;

    // Game constructor
    public Game(String answer) {
        this.answer = answer;
        hits = "";
        misses = "";
    }

    //Applies the guess
    public boolean applyGuess(char letter) {
        //Throws exception if the letter has already been guessed
        if (misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1) {
            throw new IllegalArgumentException(letter + " has already been guessed");
        }
            boolean isHit = answer.indexOf(letter) != -1;
            if (isHit) {
                hits += letter;
            } else {
                misses += letter;
            }
            return isHit;
    }

    //Checks for number of remaining attempts
    public int getRemainingTries() {
        return MAX_MISSES - misses.length();
    }

    //Displays current progress
    public String getCurrentProgress() {
        String progress = "";
        // Loops through each letter in the answer
        for (char letter : answer.toCharArray()) {
            char display = '-';
            if(hits.indexOf(letter) != -1) {
                display = letter;
            }
            progress += display;
        }
        return progress;
    }
}
