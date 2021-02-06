package de.pinas.wizardonjourney;

import de.pinas.wizardonjourney.character.Weapon;
import de.pinas.wizardonjourney.character.Character;

public class Globals {
    private static final Globals instance = new Globals();

    private int rowCharacter;
    private int columnCharacter;
    private Character character;
    private Field[][] map;

    private Globals() {
        this.rowCharacter = 0;
        this.columnCharacter = 0;
        this.character = new Character(0, 5000, 1, 0);
        this.map = null;

        Weapon sword = new Weapon("Schwertangriff", 50, 20);

    }

    public static Globals getInstance() {
        return instance;
    }

    public int getRowCharacter() {
        return rowCharacter;
    }

    public void setRowCharacter(int rowCharacter) {
        this.rowCharacter = rowCharacter;
    }

    public int getColumnCharacter() {
        return columnCharacter;
    }

    public void setColumnCharacter(int columnCharacter) {
        this.columnCharacter = columnCharacter;
    }

    public Field[][] getMap() {
        return map;
    }

    public void setMap(Field[][] map) {
        this.map = map;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
