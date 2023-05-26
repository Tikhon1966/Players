package org.example;

import java.util.ArrayList;
import java.util.List;

//import static jdk.internal.ref.Cleaner.add;

public class Game {
    private ArrayList<Player> players;

    public Game() {
        players = new ArrayList<>();
    }

    public void register(Player player) {
        players.add(player);
    }


    public Player findPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }


    public int round(String playerName1, String playerName2) {
        Player player1 = findPlayerByName(playerName1); // участники поединка
        Player player2 = findPlayerByName(playerName2);

        if (player1 == null || player2 == null) {
            throw new NotFoundRegisteredException("Один или оба игрока не зарегистрированы");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

}


