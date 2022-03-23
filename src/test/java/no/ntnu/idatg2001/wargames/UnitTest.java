package no.ntnu.idatg2001.wargames;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    private Unit infantryUnit;
    private Unit cavalryUnit;
    private Unit rangedUnit;

    @BeforeEach
    void createUnits()
    {
        infantryUnit = new InfantryUnit("Infantry Unit", 100);
        cavalryUnit = new CavalryUnit("Cavalry Unit", 100);
        rangedUnit = new RangedUnit("Ranged Unit", 100);
    }

    @Test
    void testAttackMethod()
    {
        int healthBeforeAttack = cavalryUnit.getHealth();
        System.out.println(healthBeforeAttack);
        infantryUnit.attack(cavalryUnit);
        System.out.println(cavalryUnit.getHealth());
        assertNotEquals(healthBeforeAttack,cavalryUnit.getHealth());
    }

    @Test
    void checkIfMethodCanIdentifyOpponentsAttackRange()
    {
        assertEquals(true, infantryUnit.checkIfOpponentIsMeleeOrRange(cavalryUnit));

    }

    @Test
    void checkIfMethodCanIdentifyOpponentsAttackRangeVsRanged()
    {
        assertEquals(false, infantryUnit.checkIfOpponentIsMeleeOrRange(rangedUnit));
    }

    @Test
    void testGetInfantryUnit()
    {

        Army army = new Army("Army");
        army.add(infantryUnit);

        List<Unit> infantryUnits = new ArrayList<>();
        infantryUnits.add(infantryUnit);


        assertEquals(infantryUnits, army.getInfantryUnits());

    }



}