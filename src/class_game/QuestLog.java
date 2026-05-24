package class_game;

import java.util.ArrayList;
import java.util.List;

public class QuestLog {
    List<String> quests = new ArrayList<>();
    public void  addQuest(String quest) {
        quests.add(quest);
        System.out.println("Quest added: " + quest);
    }
    public List<String> getQuests() {
        System.out.println("Quests listed: " + quests);
        return quests;
    }
    public void deleteQuest(String quest) {
        quests.remove(quest);
        System.out.println("Quest deleted: " + quest);
    }
}
