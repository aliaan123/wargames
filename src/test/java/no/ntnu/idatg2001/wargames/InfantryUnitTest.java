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
    void testTerrainForestAttackBonus()
    {
        // Infantry units gets a boost in attack damage if the terrain is a forest.
        assertEquals(7, infantryUnit.getAttackBonus("FOREST"));
    }

    @Test
    void testAttackBonus()
    {
        // Infantry units get no boost in attack damage if the is not forest.
        assertEquals(2, infantryUnit.getAttackBonus("PLAINS"));
        assertEquals(2, infantryUnit.getAttackBonus("HILLS"));
    }


    @Test
    void testTerrainForestResistBonus()
    {
        // Infantry units gets a boost in resist if the terrain is a forest.
        assertEquals(6, infantryUnit.getResistBonus("FOREST"));
    }


    @Test
    void testResistBonus()
    {
        // Infantry units get no boost in resist if the is not forest.
        assertEquals(1, infantryUnit.getResistBonus("PLAINS"));
        assertEquals(1, infantryUnit.getResistBonus("HILLS"));

    }


    @Test
    void getRangeOfUnit()
    {
        assertEquals(true, infantryUnit.getRangeOfUnit());
    }


}