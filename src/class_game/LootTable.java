package class_game;

import java.util.List;

public class LootTable<T> {
    private List<T> items;

    public LootTable(List<T> items) {
        this.items = items;
    }

    public void showLootTable()
    {
        for (T item : items) {
            System.out.println(item.toString());
        }
    }
}
