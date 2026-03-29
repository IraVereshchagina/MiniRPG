package class_game;

public class GameSession {
    private static int monstersKilled = 0;

    public static int getMonstersKilled() {
        return monstersKilled;
    }

    public static void setMonstersKilled(int monstersKilled) {
        GameSession.monstersKilled = monstersKilled;
    }
}
