package no.ntnu.idatg2001.wargames;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        //infantryUnit.attack(cavalryUnit);
        assertEquals(true, infantryUnit.checkIfOpponentIsMeleeOrRange(cavalryUnit));

    }

    @Test
    void checkIfMethodCanIdentifyOpponentsAttackRangeVsRanged()
    {
        //infantryUnit.attack(cavalryUnit);
        assertEquals(false, infantryUnit.checkIfOpponentIsMeleeOrRange(rangedUnit));
    }


    @Test
    void checkInfantrysAttackBonusVsMelee() {
        infantryUnit.attack(rangedUnit);
        assertEquals(2, infantryUnit.getAttackBonus());
    }

    @Test
    void checkInfantrysAttackBonusVsRanged() {
        infantryUnit.attack(cavalryUnit);
        assertEquals(0, infantryUnit.getAttackBonus());
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




}