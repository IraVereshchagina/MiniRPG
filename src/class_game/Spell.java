package class_game;

import class_game.entity.Player;

public class Spell {
    private int manaCost;
    private String name;

    public int getManaCost() {
        return manaCost;
    }

    public Spell(int manaCost, String name) {
        this.manaCost = manaCost;
        this.name = name;
    }
}
