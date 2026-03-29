package class_game.entity;

import class_game.GameConfig;

public class Zombie extends Entity {
    public Zombie(String name, int hp) {
        super(name, hp, GameConfig.BASE_ZOMBIE_DAMAGE);
    }
    @Override
    public void takeAction(Entity target) {
        System.out.println("Зомби " + getName() + " укусил " + target.getName() + " Урон: " + getDamage());
        attack(target);
    }
}
