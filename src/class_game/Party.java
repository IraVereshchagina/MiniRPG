package class_game;

import class_game.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private List<Player> players = new ArrayList<>();
    public void addPlayer(Player player) {
        players.add(player);
        System.out.println("Player " + player.getName() + " has been added to the party");
    }
    public void getNames(){
        System.out.println("Members of the party:");
        for (Player player : players) {
            System.out.println(player.getName());
        }
    }
}
