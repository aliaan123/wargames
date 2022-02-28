package no.ntnu.idatg2001.wargames;

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
        assertEquals(6, rangedUnit.getResistBonus());
        // Resist bonus after two attacks
        assertEquals(4, rangedUnit.getResistBonus());
        // Resist bonus after three attacks
        assertEquals(2, rangedUnit.getResistBonus());
        // Resist bonus after multiple attacks (will stay at 2)
        assertEquals(2, rangedUnit.getResistBonus());
    }

    @Test
    void testAttackBonus()
    {
        assertEquals(3, rangedUnit.getAttackBonus());
    }

    @Test
    void testGetRangeOfUnit()
    {
        assertEquals(true, rangedUnit.getRangeOfUnit());
    }


}