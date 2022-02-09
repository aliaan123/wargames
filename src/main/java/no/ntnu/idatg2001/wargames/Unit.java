package no.ntnu.idatg2001.wargames;

/**
 * @author Aliaan
 * @version 0.0.1
 */

/**
 * The Unit superclass
 */
public abstract class Unit {

    // name of the unit
    private String name;
    // health points of the unit. This can not be less than 0
    private int health;
    // attack power of the unit
    private int attack;
    // armor points of the unit
    private int armor;

    /**
     * Constructor of the Unit class.
     * Creates a new unit.
     * @param name The name of the unit
     * @param health The health of the unit
     * @param attack The attack power of the unit
     * @param armor The armor points of the unit
     */
    public Unit(String name, int health, int attack, int armor)
    {
        if (health < 0)
        {
            health = 000;
        }


    }

    /**
     * Method that allows units to attack eachother and reduce their health.
     * @param opponent a opponents unit that is getting attacked
     */
    public void attack(Unit opponent)
    {
        health -= (this.attack + this.getAttackBonus()) + (opponent.getArmor() + opponent.getResistBonus());
        opponent.setHealth(health);
    }

    /**
     * Abstract method that gives the units bonus attack power.
     * @return an int representing the bonus attack power
     */
    public abstract int getAttackBonus();


    /**
     * Abstract method that gives the units bonus resistance.
     * @return an int representing the bonus armor points the unit gets.
     */
    public abstract int getResistBonus();

    /**
     * Method for getting the name of the unit.
     * @return name of unit.
     */
    public String getName() {
        return name;
    }

    /**
     * Method for getting the health points of the unit.
     * @return health of the unit.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Method that sets the health of a unit after an attack
     * @param health of unit
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Method for getting the attack power of the unit
     * @return attack power of unit
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Method for getting the armor points of the unit
     * @return armor points of unit
     */
    public int getArmor() {
        return armor;
    }


    /**
     * Method that overrides the toString method of the Unit class.
     * @return a String containing information about the unit.
     */
    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armor=" + armor +
                '}';
    }
}
