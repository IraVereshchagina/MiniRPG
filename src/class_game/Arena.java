package class_game;

import class_game.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Arena<T extends Entity> {
    private List<T> fighters;

    public Arena() {
        fighters = new ArrayList<>();
    }

    public  Arena(List<T> fighters)
    {
        this.fighters = fighters;
    }

    public List<T> getFighters() {
        return List.copyOf(fighters);
    }

    public void addFighter(T fighter)
    {
        fighters.add(fighter);
    }
}



