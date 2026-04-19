package class_game;

public class LootBox {
    private boolean isLocked = true;

    public void open() {
        try {
            isLocked = false;
            // тут будет попытка выдать
        } finally {
            isLocked = true;
        }
    }

    public boolean isLocked() {
        return isLocked;
    }
}