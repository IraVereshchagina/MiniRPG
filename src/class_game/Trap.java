package class_game;

import class_game.entity.Entity;
import class_game.exceptions.DeadEntityException;

import java.util.Random;

public class Trap {

    private final Random random = new Random();

    public void trigger(Entity target) {
        try {
            if (!target.isAlive()) {
                throw new DeadEntityException(target.getName() + " уже мертв, ловушка не сработала");
            }

      
            int trapType = random.nextInt(3);

            switch (trapType) {
                case 0:
                    int damage = 10 + random.nextInt(20);
                    target.takeDamage(damage, null);
                    System.out.println("Ловушка сработала! " + target.getName() + " получил " + damage + " урона");
                    break;

                case 1:
                 
                    int poisonDamage = 5 + random.nextInt(10);
                    target.takeDamage(poisonDamage, null);
                    System.out.println("Ловушка отравила " + target.getName() + "Нанесено " + poisonDamage + " урона ядом");
                    break;

                case 2:
   

                    System.out.println("Ловушка сломала оружие у " + target.getName() + "!");
                    break;
            }

        } catch (DeadEntityException e) {
            System.out.println("Ошибка сработки: " + e.getMessage());
        } catch (Exception e) {

            System.err.println("Ошибка сработки: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}