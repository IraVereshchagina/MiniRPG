package class_game.entity;

import class_game.GameConfig;

public class Zombie extends Monster {
    public Zombie(String name, int hp) {
        super(name, hp, GameConfig.BASE_ZOMBIE_DAMAGE);
    }

    @Override
    protected void performAction(Entity target) {
        System.out.println("Зомби " + getName() + " кусает " + target.getName() + ". Урон: " + getBaseDamage());
        target.takeDamage(getBaseDamage(), this);
    }
}