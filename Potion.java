/** The Class Models a Potion Item with itemName, itemLocation, unique, description, healthValue, duration, potency
 * @author Josh Skotarczak
 */
public class Potion extends HealthItem implements Magical {
    /***
     * the duration of the potion
     */
    private int duration;
    /***
     * the potency of the potion
     */
    private double potency;
    /***
     * Constructs Default Potion Object With No Values "No Args"
     */
    public Potion() {
    }
    /***
     * Constructs Potion Object With Given Values "All Args"
     *
     * @param itemName the name of the potion item
     * @param itemLocation the location of the potion item
     * @param unique indicates if the potion item is unique or not
     * @param description  brief explanation of what the potion is used for
     * @param  healthValue the health value of the potion
     * @param duration the duration of the potion
     * @param potency the potency of the potion
     */
    public Potion(String itemName, String itemLocation, Boolean unique, String description, int healthValue, int duration, double potency) {
        super(itemName, itemLocation, unique, description, healthValue);
        this.duration = duration;
        this.potency = potency;
    }
    /***
     * Gets the duration of the potion
     *
     * @return the duration of the potion
     */
    public int getDuration() {
        return duration;
    }
    /***
     * Gets the potency of the potion
     *
     * @return the potency of the potion
     */
    public double getPotency() {
        return potency;
    }
    /***
     * Sets the duration of the potion
     *
     * @param duration the duration of the potion
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
    /***
     * Sets the potency of the potion
     *
     * @param potency the potency of the potion
     */
    public void setPotency(double potency) {
        this.potency = potency;
    }
    /**
     * The String representation of the potion's itemName, itemLocation, unique, description, healthValue, duration, potency
     *
     * @return the potion's itemName, itemLocation, unique, description, healthValue, duration, potency
     */
    @Override
    public String toString() {
        return "Potion - Health Item" + '\n' + super.toString() + '\n'
                + "Duration: " + duration + '\n' + "Potency: " + potency;
    }
    /**
     * The String representation when the potion is activated
     */
    @Override
    public void activate() {
        System.out.println("The Potion, " + super.getItemName() + ", has been activated. Time to drink up!" );
    }
    /**
     * The String representation when the potion is used
     */
    @Override
    public void use() {
        System.out.println("The Potion, " + super.getItemName() + ", is in use. I hope this is a good potion!" );
    }
    /**
     * The String representation when the potion is expired
     */
    @Override
    public void expire() {
        System.out.println("The Potion, " + super.getItemName() + ", is now expired. Don't drink this potion!" );
    }
    /**
     * The String representation when the potion is used to grant a wish
     */
    @Override
    public void grantWish() {
        System.out.println("The Potion, " + super.getItemName() + ", was used to grant a wish!" );
    }
    /**
     * The String representation when the potion is used to cast a spell
     */
    @Override
    public void castSpell() {
        System.out.println("The Potion, " + super.getItemName() + ", was used to cast a spell!" );
    }
}
