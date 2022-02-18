package no.ntnu.idatg2001.wargames;


/**
 * CommanderUnit class which is a subclass of the CavalryUnit, a specialized type of unit.
 * @author Aliaan
 * @version 0.0.1
 */
public class CommanderUnit extends CavalryUnit{

    /**
     * Constructor of the CommanderUnit class
     * @param name takes in name of the CommanderUnit as parameter
     * @param health takes in health of the CommanderUnit as parameter
     * @param attack takes in the attack power of the CommanderUnit as parameter
     * @param armor takes in the armor points of the CommanderUnit as parameter
     */
    public CommanderUnit(String name, int health, int attack, int armor)
    {
        super(name, health, attack, armor);
    }


    /**
     * Simplified constructor used for instantiating objects of this class.
     * It calls the super-classes constructor through the super-method.
     * @param name takes in the name of the infantryUnit as parameter
     * @param health takes in the health of the infantryUnit as parameter
     */
    public CommanderUnit(String name, int health)
    {
        super(name, health);
        //Unit commanderUnit = new CommanderUnit(name, health, 25, 15);
    }

    @Override
    public boolean getRangeOfUnit() {
        return super.getRangeOfUnit();
    }
}
