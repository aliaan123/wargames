package no.ntnu.idatg2001.wargames;


/**
 * CavalryUnit class which is a subclass of Unit, a specialized type of unit.
 * @author Aliaan
 * @version 0.0.1
 */
public class CavalryUnit extends Unit {

    // Field for if the unit is melee or not.
    private static final boolean IS_MELEE = true;
    // Field for the number of times the cavalry unit attacks.
    private int attackCount;

    /**
     * Constructor of the CavalryUnit class
     * @param name takes in name of the CavalryUnit as parameter
     * @param health takes in health of the CavalryUnit as parameter
     * @param attack takes in the attack power of the CavalryUnit as parameter
     * @param armor takes in the armor points of the CavalryUnit as parameter
     */
    public CavalryUnit(String name, int health, int attack, int armor)
    {
        super(name, health, attack, armor);
    }


    /**
     * Simplified constructor used for instantiating objects of this class.
     * It calls the super-classes constructor through the super-method.
     * @param name takes in the name of the infantryUnit as parameter
     * @param health takes in the health of the infantryUnit as parameter
     */
    public CavalryUnit(String name, int health)
    {
        super(name, health, 20, 12);
    }


    /**
     * Method that returns information about the range of the unit
     * @return the field IS_MELEE, which is true because the cavalryUnit is melee
     */
    public boolean getRangeOfUnit()
    {
        return IS_MELEE;
    }

    /**
     * Method that overrides the getAttackBonus method of the superclass.
     * @return returns an int value representing the bonus added to the cavalryUnits attack power
     */
    @Override
    public int getAttackBonus() {
        int attackBonus = 4;

        /*
        for(Unit unit : getAllUnits) {
            if (unit.getRangeOfUnit() && this.attackCount == 0)
            {
                attackBonus = 6;
            }
        }
        attackCount++;

         */
        return attackBonus;
    }


    /**
     * Method that overrides the getResistBonus method of the superclass.
     * @return returns an int value representing the bonus added to the cavalryUnits armor
     */
    @Override
    public int getResistBonus()
    {
        int resistBonus = 0;

        /*
        for(Unit unit : getAllUnits) {
            if (unit.getRangeOfUnit())
            {
                resistBonus = 1;
                return resistBonus;
            }
        }
         */

        return resistBonus;
    }
}
