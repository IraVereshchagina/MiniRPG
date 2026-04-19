package class_game.traps;

import class_game.entity.Entity;
import class_game.exceptions.DeadEntityException;

import java.util.Random;

public class DamageTrap extends Trap {
    private static final Random random = new Random();

    @Override
    public void trigger(Entity target) {
        try {
            validateTarget(target);
        } catch (DeadEntityException e) {
            System.out.println(target.getName() + " уже мертв, ловушка не сработала");
            return;
        }
        if (isAbleToApply(target)) {
            int damage = 10 + random.nextInt(20);
            target.takeDamage(damage, null);
            System.out.println("Ловушка сработала! " + target.getName() + " получил " + damage + " урона");
        } else {
            System.out.println("Ловушка не сработала на " + target.getName());
        }
    }
}
