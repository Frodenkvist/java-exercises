package com.hackosynth.bob;

import java.util.regex.Pattern;

public class Bob {
    /**
     * Returns bob's very well worded response to a given input.
     * @param input - the sentence spoken to bob
     * @return bob's response to the spoken sentence
     */
    public static String hey(String input) {
        String trimmedInput = input.trim();

        boolean silence = trimmedInput.isEmpty();
        boolean asking = trimmedInput.endsWith("?");
        boolean shouting = Pattern.compile("\\p{Upper}").matcher(trimmedInput).find() && !Pattern.compile("\\p{Lower}").matcher(trimmedInput).find();

        if(silence) return "Fine. Be that way!";
        if(shouting && asking) return "Calm down, I know what I'm doing!";
        if(shouting) return "Whoa, chill out!";
        if(asking) return "Sure.";
        else return "Whatever.";
    }
}
