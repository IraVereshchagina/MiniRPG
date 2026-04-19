package class_game.traps;

import class_game.entity.Entity;
import class_game.exceptions.DeadEntityException;

import java.util.Random;

public class PoisonTrap extends Trap {
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
            int poisonDamage = 5 + random.nextInt(10);
            target.takeDamage(poisonDamage, null);
            System.out.println("Ловушка отравила " + target.getName() + "Нанесено " + poisonDamage + " урона ядом");
        } else {
            System.out.println("Ловушка не сработала на " + target.getName());
        }
    }
}
