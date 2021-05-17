package com.hackosynth.isogram;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsogramTest {
    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("", true),
                Arguments.of("isogram", true),
                Arguments.of("eleven", false),
                Arguments.of("zzyzx", false),
                Arguments.of("subdermatoglyphic", true),
                Arguments.of("Alphabet", false),
                Arguments.of("alphAbet", false),
                Arguments.of("thumbscrew-japingly", true),
                Arguments.of("thumbscrew-jappingly", false),
                Arguments.of("six-year-old", true),
                Arguments.of("Emily Jung Schwartzkopf", true),
                Arguments.of("accentor", false),
                Arguments.of("angola", false),
                Arguments.of("The qUick broWn fox Jumps ovEr the lazy dog", false)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testSomeWords(String input, boolean expectedOutput) {
        assertEquals(expectedOutput, Isogram.isIsogram(input));
    }
}
