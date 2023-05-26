package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    Player playerName1 = new Player(1, "Name1", 100);
    Player playerName2 = new Player(2, "Name2", 200);
    Player playerName3 = new Player(3, "Name3", 200);
    Player playerName4 = new Player(4, "Name4", 300);
    Player playerName5 = new Player(5, "Name5", 400);


    Game players = new Game();

    @BeforeEach
    public void setup() {
        players.register(playerName1);
        players.register(playerName2);
        players.register(playerName3);
    }

    @Test
    public void shouldIfName2StrongerName1() {
        int expection = 2;
        int actual = players.round("Name1", "Name2");
        assertEquals(expection, actual);
    }

    @Test
    public void shouldIfName2EqualsName3() {
        int expection = 0;
        int actual = players.round("Name2", "Name3");
        assertEquals(expection, actual);
    }

    @Test
    public void shouldIfName3StrongerNam1() {
        int expection = 1;
        int actual = players.round("Name3", "Name1");
        assertEquals(expection, actual);
    }

    @Test
    public void shouldIfName4NoRegistration() {
        Assertions.assertThrows(NotFoundRegisteredException.class, () -> {
            players.round("Name1", "Name4");
        });

    }

    @Test
    public void shouldIfName4AndName5NoRegistration() {
        Assertions.assertThrows(NotFoundRegisteredException.class, () -> {
            players.round("Name4", "Name5");
        });

    }


}

