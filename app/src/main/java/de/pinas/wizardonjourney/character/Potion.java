package de.pinas.wizardonjourney.character;

public class Potion extends Item {

    public Potion(String description, int price, int healPoints) {
        super(description, price, healPoints);
    }

    public int getHealPoints() {
        return this.getStrength();
    }

    public void setHealPoints(int healPoints) {
        this.setStrength(healPoints);
    }
}
