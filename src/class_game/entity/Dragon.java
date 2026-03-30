package class_game.entity;

import class_game.GameConfig;

public class Dragon extends Monster {
    public Dragon(String name, int hp) {
        super(name, hp, GameConfig.BASE_DRAGON_DAMAGE);
    }

    @Override
    protected void performAction(Entity target) {
        System.out.println("Дракон " + getName() + " съел " + target.getName() + ". Урон: " + getBaseDamage());
        target.takeDamage(getBaseDamage(), this);
    }
}