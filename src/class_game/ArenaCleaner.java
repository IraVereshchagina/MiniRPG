package class_game;

import class_game.entity.Entity;
import java.util.ArrayList;
import java.util.List;

public class ArenaCleaner {
    static List<Entity> entities = new ArrayList<>();
    public static void addEntity(Entity entity) {
        entities.add(entity);
    }
    public static void removeDeadFighters() {
        entities.removeIf(fighter -> !fighter.isAlive());
        System.out.println("Removed dead fighters");
    }
}