package no.ntnu.idatg2001.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    @Test
    void simulateBattleWhereArmyOneWins()
    {
        Unit unit1 = new CavalryUnit("Knights", 120);
        Unit unit2 = new InfantryUnit("Soldiers", 100);
        Unit unit3 = new RangedUnit("Archers", 80);
        List<Unit> armyOneUnits = new ArrayList<>();
        armyOneUnits.add(unit1);
        armyOneUnits.add(unit2);
        armyOneUnits.add(unit3);

        Army armyOne = new Army("Army one", armyOneUnits);

        Unit unit4 = new CavalryUnit("Raiders", 10);
        Unit unit5 = new InfantryUnit("Goblins", 10);
        Unit unit6 = new RangedUnit("Spearman", 8);
        List<Unit> armyTwoUnits = new ArrayList<>();
        armyTwoUnits.add(unit4);
        armyTwoUnits.add(unit5);
        armyTwoUnits.add(unit6);

        Army armyTwo = new Army("Army two", armyTwoUnits);

        Battle battle = new Battle(armyOne, armyTwo, "PLAINS");
        assertEquals(armyOne, battle.simulate());
    }

    @Test
    void negativeTestSimulationWhereArmyOneWins()
    {
        Unit unit1 = new CavalryUnit("Knights", 120);
        Unit unit2 = new InfantryUnit("Soldiers", 100);
        Unit unit3 = new RangedUnit("Archers", 80);
        List<Unit> armyOneUnits = new ArrayList<>();
        armyOneUnits.add(unit1);
        armyOneUnits.add(unit2);
        armyOneUnits.add(unit3);

        Army armyOne = new Army("Army one", armyOneUnits);

        Unit unit4 = new CavalryUnit("Raiders", 10);
        Unit unit5 = new InfantryUnit("Goblins", 10);
        Unit unit6 = new RangedUnit("Spearman", 8);
        List<Unit> armyTwoUnits = new ArrayList<>();
        armyTwoUnits.add(unit4);
        armyTwoUnits.add(unit5);
        armyTwoUnits.add(unit6);

        Army armyTwo = new Army("Army two", armyTwoUnits);

        Battle battle = new Battle(armyOne, armyTwo, "PLAINS");
        assertNotEquals(armyTwo, battle.simulate());
    }

    @Test
    void simulateBattleWhereArmyTwoWins()
    {
        Unit unit1 = new CavalryUnit("Knights", 10);
        Unit unit2 = new InfantryUnit("Soldiers", 10);
        Unit unit3 = new RangedUnit("Archers", 8);
        List<Unit> armyOneUnits = new ArrayList<>();
        armyOneUnits.add(unit1);
        armyOneUnits.add(unit2);
        armyOneUnits.add(unit3);

        Army armyOne = new Army("Army one", armyOneUnits);

        Unit unit4 = new CavalryUnit("Raiders", 100);
        Unit unit5 = new InfantryUnit("Goblins", 100);
        Unit unit6 = new RangedUnit("Spearman", 80);
        List<Unit> armyTwoUnits = new ArrayList<>();
        armyTwoUnits.add(unit4);
        armyTwoUnits.add(unit5);
        armyTwoUnits.add(unit6);

        Army armyTwo = new Army("Army two", armyTwoUnits);

        Battle battle = new Battle(armyOne, armyTwo, "FOREST");
        assertEquals(armyTwo, battle.simulate());
    }


    @Test
    void simulateBattleWhereArmyOneWinsUsingSimplifiedConstructor()
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

        Battle battle = new Battle(armyOne, armyTwo, "FOREST");
        assertEquals(armyOne, battle.simulate());
    }

}