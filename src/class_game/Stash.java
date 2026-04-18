package class_game;

import class_game.exceptions.EmptyStashException;

public class Stash<T> {
    private T item;


    public void put(T item) {
        this.item = item;
    }

public T get() {
        if (item == null) {
            throw new EmptyStashException("Stash пуст");
        }
        return item;
    }
}
