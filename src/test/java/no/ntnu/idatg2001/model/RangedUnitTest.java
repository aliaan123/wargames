package no.ntnu.idatg2001.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangedUnitTest {

    private Unit rangedUnit;

    @BeforeEach
    void createUnits()
    {
        rangedUnit = new RangedUnit("Ranged Unit", 100);
    }

    @Test
    void checkRangedUnitsResistBonusMethod()
    {
        // Resist bonus after one attack
        assertEquals(6, rangedUnit.getResistBonus("PLAINS"));
        // Resist bonus after two attacks
        assertEquals(4, rangedUnit.getResistBonus("PLAINS"));
        // Resist bonus after three attacks
        assertEquals(2, rangedUnit.getResistBonus("PLAINS"));
        // Resist bonus after multiple attacks (will stay at 2)
        assertEquals(2, rangedUnit.getResistBonus("PLAINS"));
    }

    @Test
    void testTerrainHillAttackBonus()
    {
        // Ranged units get a big boost in attack damage on hills
        assertEquals(8, rangedUnit.getAttackBonus("HILL"));
    }

    @Test
    void testTerrainForestAttackBonus()
    {
        // Ranged units gets a smaller boost in attack damage in forests.
        assertEquals(6, rangedUnit.getAttackBonus("FOREST"));
    }

    @Test
    void testTerrainPlainsAttackBonus()
    {
        // Test for ranged units normal attack bonus.
        assertEquals(3, rangedUnit.getAttackBonus("PLAINS"));
    }


}