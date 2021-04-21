package com.hackosynth.dndcharacter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DndCharacterTest {
    @Test
    public void abilityModifierForScore3IsN4() {
        assertEquals(-4, DndCharacter.getAbilityModifier(3));
    }

    @Test
    public void abilityModifierForScore4IsN3() {
        assertEquals(-3, DndCharacter.getAbilityModifier(4));
    }

    @Test
    public void abilityModifierForScore5IsN3() {
        assertEquals(-3, DndCharacter.getAbilityModifier(5));
    }
    @Test
    public void abilityModifierForScore6IsN2() {
        assertEquals(-2, DndCharacter.getAbilityModifier(6));
    }

    @Test
    public void abilityModifierForScore7IsN2() {
        assertEquals(-2, DndCharacter.getAbilityModifier(7));
    }
    @Test
    public void abilityModifierForScore8IsN1() {
        assertEquals(-1, DndCharacter.getAbilityModifier(8));
    }
    @Test
    public void abilityModifierForScore9IsN1() {
        assertEquals(-1, DndCharacter.getAbilityModifier(9));
    }
    @Test
    public void abilityModifierForScore10Is0() {
        assertEquals(0, DndCharacter.getAbilityModifier(10));
    }
    @Test
    public void abilityModifierForScore11Is0() {
        assertEquals(0, DndCharacter.getAbilityModifier(11));
    }
    @Test
    public void abilityModifierForScore12Is1() {
        assertEquals(1, DndCharacter.getAbilityModifier(12));
    }

    @Test
    public void abilityModifierForScore13Is1() {
        assertEquals(1, DndCharacter.getAbilityModifier(13));
    }
    @Test
    public void abilityModifierForScore14Is2() {
        assertEquals(2, DndCharacter.getAbilityModifier(14));
    }

    @Test
    public void abilityModifierForScore15Is2() {
        assertEquals(2, DndCharacter.getAbilityModifier(15));
    }

    @Test
    public void abilityModifierForScore16Is3() {
        assertEquals(3, DndCharacter.getAbilityModifier(16));
    }

    @Test
    public void abilityModifierForScore17Is3() {
        assertEquals(3, DndCharacter.getAbilityModifier(17));
    }

    @Test
    public void abilityModifierForScore18Is4() {
        assertEquals(4, DndCharacter.getAbilityModifier(18));
    }

    @Test
    public void randomAbilityIsWithinRange() {
        int score = DndCharacter.generateAbilityScore();
        assertTrue(isInRange(score));
    }

    @Test
    public void randomCharacterIsValid() {
        DndCharacter dc = new DndCharacter();

        assertTrue(isInRange(dc.getCharisma()));
        assertTrue(isInRange(dc.getConstitution()));
        assertTrue(isInRange(dc.getDexterity()));
        assertTrue(isInRange(dc.getIntelligence()));
        assertTrue(isInRange(dc.getStrength()));
        assertTrue(isInRange(dc.getWisdom()));
        assertEquals(10 + DndCharacter.getAbilityModifier(dc.getConstitution()), dc.getHitpoints());
    }

    @Test
    public void eachAbilityIsOnlyCalculatedOnce() {
        DndCharacter dc = new DndCharacter();
        assertEquals(dc.getCharisma(), dc.getCharisma());
        assertEquals(dc.getConstitution(), dc.getConstitution());
        assertEquals(dc.getDexterity(), dc.getDexterity());
        assertEquals(dc.getHitpoints(), dc.getHitpoints());
        assertEquals(dc.getIntelligence(), dc.getIntelligence());
        assertEquals(dc.getStrength(), dc.getStrength());
        assertEquals(dc.getWisdom(), dc.getWisdom());
    }

    private boolean isInRange(int value) {
        return value >= 3 && value <= 18;
    }
}
