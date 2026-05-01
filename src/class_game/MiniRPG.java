package class_game;

import class_game.entity.*;
import class_game.exceptions.DeadEntityException;
import class_game.exceptions.InsufficientManaException;
import class_game.weapon.*;

import java.io.IOException;
import java.util.Arrays;

public class MiniRPG {
    public static void main(String[] args) throws IOException {
        //try {
        //    Player invalidPlayer = new Player(null, 100);
        //} catch (IllegalArgumentException e) {
        //    System.out.println("Err: " + e.getMessage());
        //    e.printStackTrace();
        //}
//
        //// 1. Инициализация мира
        //World world = new World();
//
        //// 2. Создание игрока и врагов
        //Player player = new Player("Артур", 100);
        //Zombie zombie = new Zombie("Ганс", 75);
        //Dragon dragon = new Dragon("Смауг", 125);
        //AncientDragon ancientDragon = new AncientDragon("Балерион", 250, 40);
//
        //System.out.println("--- Демонстрация Арены ---");
        //// 3. Использование Arena
        //Arena<Entity> arena = new Arena<>();
        //arena.addFighter(player);
        //arena.addFighter(zombie);
        //arena.addFighter(dragon);
        //arena.addFighter(ancientDragon);
        //System.out.println("Бойцов на арене: " + arena.getFighters().size());
//
        //System.out.println("\n--- Демонстрация Info и Stash ---");
        //// 4. Использование Info
        //Info<Player, String> playerInfo = new Info<>(player, "Странствующий рыцарь из северных земель");
        //System.out.println("Описание героя: " + playerInfo.getDescription());
//
        //// 5. Использование Stash
        //Stash<Weapon> hiddenStash = new Stash<>();
        //Weapon secretAk47 = new AK47(45, "Золотой AK-47", 30);
        //hiddenStash.put(secretAk47);
        //System.out.println("В тайнике спрятано оружие: " + hiddenStash.get().getName());
//
        //System.out.println("\n--- Демонстрация работы с оружием ---");
        //// 6. Сравнение оружия
        //Weapon awp = new AWP(100, "Снайперская винтовка AWP", 20);
        //Weapon betterWeapon = Weapon.getStrongerWeapon(hiddenStash.get(), awp);
        //System.out.println("Сильнейшая пушка: " + betterWeapon.getName() + " (Урон: " + betterWeapon.getDamage() + ")");
//
        //// Смена оружия игроком
        //player.setCurrentWeapon(betterWeapon);
//
        //System.out.println("\n--- Демонстрация LootTable ---");
        //// 7. Использование LootTable
        //LootTable<String> loot = new LootTable<>(Arrays.asList("Зелье лечения", "Золотая монета", "Старый башмак"));
        //System.out.print("Возможный лут: ");
        //loot.showLootTable();
//
        //System.out.println("\n--- Боевая система ---");
        //System.out.println("HP бойцов до атаки: ");
        //for (Entity fighter : arena.getFighters()){
        //    System.out.println(fighter.getName() + " : " + fighter.getHp());
        //}
        //try {
        //    // Игрок бьет зомби
        //    player.takeAction(zombie);
//
        //    // Зомби бьет игрока
        //    zombie.takeAction(player);
//
        //    // Драконы бьют игрока
        //    dragon.takeAction(player);
        //    ancientDragon.takeAction(player);
        //} catch (DeadEntityException e) {
        //    System.out.println("ОШИБКА!!!" + e.getMessage());
        //    e.printStackTrace();
        //}
        //System.out.println("HP Игрока после всех атак: " + player.getHp());
        //System.out.println("Убито монстров за сессию: " + GameSession.getMonstersKilled());
        //Spell sharpness = new Spell(120, "Острота");
        Player player1 = new Player("Артур", 100);
        Zombie zombie1 = new Zombie("Ганс", 75);
        AK47 ak = new AK47(44, "AK47", 101111);
        player1.addWeapon(ak);
        try {
            player1.takeAction(zombie1);
        } catch (DeadEntityException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BattleLogger.cfgWriter();
    }
}