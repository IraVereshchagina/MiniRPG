package class_game.traps;

import class_game.entity.Entity;
import class_game.exceptions.DeadEntityException;

import java.util.Random;

public abstract class Trap {
    public static Random random = new Random();

    public abstract void trigger(Entity target);

    public boolean isAbleToApply(Entity target) {
        double chance = Math.random();
        return chance < 0.3;
    }

    public void validateTarget(Entity target) throws DeadEntityException {
        if (!target.isAlive()) {
            throw new DeadEntityException(target.getName() + " уже мертв, ловушка не сработала");
        }
    }
}