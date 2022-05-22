package no.ntnu.idatg2001.model;

/**
 * InfantryUnit class which is a subclass of Unit, a specialized type of unit.
 * @author Aliaan
 * @version 0.0.1
 */
public class InfantryUnit extends Unit {

    // Field for the attack bonus of the infantry unit
    private static final int ATTACK_BONUS = 2;
    // Field for the resist bonus of the infantry unit
    private static final int RESIST_BONUS = 1;

    /**
     * Constructor of the InfantryUnit class
     * @param name takes in name of the infantryUnit as parameter
     * @param health takes in health of the infantryUnit as parameter
     * @param attack takes in the attack power of the infantryUnit as parameter
     * @param armor takes in the armor points of the infantryUnit as parameter
     */
    public InfantryUnit(String name, int health, int attack, int armor)
    {
        super(name, health, attack, armor);
    }


    /**
     * Simplified constructor used for instantiating objects of this class.
     * It calls the super-classes constructor through the super-method.
     * @param name takes in the name of the infantryUnit as parameter
     * @param health takes in the health of the infantryUnit as parameter
     */
    public InfantryUnit(String name, int health)
    {
        super(name, health, 15, 10);
    }

    /**
     * Method that overrides the getAttackBonus method of the superclass.
     * @return returns an int value representing the bonus added to the infantryUnits attack power
     */
    @Override
    public int getAttackBonus(String terrain)
    {
        return ATTACK_BONUS + terrainAttackBonus(terrain);
    }

    /**
     * Method that overrides the getResistBonus method of the superclass.
     * @return returns an int value representing the bonus added to the infantryUnits armor
     */
    @Override
    public int getResistBonus(String terrain) {
        return RESIST_BONUS + terrainResistBonus(terrain);
    }


    /**
     * Method for adding an attack bonus to the unit,
     * based on the terrain of the battlefield.
     * @param terrain takes in a String as parameter,
     *                representing the terrain.
     * @return returns an attack bonus based on what the terrain is.
     */
    public int terrainAttackBonus(String terrain)
    {
        int attackBonus = 0;
        if(terrain.equals("FOREST"))
        {
            attackBonus = 5;
        }
        return attackBonus;
    }


    /**
     * Method for adding a resist bonus to the unit,
     * based on the terrain of the battlefield.
     * @param terrain takes in a String as a parameter,
     *                representing the terrain.
     * @return returns a resist bonus based on what terrain the battle is fought in.
     */
    public int terrainResistBonus(String terrain)
    {
        int resistBonus = 0;
        if(terrain.equals("FOREST"))
        {
            resistBonus  = 5;
        }
        return resistBonus;
    }


    /**
     * Method that is user for copying another unit
     * @return returns a copy of a unit
     */
    @Override
    public Unit copy() {
        return new InfantryUnit(this.getName(), this.getHealth(), this.getAttack(), this.getArmor());
    }

    @Override
    public String toString() {
        return super.toString() + ", unit type=Infantry Unit}";
    }

}
