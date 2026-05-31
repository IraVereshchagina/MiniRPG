package class_game;

import java.util.LinkedList;

public class PatrolRoute {
    LinkedList<String> points = new LinkedList<>();

    public void addPoint(String point) {
        points.add(point);
    }

    public void toNext() {
        if (points.isEmpty()) {
            return;
        }
        String currentPoint = points.pollFirst();
        System.out.println("Current point: " + currentPoint);
        points.add(currentPoint);
    }
}
