package class_game.weapon;

import java.io.Serializable;

public abstract class Weapon implements Serializable {
    private int damage;
    private String name;
    private int durability;

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public Weapon(int damage, String name, int durability) {
        if (damage < 0) {
            throw new IllegalArgumentException("DAMAGE < 0 ");
        }
        this.name = name;
        this.damage = damage;
    }

    public static Weapon getStrongerWeapon(Weapon w1, Weapon w2) {
        return w1.getDamage() > w2.getDamage() ? w1 : w2;
    }

    public int getDamage() { return damage; }
    public String getName() { return name; }
}