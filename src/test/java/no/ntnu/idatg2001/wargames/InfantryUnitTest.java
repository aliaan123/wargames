package no.ntnu.idatg2001.wargames;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfantryUnitTest {


    private Unit infantryUnit;

    @BeforeEach
    void createUnits() {
        infantryUnit = new InfantryUnit("Infantry Unit", 100);
    }

    @Test
    void getAttackBonus()
    {
        assertEquals(2, infantryUnit.getAttackBonus());
    }

    @Test
    void getResistBonus()
    {
        assertEquals(1, infantryUnit.getResistBonus());
    }

    @Test
    void getRangeOfUnit()
    {
        assertEquals(true, infantryUnit.getRangeOfUnit());
    }
}