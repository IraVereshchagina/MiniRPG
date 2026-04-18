package class_game.entity;
import class_game.exceptions.DeadEntityException;
import class_game.exceptions.InventoryFullException;
import class_game.weapon.Weapon;
import java.util.ArrayList;
import java.util.List;
public abstract class Entity {
private String name;
    private int hp;
    private int baseDamage;
    private int maxHp;
    private List<Weapon> inventory;
    private boolean isAlive;
public Entity(String name, int hp, int baseDamage) {
        this.name = name;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.maxHp = hp;
        this.inventory = new ArrayList<>();
        this.isAlive = true;
    }

    public void takeAction(Entity target) throws  DeadEntityException {
        if (!this.isAlive()) {
            throw new DeadEntityException(this.getName() + " мертв и не может атаковать!");
        }
        if (!target.isAlive()) {
            throw new DeadEntityException(target.getName() + " уже мертв, " + this.getName() + " бьет воздух.");
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

public void addWeapon(Weapon weapon) {
        if (inventory.size() >= 3) {
            throw new InventoryFullException("Инвентарь полон, нельзя добавить больше 3 оружий");
        }
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
