package class_game.weapon;

import java.util.ArrayDeque;
import java.util.Deque;

public class Quiver {
    private Deque<String> arrows = new ArrayDeque<>();

    public void addArrow(String arrow) {
        arrows.push(arrow);
        System.out.println("Added arrow: " + arrow);
    }
    public void shoot() {
        if (!arrows.isEmpty()) {
            String arrow = arrows.pop();
            System.out.println("Shooted with " + arrow);
        } else {
            System.out.println("Quiver is empty");
        }
    }
}
