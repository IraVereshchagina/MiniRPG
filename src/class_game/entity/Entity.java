package class_game.entity;
import class_game.ArenaCleaner;
import class_game.exceptions.DeadEntityException;
import class_game.exceptions.InventoryFullException;
import class_game.weapon.Weapon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static class_game.GameConfig.BASE_DRAGON_DAMAGE;

public abstract class Entity implements Serializable {
    private String name;
    private int hp;
    private int baseDamage;
    private int maxHp;
    private List<Weapon> inventory;
    private boolean isAlive;

    public Entity(String name, int hp, int baseDamage) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name of entity must not be empty");
        }

        this.name = name;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.maxHp = hp;
        this.inventory = new ArrayList<>();
        this.isAlive = true;
        ArenaCleaner.addEntity(this);
    }

    public void takeAction(Entity target) throws DeadEntityException, IOException {
        if (!this.isAlive()) {
            throw new DeadEntityException(this.getName() + " мертв и не может атаковать!");
        }
        if (!target.isAlive()) {
            throw new DeadEntityException(target.getName() + " уже мертв, " + this.getName() + " бьет воздух.");
        }

        performAction(target);
    }

    protected abstract void performAction(Entity target) throws IOException;

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

    public void addWeapon(Weapon weapon) throws IOException {
        if (inventory.size() >= 3) {
            throw new InventoryFullException("Инвентарь полон, нельзя добавить больше 3 оружий");
        }
        StringBuilder configContent = new StringBuilder();
        configContent.append(weapon.getName()).append("\n");
        configContent.append(weapon.getDamage());
        Files.writeString(Path.of("inventory.csv"), configContent.toString());
        inventory.add(weapon);
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getBaseDamage() { return baseDamage; }
    public int getMaxHp() { return maxHp; }
    public boolean isAlive() { return isAlive; }
    public List<Weapon> getInventory() { return List.copyOf(inventory); }

    public void heal(int amount) {
        if (!isAlive) {
            throw new IllegalStateException(this.getName() + " мертв");
        }
        hp += amount;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }
}
