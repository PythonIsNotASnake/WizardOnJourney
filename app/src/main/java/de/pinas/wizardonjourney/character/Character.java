package de.pinas.wizardonjourney.character;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private int gold;
    private int health;
    private int level;
    private int experience;
    private List<Potion> potions;
    private Weapon weapon;
    private Spell spellOne;
    private Spell spellTwo;

    public Character(int gold, int health, int level, int experience) {
        this.gold = gold;
        this.health = health;
        this.level = level;
        this.experience = experience;
        this.potions = new ArrayList<>();
        this.weapon = new Weapon("Schwertangriff", 0, 100);
        this.spellOne = null;
        this.spellTwo = null;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
