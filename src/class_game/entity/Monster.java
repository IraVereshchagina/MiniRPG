package class_game.entity;

import class_game.GameSession;

import java.io.Serializable;

public abstract class Monster extends Entity implements Serializable {
    public Monster(String name, int hp, int baseDamage) {
        super(name, hp, baseDamage);
    }

    @Override
    protected void onDeath(Entity killer) {
        super.onDeath(killer);
        GameSession.setMonstersKilled(GameSession.getMonstersKilled() + 1);
    }
}