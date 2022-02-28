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
     * Also handels the exception thrown from the getRandom method.
     * @return returns the army who won the battle.
     */
    public Army simulate() {

        do {
            try {
                armyOne.getRandom().attack(armyTwo.getRandom());
            }catch (NullPointerException e)
            {
                if(armyOne.hasUnits()) {
                    return armyOne;
                } else {
                    return armyTwo;
                }
            }
            Iterator<Unit> armyTwoIterator = armyTwo.getAllUnits().iterator();
            while (armyTwoIterator.hasNext())
            {
                Unit currentUnit = armyTwoIterator.next();
                if(currentUnit.getHealth() <= 0) {
                    armyTwoIterator.remove();
                }
            }

            try {
                armyTwo.getRandom().attack(armyOne.getRandom());
            } catch (NullPointerException e)
            {
                if(armyOne.hasUnits()) {
                    return armyOne;
                } else {
                    return armyTwo;
                }
            }
            Iterator<Unit> armyOneIterator = armyOne.getAllUnits().iterator();
            while (armyOneIterator.hasNext())
            {
                Unit currentUnit = armyOneIterator.next();
                if(currentUnit.getHealth() <= 0) {
                    armyOneIterator.remove();
                }
            }

        }while(armyOne.hasUnits() && armyTwo.hasUnits());

        if (armyOne.unitsSize() > armyTwo.unitsSize()) {
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
