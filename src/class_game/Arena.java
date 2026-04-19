package class_game;

import class_game.entity.Entity;
import class_game.exceptions.ArenaFullException;

import java.util.ArrayList;
import java.util.List;

public class Arena<T extends Entity> {
    public static final int MAX_FIGHTERS = 5;
    private List<T> fighters;

    public Arena() {
        fighters = new ArrayList<>();
    }

    public Arena(List<T> fighters) {
        if (fighters.size() > MAX_FIGHTERS) {
            throw new ArenaFullException("Невозможно создать арену: вас что то много" + MAX_FIGHTERS);
        }
        this.fighters = new ArrayList<>(fighters);
    }

    public List<T> getFighters() {
        return List.copyOf(fighters);
    }

    public void addFighter(T fighter) {
        if (fighters.size() >= MAX_FIGHTERS) {
            throw new ArenaFullException("Арена заполнена");
        }
        fighters.add(fighter);
    }
}



