public abstract class HealthItem extends Item {

    private String description;

    private int healthValue;

    protected HealthItem() {
    }

    public HealthItem(String itemName, String itemLocation, Boolean unique, String description, int healthValue) {
        super(itemName, itemLocation, unique);
        this.description = description;
        this.healthValue = healthValue;
    }

    public String getDescription() {
        return description;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

    @Override
    public String toString() {
        return super.toString() + '\n' + "Description: " + description + '\n' + "Health Value: " + healthValue;
    }
}
