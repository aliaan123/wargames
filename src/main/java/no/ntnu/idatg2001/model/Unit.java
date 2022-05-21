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
     * Copy constructor of Unit
     */
    protected Unit(Unit unit)
    {
        this.copy(unit);
        //this.name = unit.name;
        //this.health = unit.health;
        //this.attack = unit.attack;
        //this.armor = unit.armor;
    }

    /**
     *
     * @param unit
     */
    public abstract Unit copy(Unit unit);

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
     * Abstract method that gives the units bonus attack power.
     *
     * @return an int representing the bonus attack power
     */
    public abstract int getAttackBonus(String terrain);


    /**
     * Abstract method that gives the units bonus resistance.
     *
     * @return an int representing the bonus armor points the unit gets.
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
     *
     * @param attack
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }


    /**
     * Method for getting the type of unit,
     * by splitting up the toString of the class, and returning the Class of the object
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
