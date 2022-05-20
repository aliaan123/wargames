package no.ntnu.idatg2001.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ArmyFileHandlerTest {

    private Army army;

    @BeforeEach
    void setUp() {

        army = new Army("Warriors");
        army.add(new RangedUnit("ranged",10));
        army.add(new InfantryUnit("inf",50));
        army.add(new CavalryUnit("cav",80));
        army.add(new CommanderUnit("com",100));
        army.add(new RangedUnit("ranged2",100));



    }

    @Test
    void testFailReadCSV()
    {
        army.getAllUnits().get(0).setHealth(50);
        ArmyFileHandler.writeCSV(army, Path.of("units.csv"));
        army.getAllUnits().get(0).setHealth(100);
        Army readArmy = ArmyFileHandler.readCSV(Path.of("units.csv"));
        assertEquals(army,readArmy);
        assertEquals("Warriors", readArmy.getName());
        for(int i = 0; i<readArmy.getAllUnits().size(); i++)
        {
            Unit newUnit = readArmy.getAllUnits().get(i);
            Unit ogUnit = army.getAllUnits().get(i);
            if(newUnit.getHealth() == ogUnit.getHealth()) {
                assertEquals(newUnit.getHealth(), ogUnit.getHealth());
            }
            else {
                assertNotEquals(newUnit.getHealth(), ogUnit.getHealth());
            }
        }
    }


    @Test
    void testWriteAndReadCSV()
    {
        ArmyFileHandler.writeCSV(army, Path.of("units.csv"));
        Army readArmy = ArmyFileHandler.readCSV(Path.of("units.csv"));
        assertEquals(army,readArmy);
    }

}