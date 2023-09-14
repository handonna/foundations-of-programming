package com.comp301.a04junit;

import com.comp301.a04junit.adventure.Direction;
import com.comp301.a04junit.adventure.Position;
import com.comp301.a04junit.adventure.PositionImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Write unit tests for the PositionImpl class here
 */
public class AdeptPositionTests {
    @Test
    public void unitTest1() {
        assertTrue(true); // TODO: Write your first unit test!
    }

    @Test
    public void unitTest2() { //testing getX and getY
        Position position = new PositionImpl(2, -5);
        assertEquals(2, position.getX());
        assertEquals(-5, position.getY());
        assertEquals(2, position.getX());
        assertEquals(-5, position.getY());
    }

    @Test
    public void unitTest3() {
        try {
            assertEquals(new PositionImpl(4, 3), new PositionImpl(3, 3).getNeighbor(null));
            fail();
        } catch (IllegalArgumentException ie) {

        }
    }

    @Test
    public void unitTest4() {//testing getNeighbor
        Position position = new PositionImpl(2, -5);
        assertEquals(2, position.getNeighbor(Direction.NORTH).getX());
        assertEquals(-4, position.getNeighbor(Direction.NORTH).getY());
        assertEquals(3, position.getNeighbor(Direction.EAST).getX());
        assertEquals(-5, position.getNeighbor(Direction.EAST).getY());
        assertEquals(2, position.getNeighbor(Direction.SOUTH).getX());
        assertEquals(-6, position.getNeighbor(Direction.SOUTH).getY());
        assertEquals(1, position.getNeighbor(Direction.WEST).getX());
        assertEquals(-5, position.getNeighbor(Direction.WEST).getY());
    }
}
