package no.ntnu.idatg2001.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        infantryUnit.attack(cavalryUnit, "FOREST");
        assertNotEquals(healthBeforeAttack,cavalryUnit.getHealth());

    }

    @Test
    void factoryCreatingUnitTest() {
        Unit unitFromFactory = UnitFactory.factoryCreatingUnit("Infantry Unit", "idk", 10);
        Unit unit = new InfantryUnit("idk", 10);
        if (unit.getName().equals(unitFromFactory.getName()) && unit.getHealth() == unitFromFactory.getHealth()) {
            assertEquals(unit.getName(), unitFromFactory.getName());
            assertEquals(unit.getHealth(), unitFromFactory.getHealth());
            assertEquals(unit.toString(), unitFromFactory.toString());
        }

    }

    @Test
    void factoryCreatingMultipleUnitsTests()
    {
        List<Unit> unitList1 = UnitFactory.factoryCreatingMultipleUnits("Cavalry Unit", "lol", 10, 4);
        Unit cavalryUnit1 = new CavalryUnit("lol", 10);
        Unit cavalryUnit2 = new CavalryUnit("lol", 10);
        Unit cavalryUnit3 = new CavalryUnit("lol", 10);
        Unit cavalryUnit4 = new CavalryUnit("lol", 10);

        List<Unit> unitList2 = new ArrayList<>();
        unitList2.add(cavalryUnit1);
        unitList2.add(cavalryUnit2);
        unitList2.add(cavalryUnit3);
        unitList2.add(cavalryUnit4);

        for(int i = 0; i<unitList1.size(); i++)
        {
            Unit factoryUnits = unitList1.stream().collect(Collectors.toList()).get(i);
            Unit ogUnit = unitList2.stream().collect(Collectors.toList()).get(i);
            if(factoryUnits.getHealth() == ogUnit.getHealth() && factoryUnits.getName().equals(ogUnit.getName())) {
                assertEquals(factoryUnits.getHealth(), ogUnit.getHealth());
            }
            else {
                assertNotEquals(factoryUnits.getHealth(), ogUnit.getHealth());
            }
        }
    }

}