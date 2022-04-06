package no.ntnu.idatg2001.wargames;


/**
 * CavalryUnit class which is a subclass of Unit, a specialized type of unit.
 * @author Aliaan
 * @version 0.0.1
 */
public class CavalryUnit extends Unit {

    // Field for if the unit is melee or not.
    private static final boolean IS_MELEE = true;
    // Field for the resist bonus of the cavalry unit.
    private static final int RESIST_BONUS = 1;
    // Field for attack bonus of the cavalry unit.
    private int attackBonus = 6;

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
        if(attackBonus > 2)
        {
            attackBonus -= 2;
        }
        return attackBonus;
    }


    /**
     * Method that overrides the getResistBonus method of the superclass.
     * @return returns an int value representing the bonus added to the cavalryUnits armor
     */
    @Override
    public int getResistBonus()
    {
        return RESIST_BONUS;
    }

    @Override
    public String toString() {
        return super.toString() + ", unit type=Cavalry Unit}";
    }
}
