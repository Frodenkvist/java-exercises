package com.hackosynth.cipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubstitutionCipherTest {
    @Test
    public void canEncode() {
        String plainText = "abcdefghij";

        assertEquals(plainText, new Cipher(plainText).encode("aaaaaaaaaa"));
    }

    @Test
    public void canDecode() {
        String plainText = "abcdefghij";

        assertEquals("aaaaaaaaaa", new Cipher(plainText).decode(plainText));
    }

    @Test
    public void isReversible() {
        Cipher cipher = new Cipher("abcdefghij");

        assertEquals(cipher.key, cipher.decode(cipher.encode(cipher.key)));
    }

    @Test
    public void canDoubleShiftEncode() {
        String plainText = "iamapandabear";

        assertEquals("qayaeaagaciai", new Cipher(plainText).encode(plainText));
    }

    @Test
    public void canWrapOnEncode() {
        assertEquals("zabcdefghi", new Cipher("abcdefghij").encode("zzzzzzzzzz"));
    }

    @Test
    public void canWrapOnDecode() {
        assertEquals("zzzzzzzzzz", new Cipher("abcdefghij").decode("zabcdefghi"));
    }

    @Test
    public void canEncodeMessagesLongerThanTheKey() {
        assertEquals("iboaqcnecbfcr", new Cipher("abc").encode("iamapandabear"));
    }

    @Test
    public void canDecodeMessagesLongerThanTheKey() {
        assertEquals("iamapandabear", new Cipher("abc").encode("iboaqcnecbfcr"));
    }

    @Test
    public void keepsTheGivenKey() {
        assertEquals("abcdefghij", new Cipher("abcdefghij").key);
    }
}
