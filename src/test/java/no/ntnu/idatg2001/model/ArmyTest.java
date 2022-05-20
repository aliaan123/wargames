package no.ntnu.idatg2001.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {

    private Unit infantryUnit;
    private Unit cavalryUnit;
    private Unit rangedUnit;

    @BeforeEach
    void createUnits()
    {
        infantryUnit = new InfantryUnit("Infantr Unit", 100);
        cavalryUnit = new CavalryUnit("Cavalr Unit", 100);
        rangedUnit = new RangedUnit("Range Unit", 100);
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
    void testGetInfantryUnit()
    {
        Army army = new Army("Army");
        army.add(infantryUnit);
        army.add(cavalryUnit);
        army.add(rangedUnit);

        List<Unit> infantryUnits = new ArrayList<>();
        infantryUnits.add(infantryUnit);

        assertEquals(infantryUnits, army.getInfantryUnits());

    }

    @Test
    void testGetCavalryUnit()
    {
        Army army = new Army("Army");
        army.add(cavalryUnit);
        army.add(infantryUnit);
        army.add(rangedUnit);

        List<Unit> cavalryUnits = new ArrayList<>();
        cavalryUnits.add(cavalryUnit);

        assertEquals(cavalryUnits, army.getCavalryUnits());
    }

    @Test
    void testGetRangedUnit()
    {
        Army army = new Army("Army");
        army.add(cavalryUnit);
        army.add(infantryUnit);
        army.add(rangedUnit);

        List<Unit> rangedUnits = new ArrayList<>();
        rangedUnits.add(rangedUnit);

        assertEquals(rangedUnits, army.getRangedUnits());
    }


    @Test
    void testGetCommanderUnit()
    {
        Army army = new Army("Army");
        CommanderUnit commanderUnit = new CommanderUnit("Commander Unit", 100);
        army.add(commanderUnit);
        army.add(cavalryUnit);
        army.add(infantryUnit);
        army.add(rangedUnit);

        List<Unit> commanderUnits = new ArrayList<>();
        commanderUnits.add(commanderUnit);

        assertEquals(commanderUnits, army.getCommanderUnits());
    }








}