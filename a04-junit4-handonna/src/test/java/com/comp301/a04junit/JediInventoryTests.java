package com.comp301.a04junit;

import com.comp301.a04junit.adventure.Inventory;
import com.comp301.a04junit.adventure.InventoryImpl;
import com.comp301.a04junit.adventure.ItemImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Write unit tests for the InventoryImpl class here
 */
public class JediInventoryTests {
    @Test
    public void unitTest1() {
        assertTrue(true); // TODO: Write your first unit test!
    }

    @Test
    public void unitTest2() { //testing empty
        Inventory inventory = new InventoryImpl();
        assertTrue(inventory.isEmpty());
    }

    @Test
    public void unitTest3() { //test add / remove item, clear
        Inventory inventory = new InventoryImpl();
        inventory.addItem(new ItemImpl("test1"));
        inventory.addItem(new ItemImpl("test2"));
        assertEquals(2, inventory.getNumItems());
        inventory.removeItem(inventory.getItems().get(1));
        assertEquals (1, inventory.getNumItems());
        inventory.clear();
        assertEquals (0, inventory.getNumItems());
    }

    @Test
    public void unitTest4() { // test transfer
        InventoryImpl inventory1 = new InventoryImpl();
        InventoryImpl inventory2 = new InventoryImpl();
        inventory1.addItem(new ItemImpl("test1"));
        inventory1.addItem(new ItemImpl("test2"));
        inventory2.addItem(new ItemImpl("test1"));
        inventory2.addItem(new ItemImpl("test2"));
        assertTrue(inventory1.getNumItems() == 2);
        assertTrue(inventory2.getNumItems() == 2);
        inventory1.transferFrom(inventory2);
        assertTrue(inventory2.isEmpty());
        assertTrue(inventory1.getNumItems() == 4);
        inventory1.transferFrom(null);
        assertTrue(inventory1.getNumItems() == 4);






    }
}
