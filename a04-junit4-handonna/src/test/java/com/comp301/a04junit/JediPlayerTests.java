package com.comp301.a04junit;

import com.comp301.a04junit.adventure.Direction;
import com.comp301.a04junit.adventure.ItemImpl;
import com.comp301.a04junit.adventure.Player;
import com.comp301.a04junit.adventure.PlayerImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Write unit tests for the PlayerImpl class here
 */
public class JediPlayerTests {
    @Test
    public void unitTest1() {
        assertTrue(true); // TODO: Write your first unit test!
    }

    @Test
    public void unitTest2() { //test name and position
        Player player = new PlayerImpl("test", 2, 3);
        assertEquals(2, player.getPosition().getX());
        assertEquals(3, player.getPosition().getY());
        assertEquals("test", player.getName());
    }

    @Test
    public void unitTest3() { //test move
        Player player = new PlayerImpl("test", 2, 3);
        player.move(Direction.EAST);
        assertEquals(3, player.getPosition().getX());
        assertEquals(3, player.getPosition().getY());
        player.move(Direction.NORTH);
        player.move(Direction.WEST);
        assertEquals(2, player.getPosition().getX());
        assertEquals(4, player.getPosition().getY());
        player.move(Direction.SOUTH);
        player.move(Direction.WEST);
        assertEquals(1, player.getPosition().getX());
        assertEquals(3, player.getPosition().getY());
    }

    @Test
    public void unitTest4() { //test inv
        PlayerImpl player = new PlayerImpl("test", 1, 2);
        assertEquals(0, player.getInventory().getNumItems());
        player.getInventory().addItem(new ItemImpl("item"));
        assertEquals(1, player.getInventory().getNumItems());
    }

    @Test
    public void unitTest5() { //parameter?
        try {
            Player player = new PlayerImpl(null, 1, 1);
            fail();
        } catch (IllegalArgumentException ie) {
        }
    }
}
