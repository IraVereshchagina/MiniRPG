package class_game;

import class_game.weapon.Weapon;

import java.util.LinkedList;
import java.util.Queue;

public class Blacksmith {
    private Queue<Weapon> orders = new LinkedList<>();

    public void takeOrder(Weapon weapon) {
        orders.offer(weapon);
        System.out.println("Заказ на " + weapon + " принят.");
    }

    public void craftNext() {
        Weapon currentOrder = orders.poll();
        if (currentOrder != null) {
            System.out.println("Улучшен предмет: "  + currentOrder);
        } else {
            System.out.println("Нет заказов");
        }
    }
}
