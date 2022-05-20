package no.ntnu.idatg2001.model;


/**
 * CavalryUnit class which is a subclass of Unit, a specialized type of unit.
 * @author Aliaan
 * @version 0.0.1
 */
public class CavalryUnit extends Unit {

    // Field for if the unit is melee or not.
    private static final boolean IS_MELEE = true;
    // Field for attack bonus of the cavalry unit.
    private int attackBonus = 6;
    // Field for the resist bonus of the cavalry unit.
    private int resistBonus = 2;

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
    public int getAttackBonus(String terrain) {

        if(attackBonus > 2) {
                attackBonus -= 2;
            }
        return attackBonus + terrainAttackBonus(terrain);

    }

    /**
     * Method that overrides the getResistBonus method of the superclass.
     * @return returns an int value representing the bonus added to the cavalryUnits armor
     */
    @Override
    public int getResistBonus(String terrain)
    {
        return terrainResistBonus(terrain);

    }

    /**
     * Method for adding an attack bonus to the unit,
     * based on the terrain of the battlefield.
     * @param terrain takes in a String as a parameter
     * @return returns an attack bonus based on what the terrain is.
     */
    public int terrainAttackBonus(String terrain)
    {
        int terrainAttackBonus = 0;
        if(terrain.equals("PLAINS"))
        {
            terrainAttackBonus = 2;
        }
        return terrainAttackBonus;
    }


    /**
     * Method for adding a resist bonus to the unit,
     * based on the terrain of the battlefield.
     * If the terrain is a forest, the unit has no resist bonus.
     * If the terrain is something else, then the bonus is set to 2.
     * @param terrain takes a String in as a parameter
     * @return returns the resist bonus based on what the terrain is.
     */
    public int terrainResistBonus(String terrain)
    {
        if(terrain.equals("FOREST"))
        {
            setResistBonus(0);
        }
        else
        {
            setResistBonus(2);
        }
        return resistBonus;
    }

    /**
     * Method for setting the resist bonus of cavalry units.
     * @param resistBonus takes an int in as a parameter
     */
    public void setResistBonus(int resistBonus) {
        this.resistBonus = resistBonus;
    }


    @Override
    public String toString() {
        return super.toString() + ", unit type=Cavalry Unit}";
    }
}
