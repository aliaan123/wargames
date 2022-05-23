package no.ntnu.idatg2001.model;

/**
 * The unit superclass representing a single unit in an army
 *
 * @author Aliaan
 * @version 0.0.1
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
    // type of the unit
    private String unitType;

    /**
     * Constructor of the Unit class.
     * Creates a new unit.
     *
     * @param name   The name of the unit
     * @param health The health of the unit
     * @param attack The attack power of the unit
     * @param armor  The armor points of the unit
     */
    protected Unit(String name, int health, int attack, int armor) {
        this.name = name;
        if (health < 0) {
            setHealth(000);
        } else {
            this.health = health;
        }
        this.attack = attack;
        this.armor = armor;

    }

    /**
     * Abstract method that is used for coping units.
     * @return returns a copied unit
     */
    public abstract Unit copy();

    /**
     * Method that allows units to attack each other and reduce their health.
     *
     * @param opponent the opponent unit that is getting attacked
     * @param terrain the terrain of the battlefield
     */
    public void attack(Unit opponent, String terrain) {
        opponent.setHealth(opponent.getHealth() - (this.attack + this.getAttackBonus(terrain))
                + opponent.getArmor() + opponent.getResistBonus(terrain));
    }

    /**
     * Abstract method that gives the units bonus attack power based on the terrain.
     * @param terrain takes in the terrain of the battle as a parameter.
     * @return returns a bonus in attack damage
     */
    public abstract int getAttackBonus(String terrain);



    /**
     * Abstract method that gives the units bonus resistance based on the terrain.
     * @param terrain takes in the terrain of the battle as a parameter
     * @return returns the bonus resist armor
     */
    public abstract int getResistBonus(String terrain);



    /**
     * Method for getting the name of the unit.
     *
     * @return name of unit.
     */
    public String getName() {
        return name;
    }

    /**
     * Method for getting the health points of the unit.
     *
     * @return health of the unit.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Method that sets the health of a unit after an attack.
     *
     * @param health of unit
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Method for getting the attack power of the unit.
     *
     * @return attack power of unit
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Method for getting the armor points of the unit.
     *
     * @return armor points of unit
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Method that sets the attack stat of a unit.
     * @param attack takes in an int, representing the unit's attack damage, as a parameter.
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Method that sets the name of the unit.
     * @param name takes in a String, the name of the unit, as parameter.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that sets the armor of the unit.
     * @param armor takes in an int, representing the unit's armor points, as a parameter.
     */
    public void setArmor(int armor) {
        this.armor = armor;
    }


    /**
     * Method for getting the units type
     * @return a String representing the class of the object, which is the type of the unit
     */
    public String getUnitType() {
        return getClass().getSimpleName();
    }


    /**
     * Method that overrides the toString method of the Unit class.
     *
     * @return a String containing information about the unit.
     */
    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armor=" + armor;
    }
}
