package no.ntnu.idatg2001.model;


/**
 * RangedUnit class which is a subclass of Unit, a specialized type of unit.
 * @author Aliaan
 * @version 0.0.1
 */
public class RangedUnit extends Unit {

    // Field for if the unit is melee or not.
    private static final boolean IS_MELEE = false;
    // Field for the attack bonus of the ranged unit
    private static final int ATTACK_BONUS = 3;
    // Field for the ranged units resist-bonus.
    private int resistBonus = 8;


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
    }


    /**
     * Method that returns information about the range of the unit
     * @return the field IS_MELEE, which is false because the rangedUnit is ranged
     */
    public boolean getRangeOfUnit() {
        return IS_MELEE;
    }

    /**
     * Method for adding an attack bonus to the unit attack damage,
     * based on the terrain of the battlefield.
     *
     * @return returns the bonus in attack damage.
     */
    public int terrainAttackBonus(String terrain)
    {
        int attackBonus = 0;
        if(terrain.equals("HILL"))
        {
            attackBonus = 5;
        }
        else if (terrain.equals("FOREST"))
        {
            attackBonus = 3;
        }
        return attackBonus;
    }

    /**
     * Method that overrides the getAttackBonus method of the superclass.
     * @return returns an int value representing the bonus added to the rangedUnits attack power
     */
    @Override
    public int getAttackBonus(String terrain) {
        return ATTACK_BONUS + terrainAttackBonus(terrain);
    }

    /**
     * Method that overrides the getResistBonus method of the superclass.
     * @return returns an int value representing the bonus added to the rangedUnits armor
     */
    @Override
    public int getResistBonus(String terrain) {
        if(resistBonus == 2)
        {
            return 2;
        }
        else {
            resistBonus -= 2;
            return resistBonus;
            }
        }

    @Override
    public String toString() {
        return super.toString() + ", unit type=Ranged Unit}";
    }

}
