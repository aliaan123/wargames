package no.ntnu.idatg2001.wargames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Aliaan
 *
 * Class representing a unit factory.
 * Uses the factory design pattern.
 */
public class UnitFactory {

    // Field for the list of units when creating multiple in the factory
    private static List<Unit> units;


    /**
     * Private constructor of the UnitFactory class
     */
    private UnitFactory()
    {

    }

    /**
     * Method in the factory for creating a unit.
     * Uses switch cases, and the switch case matching the String unitType will run.
     * @param unitType takes in String unitType as parameter, which is used for running one of the switch cases.
     * @param unitName takes in String unitName as parameter, which is the name of the unit created.
     * @param health takes in an int health as parameter, which is for setting health of the unit created.
     * @return returns a unit with the given unit type, unit name and health.
     */
    public static Unit factoryCreatingUnit(String unitType, String unitName, int health)
    {
        switch(unitType)
        {
            case "Infantry Unit":
                return new InfantryUnit(unitName, health);
            case "Ranged Unit":
                return new RangedUnit(unitName, health);
            case "Cavalry Unit":
                return new CavalryUnit(unitName, health);
            case "Commander Unit":
                return new CommanderUnit(unitName, health);
            default:
                return null;
        }
    }

    /**
     * Method in the factory for creating multiple units at once.
     * Uses switch cases, and the switch case matching the String unitType will run.
     * @param unitType takes in String unitType as parameter, which is used for running one of the switch cases.
     * @param unitName takes in String unitName as parameter, which is the name of the unit created.
     * @param health takes in an int health as parameter, which is for setting health of the units created.
     * @param amount takes in an int amount as parameter, which decides the number of the units created.
     * @return returns a list of units with size equal to the int amount sent in the parameter,
     * all with the same unit type, unit name, health.
     */
    public static List<Unit> factoryCreatingMultipleUnits(String unitType, String unitName, int health, int amount)
    {
        units = new ArrayList<>();
        switch(unitType)
        {
            case "Infantry Unit":
                for (int i = 0; i < amount; i++) {
                    units.add(new InfantryUnit(unitName, health));
                }
                return units;
            case "Ranged Unit":
                for (int i = 0; i < amount; i++) {
                    units.add(new RangedUnit(unitName, health));
                }
                return units;
            case "Cavalry Unit":
                for (int i = 0; i < amount; i++) {
                    units.add(new CavalryUnit(unitName, health));
                }
                return units;
            case "Commander Unit":
                for (int i = 0; i < amount; i++) {
                    units.add(new CommanderUnit(unitName, health));
                }
                return units;
            default:
                return Collections.emptyList();
        }
    }

    /**
     * Method for returning the list of units created in the factory
     * @return returns a list of units
     */
    public static List<Unit> getUnits() {
        return units;
    }

}
