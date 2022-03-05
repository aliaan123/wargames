package no.ntnu.idatg2001.wargames;

import java.util.Iterator;

/**
 * @author Aliaan
 * @version 0.0.1
 *
 * Class that simulates the battle between armies.
 */
public class Battle {

    // Field for army number one
    private Army armyOne;
    // Field for army number two
    private Army armyTwo;

    /**
     * Constructor of the Battle class
     * @param armyOne takes in an army as parameter.
     * @param armyTwo takes in another army as parameter.
     */
    public Battle(Army armyOne, Army armyTwo)
    {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    /**
     * Method which makes the armies battle each other.
     * One random army from army one attacks a random army from army two,
     * and a random army from army two attacks a random army from army one.
     * The fight continues until one of the armies has no units left.
     * Will also handle the exception thrown from the getRandom method.
     * @return returns the army who won the battle.
     */
    public Army simulate() {
        do {
            try {
                //One random unit from armyOne attacks a random unit from armyTwo.
                armyOne.getRandom().attack(armyTwo.getRandom());
            }catch (NullPointerException e) {
                //checks which of the armies that still has units left after battle, and returns that army.
                checkIfArmyHasUnits();
            }
            //removes units from armyTwo that have dead in the battle.
            removeDeadUnitsInArmy(armyTwo);

            try {
                //one random unit from armyTwo attacks a random unit from armyOne.
                armyTwo.getRandom().attack(armyOne.getRandom());
            } catch (NullPointerException e) {
                checkIfArmyHasUnits();
            }
            //removes units from armyOne that have dead in the battle.
            removeDeadUnitsInArmy(armyOne);

        }while(armyOne.hasUnits() && armyTwo.hasUnits());

        if (armyOne.unitsSize() > armyTwo.unitsSize()) {
            return armyOne;
        } else {
            return armyTwo;
        }

    }

    /**
     * Method that takes in an army and iterates through the units in it.
     * If a unit in the army has health less or equal to zero it has died in battle,
     * and therefore gets removed from the army.
     * @param army Takes in army object as parameter
     */
    public void removeDeadUnitsInArmy(Army army)
    {
        Iterator<Unit> armyIterator = army.getAllUnits().iterator();
        while (armyIterator.hasNext())
        {
            Unit currentUnit = armyIterator.next();
            if(currentUnit.getHealth() <= 0) {
                armyIterator.remove();
            }
        }
    }

    /**
     * Method that will check if an army still has units after a battle.
     * The army that still has units left after the war, will be returned.
     * @return returns the army that still has units.
     */
    public Army checkIfArmyHasUnits()
    {
        if(armyOne.hasUnits()) {
            return armyOne;
        } else {
            return armyTwo;
        }
    }


    /**
     * Method that overrides the toString method of the Battle class
     * @return returns a String of the two armies
     */
    @Override
    public String toString() {
        return "Battle{" +
                "armyOne=" + armyOne +
                ", armyTwo=" + armyTwo +
                '}';
    }
}
