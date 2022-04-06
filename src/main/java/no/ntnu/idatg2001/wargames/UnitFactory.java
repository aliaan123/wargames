package no.ntnu.idatg2001.wargames;

import java.util.ArrayList;
import java.util.List;

public class UnitFactory {

    private static List<Unit> units;

    /**
     *
     */
    private UnitFactory()
    {
        //units = new ArrayList<>();
    }


    /**
     *
     * @return
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
     *
     * @return
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
                return null;
        }
    }

    public static List<Unit> getUnits() {
        return units;
    }

}
