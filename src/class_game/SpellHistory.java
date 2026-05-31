package class_game;

import java.util.ArrayDeque;
import java.util.Deque;

public class SpellHistory {
    private Deque<String> spells = new ArrayDeque<>();

    public void castSpell(String spell) {
        spells.push(spell);
        System.out.println("Added spell: " + spell);
    }
    public void undoLastSpell() {
        if (!spells.isEmpty()) {
            String spell = spells.pop();
            System.out.println("Removed spell: " + spell);
        } else {
            System.out.println("No spells");
        }
    }
}
