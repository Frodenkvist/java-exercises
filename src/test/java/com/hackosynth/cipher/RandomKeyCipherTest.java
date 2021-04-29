package com.hackosynth.cipher;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class RandomKeyCipherTest {
    @Test
    public void canEncode() {
        Cipher cipher = new Cipher();

        assertEquals(cipher.key.substring(0, 10), cipher.encode("aaaaaaaaaa"));
    }

    @Test
    public void canDecode() {
        Cipher cipher = new Cipher();

        assertEquals("aaaaaaaaaa", cipher.decode(cipher.key.substring(0, 10)));
    }

    @Test
    public void keyIsMadeOnlyOfLowercaseLetters() {
        Cipher cipher = new Cipher();

        assertTrue(Pattern.compile("[a-z]+").matcher(cipher.key).matches());
    }

    @Test
    public void isReversible() {
        Cipher cipher = new Cipher();
        String plainText = "abcdefghij";

        assertEquals(plainText, cipher.decode(cipher.encode(plainText)));
    }

    @Test
    public void defaultKeyIsOfLength100() {
        Cipher cipher = new Cipher();

        assertEquals(100, cipher.key.length());
    }

    @Test
    public void twoDefaultGeneratedKeysDiffers() {
        assertNotEquals(new Cipher().key, new Cipher().key);
    }
}
