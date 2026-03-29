package class_game.entity;

public final class AncientDragon extends Entity {

    public AncientDragon(String name, int hp, int damage) {
        super(name, hp, damage);
    }

    @Override
    public void takeAction(Entity target) {
        System.out.println("Дракоша  " + getName() + " ПРОГЛОТИЛ " + target.getName() + " Урон: " + getDamage());
        attack(target);
    }
}
