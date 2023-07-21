public abstract class TreasureItem extends Item {
    private String use;

    private boolean hidden;

    protected TreasureItem() {
    }

    protected TreasureItem(String itemName, String itemLocation, boolean unique, String use, boolean hidden) {
        super(itemName, itemLocation, unique);
        this.use = use;
        this.hidden = hidden;
    }

    public String getUse() {
        return use;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        String phrase = hidden ? "This is a hidden item." : "This is not a hidden item.";
        return super.toString() + '\n' +  "Usage: " + use + '\n' + phrase;
    }

}
