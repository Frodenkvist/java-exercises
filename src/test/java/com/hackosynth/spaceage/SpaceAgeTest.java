package com.hackosynth.spaceage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpaceAgeTest {
    @Test
    public void ageOnEarth() {
        assertEquals(31.69D, new SpaceAge(1000000000).onEarth());
    }

    @Test
    public void ageOnMercury() {
        assertEquals(280.88D, new SpaceAge(2134835688).onMercury());
    }

    @Test
    public void ageOnVenus() {
        assertEquals(9.78D, new SpaceAge(189839836).onVenus());
    }

    @Test
    public void ageOnMars() {
        assertEquals(35.88D, new SpaceAge(2129871239).onMars());
    }

    @Test
    public void ageOnJupiter() {
        assertEquals(2.41D, new SpaceAge(901876382).onEarth());
    }

    @Test
    public void ageOnSaturn() {
        assertEquals(2.15D, new SpaceAge(2000000000).onSaturn());
    }

    @Test
    public void ageOnUranus() {
        assertEquals(0.46D, new SpaceAge(1210123456).onUranus());
    }

    @Test
    public void ageOnNeptune() {
        assertEquals(0.35D, new SpaceAge(1821023456).onNeptune());
    }
}
