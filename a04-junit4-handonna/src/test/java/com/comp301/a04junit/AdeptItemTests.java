package com.comp301.a04junit;

import org.junit.Test;
import com.comp301.a04junit.adventure.Item;
import com.comp301.a04junit.adventure.ItemImpl;

import static org.junit.Assert.*;

/**
 * Write unit tests for the ItemImpl class here
 */
public class AdeptItemTests {
    @Test
    public void unitTest1() {
        assertTrue(true); // TODO: Write your first unit test!
    }

    @Test
    public void unitTest2() { //test getName
        Item item = new ItemImpl("test");
        assertEquals(item.getName(), "test");
    }

    @Test
    public void unitTest3() { //test null name
        try {
            new ItemImpl(null);
            fail();
        } catch (IllegalArgumentException e1) {
        }
    }

    @Test
    public void unitTest4() { //test toString
        Item item = new ItemImpl ("string_test");
        assertEquals(item.toString(), "string_test");
    }
    @Test
    public void unitTest5 () { //test equals
        Item one = new ItemImpl ("equals");
        Item two = new ItemImpl ("equals");
        assertEquals(one, two);
    }
}
