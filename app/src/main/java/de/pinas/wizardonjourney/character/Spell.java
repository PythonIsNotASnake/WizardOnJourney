package de.pinas.wizardonjourney.character;

public class Spell extends Item {

    public Spell(String description, int price, int hitPoints) {
        super(description, price, hitPoints);
    }

    public int getHitPoints() {
        return this.getStrength();
    }

    public void setHitPoints(int hitPoints) {
        this.setStrength(hitPoints);
    }
}
