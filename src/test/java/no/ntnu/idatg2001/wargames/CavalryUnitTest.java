package no.ntnu.idatg2001.wargames;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CavalryUnitTest {


    private Unit cavalryUnit;

    @BeforeEach
    void createUnits()
    {
        cavalryUnit = new CavalryUnit("Cavalry Unit", 100);

    }

    @Test
    void testTerrainPlainsAttackBonus() {
        assertEquals(6, cavalryUnit.getAttackBonus("PLAINS"));
        assertEquals(4, cavalryUnit.getAttackBonus("PLAINS"));
        assertEquals(4, cavalryUnit.getAttackBonus("PLAINS"));
    }

    @Test
    void testAttackBonus() {
        // The attack bonus of cavalry units is meant to decrease after each attack
        // The attack bonus is meant to drop after each attack, until it is equal 2.
        // Once it has decreased to 2, it will stay at 2.
        assertEquals(4, cavalryUnit.getAttackBonus("FOREST"));
        assertEquals(2, cavalryUnit.getAttackBonus("HILLS"));
        assertEquals(2, cavalryUnit.getAttackBonus("HILLS"));

    }


    @Test
    void negativeTestGetAttackBonus()
    {
        assertNotEquals(4, cavalryUnit.getAttackBonus("PLAINS"));
        assertNotEquals(2, cavalryUnit.getAttackBonus("PLAINS"));
        assertNotEquals(0, cavalryUnit.getAttackBonus("PLAINS"));
    }

    @Test
    void testTerrainForestResistBonus()
    {
        // Cavalry units has no resist bonus in forests
        assertEquals(0, cavalryUnit.getResistBonus("FOREST"));
    }


    @Test
    void testResistBonus()
    {
        // Cavalry units has resist bonus in other terrains than forests.
        assertEquals(2, cavalryUnit.getResistBonus("HILLS"));
        assertEquals(2, cavalryUnit.getResistBonus("PLAINS"));

    }

    @Test
    void testGetRangeOfUnit()
    {
        assertEquals(true, cavalryUnit.getRangeOfUnit());
    }


}


