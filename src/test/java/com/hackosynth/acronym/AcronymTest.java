package com.hackosynth.acronym;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcronymTest {
    @Test
    public void capitalizedWords() {
        assertAcronymEquals(
                "Portable Network Graphics",
                "PNG"
        );
    }

    @Test
    public void lowercaseWordInTheMiddle() {
        assertAcronymEquals(
                "Ruby on Rails",
                "ROR"
        );
    }

    @Test
    public void punctuationIsIgnored() {
        assertAcronymEquals(
                "First In, First Out",
                "FIFO"
        );
    }

    @Test
    public void uppercaseWordAtTheStart() {
        assertAcronymEquals(
                "GNU Image Manipulation Program",
                "GIMP"
        );
    }

    @Test
    public void hyphenIsIgnored() {
        assertAcronymEquals(
                "Complementary metal-oxide semiconductor",
                "CMOS"
        );
    }

    @Test
    public void lotsOfWords() {
        assertAcronymEquals(
                "Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me",
                "ROTFLSHTMDCOALM"
        );
    }

    @Test
    public void consecutiveDelimiters() {
        assertAcronymEquals(
                "Something - I made up from thin air",
                "SIMUFTA"
        );
    }

    @Test
    public void apostropheIsIgnored() {
        assertAcronymEquals(
                "Halley's Comet",
                "HC"
        );
    }

    @Test
    public void underscoreEmphasisIsIgnored() {
        assertAcronymEquals(
                "The Road _Not_ Taken",
                "TRNT"
        );
    }

    private void assertAcronymEquals(String origin, String acronym) {
        assertEquals(acronym, Acronym.generate(origin));
    }
}
