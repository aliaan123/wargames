package no.ntnu.idatg2001.wargames;


/**
 * RangedUnit class which is a subclass of Unit, a specialized type of unit.
 * @author Aliaan
 * @version 0.0.1
 */
public class RangedUnit extends Unit {

    // Field for if the unit is melee or not.
    private static final boolean IS_MELEE = false;


    /**
     * Constructor of the RangedUnit class
     * @param name takes in name of the RangedUnit as parameter
     * @param health takes in health of the RangedUnit as parameter
     * @param attack takes in the attack power of the RangedUnit as parameter
     * @param armor takes in the armor points of the RangedUnit as parameter
     */
    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Simplified constructor used for instantiating objects of this class.
     * It calls the super-classes constructor through the super-method.
     * @param name takes in the name of the infantryUnit as parameter
     * @param health takes in the health of the infantryUnit as parameter
     */
    public RangedUnit(String name, int health) {
        super(name, health, 15, 8);
        //rangedUnit = new RangedUnit("Ranged Unit", 100);
    }


    /**
     * Method that returns information about the range of the unit
     * @return the field IS_MELEE, which is false because the rangedUnit is ranged
     */
    public boolean getRangeOfUnit() {
        return IS_MELEE;
    }

    /**
     * Method that overrides the getAttackBonus method of the superclass.
     * @return returns an int value representing the bonus added to the rangedUnits attack power
     */
    @Override
    public int getAttackBonus() {
        int attackBonus = 0;
        /*
        if () {
            attackBonus = 3;
        }

         */
        return attackBonus;

    }


    /**
     * Method that overrides the getResistBonus method of the superclass.
     * @return returns an int value representing the bonus added to the rangedUnits armor
     */
    @Override
    public int getResistBonus() {
        int resistBonus = 6;
        return resistBonus;

    }
}
