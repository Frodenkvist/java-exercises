package com.hackosynth.cipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class IncorrectKeyCipherTest {
    @Test
    public void keyCannotConsistOfUpperCasedLetters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cipher("ABCDEF");
        });
    }

    @Test
    public void keyCannotContainUpperCasedLetters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cipher("abcdEFg");
        });
    }

    @Test
    public void keyCannotConsistOfDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cipher("12345");
        });
    }

    @Test
    public void keyCannotContainDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cipher("abcd345ef");
        });
    }

    @Test
    public void keyCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cipher("");
        });
    }
}
