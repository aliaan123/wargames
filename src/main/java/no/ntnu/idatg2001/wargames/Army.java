package no.ntnu.idatg2001.wargames;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Aliaan
 * @version 0.0.1
 *
 * Army class is a collection of units that can attack other units in a war.
 */
public class Army {

    // Field for the name of the army
    private String name;
    // Field for the list of units
    private List<Unit> units;
    // Field for random generated number
    private Random randomNumber;

    /**
     * Simplified constructor of the Army class.
     * @param name takes in name of the army as a parameter.
     */
    public Army(String name)
    {
        this.name = name;
        units = new ArrayList<>();
        randomNumber = new Random();
    }


    /**
     * Constructor of the Army class.
     * @param name Takes in name of the army as a parameter.
     * @param units Takes in a list of units as a parameter.
     */
    public Army(String name, List<Unit> units)
    {
        this.name = name;
        this.units = units;
        randomNumber = new Random();
    }


    /**
     * Method for getting the name of the army.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Method that adds a single unit to the list of units.
     * @param unit Takes a unit object as a parameter
     */
    public void add(Unit unit)
    {
        units.add(unit);
    }

    /**
     * Method that adds all units from input list in the parameter to the list of units.
     * @param units Takes in a new list of units as a parameter
     */
    public void addAll(List<Unit> units)
    {
        for(Unit unit : units)
        {
            units.add(unit);
        }
    }

    /**
     * Method for removing a unit from the list of units
     * @param unit takes in the unit that we want removed as a parameter
     */
    public void remove(Unit unit)
    {
        Iterator<Unit> unitIterator = units.iterator();
        while (unitIterator.hasNext())
        {
            Unit currentUnit = unitIterator.next();
            if(currentUnit.equals(unit))
            {
                unitIterator.remove();
            }
        }
    }

    /**
     * Method for getting the list of units
     * @return returns the list containing all the units
     */
    public List<Unit> getAllUnits()
    {
        return units;
    }

    /**
     * Method for checking if the list of units is empty or if it has units within it.
     * @return Returns a boolean, false if the list is empty or true otherwise.
     */
    public boolean hasUnits()
    {
        if(!units.isEmpty())
        {
            return true;
        }
        return false;
    }

    /**
     * Method that returns an int the size of the list of units
     * @return an int representing the amount of units in the list
     */
    public int unitsSize()
    {
        return this.units.size();
    }


    /**
     * Method that returns a random unit from the list of units,
     * packed within a try-catch which will try to return a random index
     * from the units size. If the size of the list of units is empty, and exception is thrown,
     * and it will return null.
     * @return a random Unit object from the list.
     */
    public Unit getRandom() {
        try {
            int index = randomNumber.nextInt(units.size());
            return units.get(index);
        } catch (IllegalArgumentException iae) {
            return null;
        }
    }


    /**
     * Method for getting all infantry units in an army
     * @return returns a list with infantry units.
     */
    public List<Unit> getInfantryUnits()
    {
        return units.stream().filter(unit -> "Infantry Unit".equals(unit.getName())).
                collect(Collectors.toCollection(ArrayList::new));

    }

    /**
     * Method for getting all cavalry units in an army
     * @return returns a list with cavalry units.
     */
    public List<Unit> getCavalryUnits()
    {
        return units.stream().filter(unit -> "Cavalry Unit".equals(unit.getName())).
                collect(Collectors.toCollection(ArrayList::new));

    }


    /**
     * Method for getting all ranged units in an army
     * @return returns a list with ranged units.
     */
    public List<Unit> getRangedUnits()
    {
        return units.stream().filter(unit -> "Ranged Unit".equals(unit.getName())).
                collect(Collectors.toCollection(ArrayList::new));

    }










    /**
     * Method that overrides the toString method of the Army class.
     * @return returns a String with the name of the army, and the units within it.
     */
    @Override
    public String toString() {
        return "Army{" +
                "name='" + name + '\'' +
                ", units=" + units +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army army = (Army) o;
        return Objects.equals(name, army.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
