package class_game.weapon;

import class_game.entity.Entity;

public abstract class Weapon {
    private int damage;
    private String name;
    private Entity owner;

    public  Weapon (int damage, String name) {
        this.name = name;
        this.damage = damage;
    }

    public static Weapon compare(Weapon w1, Weapon w2){
        if (w1.getDamage() > w2.getDamage()) {
            return w1;
        } else {
            return w2;
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Entity getOwner() {
        return owner;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }
}
