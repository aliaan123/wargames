package no.ntnu.idatg2001.wargames;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class UnitFactory {

    private Scanner readInput;
    private String unitType;
    private String unitName;
    private int health;
    private List<Unit> units;

    /**
     *
     */
    public UnitFactory()
    {
        readInput = new Scanner(System.in);
        units = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public Unit factoryCreatingUnit()
    {
        System.out.println("Enter the unit type: ");
        String unitType = readInput.nextLine();
        while (!validateString(unitType)) {
            System.out.println("Please enter a valid input");
            unitType = readInput.nextLine();
        }

        System.out.println("Enter the name of the unit: ");
        String unitName = readInput.nextLine();
        while (!validateString(unitName)) {
            System.out.println("Please enter a valid input");
            unitName = readInput.nextLine();
        }

        System.out.println("Enter the health of the unit: ");
        int health = 0;
        boolean isHealth;
        do {
            if (readInput.hasNextInt()) {
                health = readInput.nextInt();
                readInput.nextLine();
                isHealth = true;
            } else {
                System.out.println("Please enter a valid number.");
                isHealth = false;
                readInput.next();
            }
        } while (!isHealth);

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
    public List<Unit> factoryCreatingMultipleUnits()
    {

        System.out.println("Enter the unit type: ");
        String unitType = readInput.nextLine();
        while (!validateString(unitType)) {
            System.out.println("Please enter a valid input");
            unitType = readInput.nextLine();
        }

        System.out.println("Enter the name of the unit: ");
        String unitName = readInput.nextLine();
        while (!validateString(unitName)) {
            System.out.println("Please enter a valid input");
            unitName = readInput.nextLine();
        }

        System.out.println("Enter the health of the unit: ");
        int health = 0;
        boolean isHealth;
        do {
            if (readInput.hasNextInt()) {
                health = readInput.nextInt();
                readInput.nextLine();
                isHealth = true;
            } else {
                System.out.println("Please enter a valid number.");
                isHealth = false;
                readInput.next();
            }
        } while (!isHealth);

        System.out.println("Enter the amount of these units you want: ");
        int amount = 0;
        boolean isAmount;
        do {
            if (readInput.hasNextInt()) {
                amount = readInput.nextInt();
                readInput.nextLine();
                isAmount = true;
            } else {
                System.out.println("Please enter a valid number.");
                isAmount = false;
                readInput.next();
            }
        } while (!isAmount);

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

    public void validateInput()
    {
        System.out.println("Enter the unit type: ");
        String unitType = readInput.nextLine();
        while (!validateString(unitType)) {
            System.out.println("Please enter a valid input");
            unitType = readInput.nextLine();
        }

        System.out.println("Enter the name of the unit: ");
        String unitName = readInput.nextLine();
        while (!validateString(unitName)) {
            System.out.println("Please enter a valid input");
            unitName = readInput.nextLine();
        }

        System.out.println("Enter the health of the unit: ");
        int health = 0;
        boolean isHealth;
        do {
            if (readInput.hasNextInt()) {
                health = readInput.nextInt();
                readInput.nextLine();
                isHealth = true;
            } else {
                System.out.println("Please enter a valid number.");
                isHealth = false;
                readInput.next();
            }
        } while (!isHealth);

    }


    /**
     * Method that validates the String input given by user
     * @param string takes in String as a parameter
     * @return returns a boolean, true if the length of the string is more than 0,
     * or false if it is not.
     */
    public boolean validateString(String string)
    {
        if(string.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        UnitFactory unitFactory = new UnitFactory();
        Unit unit = unitFactory.factoryCreatingUnit();
        System.out.println(unit);

        /*
        List<Unit> unitList = unitFactory.factoryCreatingMultipleUnits();
        for (Unit unit : unitList)
        {
            System.out.println(unit);
        }


         */
    }

}
