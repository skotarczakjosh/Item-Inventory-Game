/** The Class Models a Coin Item with itemName, itemLocation, unique, use, hidden, coinValue and metalType
 * @author Josh Skotarczak
 */
public class Coin extends TreasureItem {
    /***
     * the value of the coin
     */
    private int coinValue;
    /***
     * the metal type of the coin
     */
    private String metalType;
    /***
     * Constructs Default Coin Object With No Values "No Args"
     */
    public Coin() {
    }
    /***
     * Constructs Coin Object With Given Values "All Args"
     *
     * @param itemName the name of the coin item
     * @param itemLocation the location of the coin item
     * @param unique indicates if the coin item is unique or not
     * @param use describes what the coin is used for
     * @param  hidden indicates if the coin is a hidden item or not
     * @param  coinValue the value of the coin
     */
    public Coin(String itemName, String itemLocation, Boolean unique, String use, Boolean hidden, int coinValue, String metalType) {
        super(itemName, itemLocation, unique, use, hidden);
        this.coinValue = coinValue;
        this.metalType = metalType;
    }
    /***
     * Gets the value of the coin
     *
     * @return the value of the coin
     */
    public int getCoinValue() {
        return coinValue;
    }
    /***
     * Gets the metal type of the coin
     *
     * @return the metal type of the coin
     */
    public String getMetalType() {
        return metalType;
    }
    /***
     * Sets the value of the coin
     *
     * @param coinValue the coinValue to set
     */
    public void setCoinValue(int coinValue) {
        this.coinValue = coinValue;
    }
    /***
     * Sets the metal type of the coin
     *
     * @param metalType the metalType to set
     */
    public void setMetalType(String metalType) {
        this.metalType = metalType;
    }
    /**
     * The String representation of the coin's itemName, itemLocation, unique, use, hidden, coinValue and metalType
     *
     * @return the coin's itemName, itemLocation, unique, use, hidden, coinValue and metalType
     */
    @Override
    public String toString() {
        return "Coin - Treasure Item" + '\n' + super.toString() + '\n' +
                "Coin Value: " + coinValue + '\n' + "Metal Type: " + metalType;
    }
    /**
     * The String representation when the coin is activated
     */
    @Override
    public void activate() {
        System.out.println("The Coin, " + super.getItemName() + ", has been activated. You can now spend it." );
    }
    /**
     * The String representation when the coin is used
     */
    @Override
    public void use() {
        System.out.println("The Coin, " + super.getItemName() + ", is in use. Buy something nice for yourself." );
    }
    /**
     * The String representation when the coin is expired
     */
    @Override
    public void expire() {
        System.out.println("The Coin, " + super.getItemName() + ", is now expired. The coin can only be spent once." );
    }
}
