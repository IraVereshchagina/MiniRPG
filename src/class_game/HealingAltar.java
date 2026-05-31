package class_game;

import class_game.entity.Entity;

import java.util.PriorityQueue;
import java.util.Queue;

public class HealingAltar {
    private Queue<Entity> patients = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getHp(), e2.getHp()));
    public void addPatient(Entity entity) {
        patients.offer(entity);
        System.out.println("Пациент " + entity + " в очереди.");
    }
    public void healNext() {
        Entity current = patients.poll();
        if (current != null) {
            current.takeDamage(-50, null);
        }
    }
}
