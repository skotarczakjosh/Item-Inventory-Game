/** The Class Models a Gem Item with itemName, itemLocation, unique, use, hidden, gemColor, valuable
 * @author Josh Skotarczak
 */
public class Gem extends TreasureItem implements Magical{
    /***
     * the color of the gem
     */
    private String gemColor;
    /***
     * indicates if the gem is valuable
     */
    private boolean valuable;
    /***
     * Constructs Default Gem Object With No Values "No Args"
     */
    public Gem() {
    }
    /***
     * Constructs Gem Object With Given Values "All Args"
     *
     * @param itemName the name of the gem item
     * @param itemLocation the location of the gem item
     * @param unique indicates if the gem item is unique or not
     * @param use describes what the gem is used for
     * @param  hidden indicates if the gem is a hidden item or not
     * @param gemColor the color of the gem
     * @param valuable indicates if the gem is valuable
     */
    public Gem(String itemName, String itemLocation, Boolean unique, String use, Boolean hidden, String gemColor, Boolean valuable) {
        super(itemName, itemLocation, unique, use, hidden);
        this.gemColor = gemColor;
        this.valuable = valuable;
    }
    /***
     * Gets the color of the gem
     *
     * @return the color of the gem
     */
    public String getGemColor() {
        return gemColor;
    }
    /***
     * Gets the boolean value if the gem is valuable if not
     *
     * @return the boolean value if the gem is valuable if not
     */
    public Boolean isValuable() {
        return valuable;
    }
    /***
     * Sets the color of the gem
     *
     * @param gemColor the gemColor of the gem
     */
    public void setGemColor(String gemColor) {
        this.gemColor = gemColor;
    }
    /***
     * Sets the boolean value if the gem is valuable if not
     *
     * @param valuable the boolean value if the gem is valuable if not
     */
    public void setValuable(boolean valuable) {
        this.valuable = valuable;
    }
    /**
     * The String representation of the gem's itemName, itemLocation, unique, use, hidden, gemColor, valuable
     *
     * @return the gem's itemName, itemLocation, unique, use, hidden, gemColor, valuable
     */
    @Override
    public String toString() {
        String phrase = valuable ? "This item is valuable." : "This item is not valuable.";
        return "Gem - Treasure Item" + '\n' + super.toString() + '\n' +
                "Gem Color: " + gemColor + '\n' + phrase;
    }
    /**
     * The String representation when the gem is activated
     */
    @Override
    public void activate() {
        System.out.println("The Gem, " + super.getItemName() + ", has been activated. Prepare for magical things!" );
    }
    /**
     * The String representation when the gem is used
     */
    @Override
    public void use() {
        System.out.println("The Gem, " + super.getItemName() + ", is in use. This gem will assist you." );
    }
    /**
     * The String representation when the gem is expired
     */
    @Override
    public void expire() {
        System.out.println("The Gem, " + super.getItemName() + ", is now expired. The gem can only be used once." );
    }
    /**
     * The String representation when the gem is used to grant a wish
     */
    @Override
    public void grantWish() {
        System.out.println("The Gem, " + super.getItemName() + ", was used to grant a wish!" );
    }
    /**
     * The String representation when the gem is used to cast a spell
     */
    @Override
    public void castSpell() {
        System.out.println("The Gem, " + super.getItemName() + ", was used to cast a spell!" );
    }
}
