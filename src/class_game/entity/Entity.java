package class_game.entity;

import class_game.GameSession;
import class_game.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    private String name;
    private int hp;
    private int damage;
    private List <Weapon> weapons;
    private boolean isAlive;

    public Entity(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.weapons = new ArrayList<>();
        this.isAlive = true;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void putNewWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public List<Weapon> getWeaponList() {return List.copyOf(weapons);}

    public abstract void takeAction(Entity target);

    public void attack(Entity target) {
        if (damage < target.getHp()) {
            target.setHp(target.getHp() - damage);
        } else {
            target.setHp(0);
            System.out.println(target.getName() + " был повержен " + name);
            GameSession.setMonstersKilled(GameSession.getMonstersKilled() + 1);

        }


    }

    public void attackWithWeapon (Entity target, Weapon weapon) {
        if (weapon.getOwner() == this){
            if (damage < target.getHp()) {
                target.setHp(target.getHp() - damage - weapon.getDamage());
            } else {
                target.setHp(0);
                System.out.println(target.getName() + " был повержен " + name);
                GameSession.setMonstersKilled(GameSession.getMonstersKilled() + 1);
                target.setAlive(false);
            }


        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
