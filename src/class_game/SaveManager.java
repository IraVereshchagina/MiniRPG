package class_game;

import class_game.entity.Player;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;

import static class_game.GameConfig.*;
import static class_game.GameConfig.DEFAULT_STAMINA;
import static class_game.GameConfig.PLAYER_MAX_HP;

public class SaveManager {
    public static int getSAVED_hp() {
        return SAVED_hp;
    }

    public static String getSAVED_name() {
        return SAVED_name;
    }

    public static int getSAVED_mana() {
        return SAVED_mana;
    }

    public static String getSAVED_nameOfCurrentWeapon() {
        return SAVED_nameOfCurrentWeapon;
    }

    public static int getSAVED_damageOfCurrentWeapon() {
        return SAVED_damageOfCurrentWeapon;
    }

    private static int SAVED_hp;
    private static String SAVED_name;
    private static int SAVED_mana;
    private static String SAVED_nameOfCurrentWeapon;
    private static int SAVED_damageOfCurrentWeapon;

    private static final String FILE_NAME = "savegame.dat";
    private static final String INV_NAME = "inventory.csv";
    private static final String STATTRACK_NAME = "stats.txt";


    public static void save(Player player) {
        try (PrintWriter saver = new PrintWriter(new FileWriter(FILE_NAME, false))) {
            saver.println(player.getHp());
            saver.println(player.getName());
            saver.println(player.getMana());
            saver.println(player.getNameOfCurrentWeapon());
            saver.println(player.getDamageOfCurrentWeapon());
            //saver.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка лога: " + e.getMessage());
        }
    }
    public static String readConcretLine(int lineNumber, String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            for (int i = 0; i < lineNumber - 1; i++) {
                reader.readLine();
            }
            return reader.readLine();
        }
    }
    public static int takeLinesOfCurrentWeapon() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INV_NAME))) {
            int lineCount = (int) Files.lines(Paths.get(INV_NAME)).count();
            int damageLines = lineCount/2;
            int maxDamage = 0;
            int lineOfMaxDamage = 0;

            for (int i = 1; i < lineCount - 1; i += 2) {
                int a = Integer.parseInt(reader.readLine());
                if (a >= maxDamage) {
                    maxDamage = a;
                    lineOfMaxDamage = i;
                }
            }
            return lineOfMaxDamage;
        }
    }

    private static void readSave() throws IOException {
        SAVED_hp = Integer.parseInt(readConcretLine(1, FILE_NAME));
        SAVED_name = readConcretLine(2,  FILE_NAME);
        SAVED_mana = Integer.parseInt(readConcretLine(3,   FILE_NAME));
        SAVED_damageOfCurrentWeapon = Integer.parseInt(readConcretLine(takeLinesOfCurrentWeapon(), INV_NAME));
        SAVED_nameOfCurrentWeapon = readConcretLine(takeLinesOfCurrentWeapon() - 1,  INV_NAME);
    }

    public void deleteSave() throws IOException {
        Files.deleteIfExists(Paths.get(FILE_NAME));
        Files.deleteIfExists(Paths.get(INV_NAME));
        Files.deleteIfExists(Paths.get(STATTRACK_NAME));
    }

    private static int getStats() throws IOException {
        int lineCount = (int) Files.lines(Paths.get(STATTRACK_NAME)).count();
        return Integer.parseInt(readConcretLine(lineCount, STATTRACK_NAME));
    }
    public static void setStats() {
        try (PrintWriter setNew = new PrintWriter(new FileWriter(STATTRACK_NAME, true))) {
            setNew.println(getStats()  + GameSession.getMonstersKilled());
        } catch (IOException e) {
            System.out.println("Ошибка лога: " + e.getMessage());
        }
    }
}
