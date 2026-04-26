package class_game.weapon;

public abstract class Weapon {
    private int damage;
    private String name;

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    private int durability;

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