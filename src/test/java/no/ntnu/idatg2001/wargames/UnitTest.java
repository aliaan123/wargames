package no.ntnu.idatg2001.wargames;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {


    @Test
    void testAttackMethod()
    {
        Unit infantryUnit = new InfantryUnit("Infantry Unit", 100);
        Unit cavalryUnit = new CavalryUnit("Cavalry Unit", 100);
        int healthBeforeAttack = cavalryUnit.getHealth();
        System.out.println(healthBeforeAttack);
        infantryUnit.attack(cavalryUnit);
        System.out.println(cavalryUnit.getHealth());
        assertNotEquals(healthBeforeAttack,cavalryUnit.getHealth());
    }

    @Test
    void checkIfMethodCanIdentifyOpponentsAttackRange()
    {
        Unit infantryUnit = new InfantryUnit("Infantry Unit", 100);
        Unit cavalryUnit = new CavalryUnit("Cavalry Unit", 100);
        //infantryUnit.attack(cavalryUnit);
        assertEquals(true, infantryUnit.checkIfOpponentIsMeleeOrRange(cavalryUnit));

    }

    @Test
    void checkIfMethodCanIdentifyOpponentsAttackRangeVsRanged()
    {
        Unit infantryUnit = new InfantryUnit("Infantry Unit", 100);
        Unit rangedUnit = new RangedUnit("Ranged Unit", 100);
        //infantryUnit.attack(cavalryUnit);
        assertEquals(false, infantryUnit.checkIfOpponentIsMeleeOrRange(rangedUnit));
    }


    @Test
    void checkInfantrysAttackBonusVsMelee() {
        Unit infantryUnit = new InfantryUnit("Infantry Unit", 100);
        Unit rangedUnit = new RangedUnit("Ranged Unit", 100);
        infantryUnit.attack(rangedUnit);
        assertEquals(2, infantryUnit.getAttackBonus());
    }

    @Test
    void checkInfantrysAttackBonusVsRanged() {
        Unit infantryUnit = new InfantryUnit("Infantry Unit", 100);
        Unit cavalryUnit = new CavalryUnit("Cavalry Unit", 100);
        infantryUnit.attack(cavalryUnit);
        assertEquals(0, infantryUnit.getAttackBonus());
    }







}