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
        assertEquals(true, infantryUnit.checkIfOpponentIsMeleeOrRange(cavalryUnit));

    }

    @Test
    void checkIfMethodCanIdentifyOpponentsAttackRangeVsRanged()
    {
        assertEquals(false, infantryUnit.checkIfOpponentIsMeleeOrRange(rangedUnit));
    }


    @Test
    void checkCavalrysAttackBonus() {
        assertEquals(4, cavalryUnit.getAttackBonus());
        assertEquals(2, cavalryUnit.getAttackBonus());
        assertEquals(2, cavalryUnit.getAttackBonus());
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
    void checkIfUnitsAreAddedToArmy()
    {
        Army armyOne = new Army("Army one");
        armyOne.add(infantryUnit);
        armyOne.add(cavalryUnit);
        assertEquals(2, armyOne.unitsSize());
        assertEquals(true, armyOne.hasUnits());

        Army armyTwo = new Army("Army Two");
        armyTwo.add(rangedUnit);
        assertEquals(1, armyTwo.unitsSize());
        assertEquals(true, armyTwo.hasUnits());

        System.out.println(armyOne.getAllUnits());
        System.out.println(armyTwo.getAllUnits());

    }

    @Test
    void negativeTestForArmyMethods()
    {
        Army armyOne = new Army("Army one");
        assertNotEquals(2, armyOne.hasUnits());
        assertNotEquals(true, armyOne.hasUnits());
    }

    @Test
    void testRemoveMethod()
    {
        Army armyOne = new Army("Army one");
        armyOne.add(infantryUnit);
        armyOne.add(cavalryUnit);
        armyOne.add(rangedUnit);
        assertEquals(3, armyOne.unitsSize());
        armyOne.remove(cavalryUnit);
        assertEquals(2, armyOne.unitsSize());
    }

    @Test
    void testAddAllMethodInArmy()
    {
        Army armyOne = new Army("Army one");
        armyOne.add(infantryUnit);
        armyOne.add(rangedUnit);
        armyOne.add(cavalryUnit);
        assertEquals(3, armyOne.unitsSize());
    }


    @Test
    void testArmy()
    {
        Army armyOne = new Army("Army one");
        Unit unit1 = new CavalryUnit("Knights", 120);
        Unit unit2 = new InfantryUnit("Soldiers", 100);
        Unit unit3 = new RangedUnit("Archers", 80);

        armyOne.add(unit1);
        armyOne.add(unit2);
        armyOne.add(unit3);

        assertEquals(true, armyOne.hasUnits());
        assertEquals(3, armyOne.getAllUnits().size());

    }

    @Test
    void testBattle()
    {
        Army armyOne = new Army("Army one");
        Unit unit1 = new CavalryUnit("Knights", 120);
        Unit unit2 = new InfantryUnit("Soldiers", 100);
        Unit unit3 = new RangedUnit("Archers", 80);
        armyOne.add(unit1);
        armyOne.add(unit2);
        armyOne.add(unit3);

        Army armyTwo = new Army("Army two");
        Unit unit4 = new CavalryUnit("Raiders", 10);
        Unit unit5 = new InfantryUnit("Goblins", 10);
        Unit unit6 = new RangedUnit("Spearman", 8);
        armyTwo.add(unit4);
        armyTwo.add(unit5);
        armyTwo.add(unit6);

        //Battle battle = new Battle(armyOne, armyTwo);
        // assertEquals(armyOne, battle.simulate());

    }

}