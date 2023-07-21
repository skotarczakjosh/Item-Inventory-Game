/** The Class Models a Food Item with itemName, itemLocation, unique, description, healthValue, livesAdded, perishable
 * @author Josh Skotarczak
 */
public class Food extends HealthItem {
    /***
     * the value of lives added by consuming the food
     */
    private int livesAdded;
    /***
     * indicates if the food is perishable
     */
    private boolean perishable;
    /***
     * Constructs Default Food Object With No Values "No Args"
     */
    public Food() {
    }
    /***
     * Constructs Food Object With Given Values "All Args"
     *
     * @param itemName the name of the food item
     * @param itemLocation the location of the food item
     * @param unique indicates if the food item is unique or not
     * @param description  brief explanation of what the food is used for
     * @param  healthValue the health value of the food
     * @param  livesAdded the value of lives added by consuming the food
     * @param perishable indicates if the food is perishable
     */
    public Food(String itemName, String itemLocation, Boolean unique, String description, int healthValue, int livesAdded, boolean perishable) {
        super(itemName, itemLocation, unique, description, healthValue);
        this.livesAdded = livesAdded;
        this.perishable = perishable;
    }
    /***
     * Gets the value of the lives added by consuming the food
     *
     * @return the value of the lives added by consuming the food
     */
    public int getLivesAdded() {
        return livesAdded;
    }
    /***
     * Gets the boolean value to indicates if the food is perishable
     *
     * @return the boolean value to indicates if the food is perishable
     */
    public boolean isPerishable() {
        return perishable;
    }
    /***
     * Sets the value of the lives added by consuming the food
     *
     * @param livesAdded the value of the lives added by consuming the food
     */
    public void setLivesAdded(int livesAdded) {
        this.livesAdded = livesAdded;
    }
    /***
     * Sets the boolean value to indicates if the food is perishable
     *
     * @param perishable the boolean value to indicates if the food is perishable
     */
    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }
    /**
     * The String representation of the food's itemName, itemLocation, unique, description, healthValue, livesAdded, perishable
     *
     * @return the food's itemName, itemLocation, unique, description, healthValue, livesAdded, perishable
     */
    @Override
    public String toString() {
        String phrase = perishable ? "This item is perishable." : "This item is not perishable.";
        return "Food - Health Item" + '\n' + super.toString() + '\n' +
                "Lives Added: " + livesAdded + '\n' +  phrase;
    }
    /**
     * The String representation when the food is activated
     */
    @Override
    public void activate() {
        System.out.println("The Food, " + super.getItemName() + ", has been activated. Enjoy!" );
    }
    /**
     * The String representation when the food is used
     */
    @Override
    public void use() {
        System.out.println("The Food, " + super.getItemName() + ", is in use. I hope it's tasty!" );
    }
    /**
     * The String representation when the food is expired
     */
    @Override
    public void expire() {
        System.out.println("The Food, " + super.getItemName() + ", is now expired. Please do not eat it!" );
    }
}
