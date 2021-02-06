package de.pinas.wizardonjourney.character;

public abstract class Item {
    private int strength;
    private int price;
    private String description;

    Item(String description, int price, int strength) {
        this.description = description;
        this.price = price;
        this.strength = strength;
    }

    protected int getStrength() {
        return strength;
    }

    protected void setStrength(int strength) {
        this.strength = strength;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
