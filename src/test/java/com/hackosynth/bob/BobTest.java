package com.hackosynth.bob;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BobTest {
    @Test
    public void statingSomething() {
        assertEquals("Whatever.", Bob.hey("Tom-ay-to, tom-aaaah-to"));
    }

    @Test
    public void shouting() {
        assertEquals("Whoa, chill out!", Bob.hey("WATCH OUT!"));
    }

    @Test
    public void shoutingGibberish() {
        assertEquals("Whoa, chill out!", Bob.hey("FCECDFCAAB"));
    }

    @Test
    public void askingAQuestion() {
        assertEquals("Sure.", Bob.hey("You are, what, like 15?"));
    }

    @Test
    public void askingGibberish() {
        assertEquals("Sure.", Bob.hey("fffbbcbeab?"));
    }

    @Test
    public void talkingForcefully() {
        assertEquals("Whatever.", Bob.hey("Let's go make out behind the gym!"));
    }

    @Test
    public void usingAcronymsInRegularSpeech() {
        assertEquals("Whatever.", Bob.hey("It's OK if you don't want to go to the DMV."));
    }

    @Test
    public void forcefulQuestion() {
        assertEquals("Calm down, I know what I'm doing!", Bob.hey("WHAT THE HELL WERE YOU THINKING?"));
    }

    @Test
    public void shoutingNumbers() {
        assertEquals("Whoa, chill out!", Bob.hey("1, 2, 3 GO!"));
    }

    @Test
    public void noLetters() {
        assertEquals("Whatever.", Bob.hey("1, 2, 3"));
    }

    @Test
    public void questionWithNoLetters() {
        assertEquals("Sure.", Bob.hey("4?"));
    }

    @Test
    public void shoutingWithSpecialCharacters() {
        assertEquals("Whoa, chill out!", Bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!"));
    }

    @Test
    public void shoutingWithNoExclamationMark() {
        assertEquals("Whoa, chill out!", Bob.hey("I HATE THE DMV"));
    }

    @Test
    public void statementContainingQuestionMark() {
        assertEquals("Whatever.", Bob.hey("Ending with ? means a question."));
    }

    @Test
    public void nonLettersWithQuestion() {
        assertEquals("Sure.", Bob.hey(":) ?"));
    }

    @Test
    public void prattlingOn() {
        assertEquals("Sure.", Bob.hey("Wait! Hang on. Are you going to be OK?"));
    }

    @Test
    public void silence() {
        assertEquals("Fine. Be that way!", Bob.hey(""));
    }

    @Test
    public void prolongedSilence() {
        assertEquals("Fine. Be that way!", Bob.hey("          "));
    }

    @Test
    public void alternateSilence() {
        assertEquals("Fine. Be that way!", Bob.hey("\t\t\t\t\t\t\t\t\t\t"));
    }

    @Test
    public void multipleLineQuestion() {
        assertEquals("Whatever.", Bob.hey("\nDoes this cryogenic chamber make me look fat?\nno"));
    }

    @Test
    public void startingWithWhitespace() {
        assertEquals("Whatever.", Bob.hey("         hmmmmmmm..."));
    }

    @Test
    public void endingWithWhitespace() {
        assertEquals("Sure.", Bob.hey("Okay if like my  spacebar  quite a bit?   "));
    }

    @Test
    public void otherWhitespace() {
        assertEquals("Fine. Be that way!", Bob.hey("\n\r \t"));
    }

    @Test
    public void nonQuestionEndingWithWhitespace() {
        assertEquals("Whatever.", Bob.hey("This is a statement ending with whitespace      "));
    }
}
