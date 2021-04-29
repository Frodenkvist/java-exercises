package com.hackosynth.scrabblescore;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScrabbleScoreTest {

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("a", 1),
                Arguments.of("A", 1),
                Arguments.of("f", 4),
                Arguments.of("at", 2),
                Arguments.of("zoo", 12),
                Arguments.of("street", 6),
                Arguments.of("quirky", 22),
                Arguments.of("OxyphenButazone", 41),
                Arguments.of("pinata", 8),
                Arguments.of("", 0),
                Arguments.of("abcdefgHijklmnopqrStuvwXyz", 87)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testScoreOfSomeWords(String word, int score) {
        assertEquals(score, ScrabbleScore.scoreWord(word));
    }
}
