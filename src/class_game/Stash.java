package class_game;

import class_game.exceptions.EmptyStashException;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stash<T> {
    private Deque<T> items = new ArrayDeque<>();

    public void put(T item) {
        items.push(item);
        System.out.println("Putted: " + item);
    }

    public T get() {
        if (!items.isEmpty()) {
            T item = items.pop();
            System.out.println("You have " + item);
            return item;
        } else {
            throw new EmptyStashException("Stash is empty");
        }
    }
}


