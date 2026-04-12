package class_game.entity;

import class_game.weapon.Weapon;
import java.util.ArrayList;
import java.util.List;
public abstract class Entity {
    private String name;
    private int hp;
    private int baseDamage;
    private List<Weapon> inventory;
    private boolean isAlive;
    public Entity(String name, int hp, int baseDamage) {
        this.name = name;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.inventory = new ArrayList<>();
        this.isAlive = true;
    }

    public void takeAction(Entity target) {
        if (!this.isAlive()) {
            System.out.println(this.getName() + " мертв и не может атаковать!");
            return;
        }
        if (!target.isAlive()) {
            System.out.println(target.getName() + " уже мертв, " + this.getName() + " бьет воздух.");
            return;
        }

        performAction(target);
    }

    protected abstract void performAction(Entity target);

    public void takeDamage(int amount, Entity attacker) {
        if (!isAlive) return;

        hp -= amount;
        if (hp <= 0) {
            hp = 0;
            isAlive = false;
            onDeath(attacker);
        }
    }

    protected void onDeath(Entity killer) {
        System.out.println(name + " был повержен сущностью " + killer.getName());
    }

    public static void addWeapon(Weapon weapon) {
        inventory.add(weapon);
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getBaseDamage() { return baseDamage; }
    public boolean isAlive() { return isAlive; }
    public List<Weapon> getInventory() { return List.copyOf(inventory); }
}