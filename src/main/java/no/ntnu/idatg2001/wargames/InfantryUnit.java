package no.ntnu.idatg2001.wargames;

/**
 * InfantryUnit class which is a subclass of Unit, a specialized type of unit.
 * @author Aliaan
 * @version 0.0.1
 */
public class InfantryUnit extends Unit {

    // Field for if the unit is melee or not.
    private static final boolean IS_MELEE = true;

    private Unit opponent;

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
        //infantryUnit = new InfantryUnit("Infantry Unit", 100);
        opponent = new CavalryUnit("Cav", 100);

    }

    /**
     * Method that returns information about the range of the unit
     * @return the field IS_MELEE, which is true because the infantryUnit is melee
     */
    public boolean getRangeOfUnit()
    {
        return IS_MELEE;
    }

    /**
     * Method that overrides the getAttackBonus method of the superclass.
     * @return returns an int value representing the bonus added to the infantryUnits attack power
     */

    @Override
    public int getAttackBonus()
    {
        int attackBonus = 0;
        if(this.checkIfOpponentIsMeleeOrRange(opponent))
        {
            attackBonus = 2;
            return attackBonus;
        }
        return attackBonus;
    }


    /*
    @Override
    public int getAttackBonus()
    {
        int attackBonus = 0;
        if(opponent.getRangeOfUnit())
        {
            attackBonus = 2;
            return attackBonus;
        }
        return attackBonus;
    }

     */

    /**
     * Method that overrides the getResistBonus method of the superclass.
     * @return returns an int value representing the bonus added to the infantryUnits armor
     */
    @Override
    public int getResistBonus() {
        return 1;
    }
}
