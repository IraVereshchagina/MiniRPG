package class_game;

import class_game.entity.Player;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;

import static class_game.GameConfig.*;

public class BattleLogger {
    private static final String FILE_NAME = "battle_log.txt";
    
    public static void log(String message) {
        try (BufferedWriter logger = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            logger.write("[" + LocalTime.now() + "] LOG: " + message);
            logger.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка лога: " + e.getMessage());
        }
    }
    
    public static void readLog() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
    public static void cfgWriter() throws IOException {
        StringBuilder configContent = new StringBuilder();
        configContent.append(BASE_DRAGON_DAMAGE).append("\n");
        configContent.append(BASE_DAMAGE).append("\n");
        configContent.append(BASE_ZOMBIE_DAMAGE).append("\n");
        configContent.append(DEFAULT_STAMINA).append("\n");
        configContent.append(PLAYER_MAX_HP);
        
        Files.writeString(Path.of("settings.cfg"), configContent.toString());

    }

    public static int getDamageCounter() throws IOException {
        int counter = 0;
        String current_line;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            int lineCount = (int) Files.lines(Paths.get(FILE_NAME)).count();
            for (int i = 0; i < lineCount - 1; i++) {
                current_line =  reader.readLine();
                if (current_line.charAt(current_line.length() - 2) == 'D') {
                    counter++;
                }
            }
            return counter;
        }
    }
}
