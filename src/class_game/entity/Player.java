package class_game.entity;

import class_game.GameConfig;
import class_game.weapon.Knife;
import class_game.weapon.Weapon;

public class Player extends Entity{
    private  int stamina;

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    private Weapon currentWeapon = new Knife(5, "Кухонный нож");

    public Player(String name) {
        super(name, GameConfig.PLAYER_MAX_HP, GameConfig.BASE_DAMAGE);
        this.stamina = GameConfig.DEFAULT_STAMINA;
        currentWeapon.setOwner(this);
    }

    @Override
    public void takeAction(Entity target) {
        System.out.println(getName() + " атакует " + target.getName() +  ". Урон: " + getDamage());
        attackWithWeapon(target, currentWeapon);
        if (stamina > 0) {
            target.setHp(getHp() - stamina);
            System.out.println("Доп. урон по " + target.getName() + " : " + stamina);
            stamina--;
        }
        if (!target.isAlive()) {
            stamina = GameConfig.DEFAULT_STAMINA;
        }
    }
}
