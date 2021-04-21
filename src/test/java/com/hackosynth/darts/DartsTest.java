package com.hackosynth.darts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DartsTest {
    @Test
    public void missedTarget() {
        assertEquals(0, Darts.score(-9, 9));
    }

    @Test
    public void onTheOuterCircle() {
        assertEquals(1, Darts.score(0, 10));
    }

    @Test
    public void onTheMiddleCircle() {
        assertEquals(5, Darts.score(-5, 0));
    }

    @Test
    public void onTheInnerCircle() {
        assertEquals(10, Darts.score(0, -1));
    }

    @Test
    public void exactlyOnCenter() {
        assertEquals(10, Darts.score(0, 0));
    }

    @Test
    public void nearTheCenter() {
        assertEquals(10, Darts.score(-0.1D, -0.1D));
    }

    @Test
    public void justWithinTheInnerCircle() {
        assertEquals(10, Darts.score(0.7D, 0.7D));
    }

    @Test
    public void justOutsideTheInnerCircle() {
        assertEquals(5, Darts.score(0.8D, -0.8D));
    }

    @Test
    public void justWithinTheMiddleCircle() {
        assertEquals(5, Darts.score(-3.5D, 3.5D));
    }

    @Test
    public void justOutsideTheMiddleCircle() {
        assertEquals(1, Darts.score(-3.6D, -3.6D));
    }

    @Test
    public void justWithinTheOuterCircle() {
        assertEquals(1, Darts.score(-7.0D, 7.0D));
    }

    @Test
    public void justOutsideTheOuterCircle() {
        assertEquals(0, Darts.score(-7.1D, -7.1D));
    }

    @Test
    public void asymmetricPositionBetweenTheInnerAndMiddleCircles() {
        assertEquals(5, Darts.score(0.5D, -4.0D));
    }
}
