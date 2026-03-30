package class_game.entity;

public final class AncientDragon extends Monster {
    public AncientDragon(String name, int hp, int damage) {
        super(name, hp, damage);
    }

    @Override
    protected void performAction(Entity target) {
        System.out.println("Древний дракон " + getName() + " ПРОГЛОТИЛ " + target.getName() + ". Урон: " + getBaseDamage());
        target.takeDamage(getBaseDamage(), this);
    }
}