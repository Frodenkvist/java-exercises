package com.hackosynth.acronym;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Acronym {
    /**
     * Generates an acronym from a given sentence
     * @return the acronym for the sentence
     */
    public static String generate(String phrase) {
        return Arrays.stream(phrase.split("([ \\-])"))
                .map(word -> {
                    for(char c : word.toCharArray())
                    {
                        if(Character.isLetterOrDigit(c)) {
                            return String.valueOf(c);
                        }
                    }

                    return "";
                }).collect(Collectors.joining()).toUpperCase();
    }
}
