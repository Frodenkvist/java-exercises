package com.hackosynth.naturalnumber;

import com.hackosynth.naturalnumber.NaturalNumber.Classification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NaturalNumberTest {
    @Test
    public void smallPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, NaturalNumber.classify(6));
    }

    @Test
    public void mediumPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, NaturalNumber.classify(28));
    }

    @Test
    public void largePerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, NaturalNumber.classify(33550336));
    }

    @Test
    public void smallAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, NaturalNumber.classify(12));
    }

    @Test
    public void mediumAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, NaturalNumber.classify(30));
    }

    @Test
    public void largeAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, NaturalNumber.classify(33550335));
    }

    @Test
    public void smallestPrimeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, NaturalNumber.classify(2));
    }

    @Test
    public void smallestNonPrimeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, NaturalNumber.classify(4));
    }

    @Test
    public void mediumNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, NaturalNumber.classify(32));
    }

    @Test
    public void largeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, NaturalNumber.classify(33550337));
    }
    @Test
    public void edgeCaseWithNoFactorsOtherThanItselfIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, NaturalNumber.classify(1));
    }

    @Test
    public void zeroIsNotANaturalNumber() {
        assertThrows(RuntimeException.class, () -> NaturalNumber.classify(0));
    }

    @Test
    public void negativeNumberIsNotANaturalNumber() {
        assertThrows(RuntimeException.class, () -> NaturalNumber.classify(-1));
    }
}
