package class_game.entity;

import class_game.GameConfig;

public class Dragon extends Entity {
    public Dragon(String name, int hp) {
        super(name, hp, GameConfig.BASE_DRAGON_DAMAGE);
    }
    @Override
    public void takeAction(Entity target) {
        System.out.println("Дракон  " + getName() + " сЪел " + target.getName() + " Урон: " + getDamage());
        attack(target);
    }
}

