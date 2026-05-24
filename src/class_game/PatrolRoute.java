package class_game;

import java.util.LinkedList;
import java.util.List;

public class PatrolRoute {
    List<String> points = new LinkedList<>();
    List<String> tempPoints = new LinkedList<>();
    public void addPoint(String point) {
        points.add(point);
    }
    public void toNext() {
        String a = points.get(0);
        String b = points.get(1);
        String c = points.get(2);
        tempPoints.add(b);
        tempPoints.add(c);
        tempPoints.add(a);
        points = tempPoints;
        System.out.println(tempPoints.get(2) + ". Следующая остановка: " + tempPoints.get(0) + ".");
    }
}
