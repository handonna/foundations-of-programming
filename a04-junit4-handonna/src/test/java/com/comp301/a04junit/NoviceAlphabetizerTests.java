package com.comp301.a04junit;

import com.comp301.a04junit.alphabetizer.Alphabetizer;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;


/**
 * Write tests for the Alphabetizer class here
 */
public class NoviceAlphabetizerTests {
    @Test
    public void unitTest1() {
        assertTrue(true); // TODO: Write your first unit test!
    }


    @Test
    public void unitTest2() {
        Alphabetizer alphabet = new Alphabetizer(new String[]{"b1", "a1", "c1"});
        assertEquals("a1", alphabet.next());
        assertTrue(alphabet.hasNext());
        assertEquals("b1", alphabet.next());
        assertTrue(alphabet.hasNext());
        assertEquals(alphabet.next(), "c1");
        assertFalse(alphabet.hasNext());
    }

    @Test
    public void unitTest3() {
        try {
            Alphabetizer alphabet = new Alphabetizer(new String[]{"b1", "c1", "a1"});
            assertEquals("a1", alphabet.next());
            assertTrue(alphabet.hasNext());
            assertEquals("b1", alphabet.next());
            assertTrue(alphabet.hasNext());
            assertEquals(alphabet.next(), "c1");
            alphabet.next();
            fail();
        } catch
        (NoSuchElementException e1) {
        }
    }

    @Test
    public void unitTest4() {
        Alphabetizer alphabet = new Alphabetizer(null);
    }

    @Test
    public void unitTest5() {
        try {
            Alphabetizer alphabet = new Alphabetizer(new String[]{"B", "b"});
            assertEquals("B", alphabet.next());
            assertEquals("b", alphabet.next());
        } catch (IllegalArgumentException e2) {
        }
    }

    @Test
    public void unitTest6() {
        // GS Hint: Add a test to make sure that the Alphabetizer constructor makes its own private copy of the String array
        String[] test = new String[] {"c1", "a1", "b1"};
        Alphabetizer alphabet = new Alphabetizer(test);
        test[1] = "g1";
        assertEquals("a1", alphabet.next());
        assertEquals("b1", alphabet.next());
        assertEquals("c1", alphabet.next());
    }
}
