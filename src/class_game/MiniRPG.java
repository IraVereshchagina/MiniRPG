package class_game;

import class_game.entity.*;
import class_game.weapon.AK47;
import class_game.weapon.AWP;
import class_game.weapon.Weapon;

public class MiniRPG {
    public static void main(String[] args) {
        World world = new World();
        Player player = new Player("имя");
        Entity[] enemies = {
                new Zombie("Вася", 75),
                new Dragon("Любое имя", 125),
                new AncientDragon("Древний дракон", 250, 40)
        };
        System.out.println(player.getHp());
        System.out.println(enemies[0].getHp());
        System.out.println(enemies[1].getHp());
        System.out.println(enemies[2].getHp());
        player.takeAction(enemies[0]);
        player.takeAction(enemies[1]);
        enemies[0].takeAction(player);
        enemies[2].takeAction(player);
        Weapon AWP = new AWP(25, "AWP");
        AWP.setOwner(player);
        player.setCurrentWeapon(AWP);
        player.takeAction(enemies[0]);
        System.out.println(enemies[0].getHp());
    }
}
