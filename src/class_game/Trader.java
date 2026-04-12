package class_game;
import class_game.entity.Entity;
import class_game.entity.Player;
import class_game.weapon.Weapon;
public interface Trader<T> {
    void trade(T item);
}
