package class_game;

import class_game.entity.Entity;
import class_game.entity.Player;
import class_game.weapon.Weapon;

public class Trader {
    public void trade(Weapon weapon) {
        Player.addWeapon(weapon);
    }

}
