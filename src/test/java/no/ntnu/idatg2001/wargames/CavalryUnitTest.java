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
    void testGetAttackBonus() {
        assertEquals(4, cavalryUnit.getAttackBonus());
        assertEquals(2, cavalryUnit.getAttackBonus());
        assertEquals(2, cavalryUnit.getAttackBonus());
    }

    @Test
    void negativeTestGetAttackBonus()
    {
        assertNotEquals(2, cavalryUnit.getAttackBonus());
        assertNotEquals(4, cavalryUnit.getAttackBonus());
        assertNotEquals(4, cavalryUnit.getAttackBonus());
    }

    @Test
    void testGetResistBonus()
    {
        assertEquals(1, cavalryUnit.getResistBonus());
    }

    @Test
    void testGetRangeOfUnit()
    {
        assertEquals(true, cavalryUnit.getRangeOfUnit());
    }
}