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
        army.add(new RangedUnit("yoobz",100));
        army.add(new InfantryUnit("yoobie",70));
        army.add(new CavalryUnit("aza",80));
        army.add(new InfantryUnit("yub",90));
        army.add(new CommanderUnit("kev",100));
        army.add(new RangedUnit("tati",100));
        army.add(new CavalryUnit("david",80));


    }

    @Test
    void testFailReadCSV()
    {
        army.getAllUnits().get(0).setHealth(50);
        ArmyFileHandler.writeCSV(army, Path.of("src/main/resources/SavedArmy/units.csv"));
        army.getAllUnits().get(0).setHealth(100);
        Army readArmy = ArmyFileHandler.readCSV(Path.of("src/main/resources/SavedArmy/units.csv"));
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
        ArmyFileHandler.writeCSV(army, Path.of("src/main/resources/SavedArmy/units.csv"));
        Army readArmy = ArmyFileHandler.readCSV(Path.of("src/main/resources/SavedArmy/units.csv"));
        assertEquals(army,readArmy);
    }

}