package class_game.entity;

import class_game.BattleLogger;
import class_game.GameConfig;
import class_game.Spell;
import class_game.exceptions.InsufficientManaException;
import class_game.exceptions.WeaponBrokenException;
import class_game.weapon.Knife;
import class_game.weapon.Weapon;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalTime;


public class Player extends Entity implements Serializable {

    private int mana;
    private int stamina;

    private Weapon currentWeapon;

    public String getNameOfCurrentWeapon() {
        return currentWeapon.getName();
    }
    public int getDamageOfCurrentWeapon() {
        return currentWeapon.getDamage();
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Player(String name, int mana) throws IOException {
        super(name, GameConfig.PLAYER_MAX_HP, GameConfig.BASE_DAMAGE);
        this.mana = mana;
        this.stamina = GameConfig.DEFAULT_STAMINA;
        this.currentWeapon = new Knife(5, "Кухонный нож", 10);
        addWeapon(this.currentWeapon);
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    @Override
    protected void performAction(Entity target) throws IOException {
        int totalDamage = getBaseDamage();
        if (currentWeapon != null) {
            if (currentWeapon.getDurability() > 0) {
                currentWeapon.setDurability(currentWeapon.getDurability() - 1);
            } else {
                //throw new WeaponBrokenException("Оружие сломалосью");
            }
            totalDamage += currentWeapon.getDamage();
        }

        if (stamina > 0) {
            totalDamage += stamina;
            System.out.println("Использована выносливость! Доп. урон: " + stamina);
            stamina--;
        }

        System.out.println(getName() + " атакует " + target.getName() + " предметом " +
                (currentWeapon != null ? currentWeapon.getName() : "кулаками") + ". Общий урон: " + totalDamage + " [D]");

        target.takeDamage(totalDamage, this);
        BattleLogger.log("Player '" + this.getName() + "' attacked Entity '" + target.getName() + "'. Damage: " + totalDamage);
        if (!target.isAlive()) {
            stamina = GameConfig.DEFAULT_STAMINA;
        }
    }
    public void castSpell(Spell spell, Entity target) {
        if (spell.getManaCost() >= this.getMana()) {
            //назначение эффекта
        } else  {
            throw new InsufficientManaException("Маны меньше");
        }
    }
}