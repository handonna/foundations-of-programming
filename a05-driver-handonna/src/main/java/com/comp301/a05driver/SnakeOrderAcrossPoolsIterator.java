package com.comp301.a05driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SnakeOrderAcrossPoolsIterator implements Iterator<Driver> {
    private List<Iterator<Driver>> driver_pool = new ArrayList<>();
    private Driver next_driver = null;
    private int drivers_left = 0;
    private int index = 0;
    private int amount;
    private boolean next_avail = true;
    private boolean no_next = false;
    private int one = 1;



    public SnakeOrderAcrossPoolsIterator(List<Iterable<Driver>> driverPools) {
        if (driverPools == null) {
            throw new IllegalArgumentException("empty pool");
        }
        int[] driver;
        driver = new int[driverPools.size()];
        amount = driverPools.size();
            for (int i = 0; i < amount; i++) {
                int counter = 0;
                for (Driver drivers : driverPools.get(i)) {
                    counter = counter + 1 * one;
                }
                drivers_left = drivers_left + counter * one;
                driver[i] = counter;
                driver_pool.add(driverPools.get(i).iterator());
            }
            findDriver();
        }
    private void findDriver() {
        if (hasNext() == no_next) {
            return;
        }
        while (hasNext() == true) {
            if (next_avail) {
                while (index < amount) {
                    if (driver_pool.get(index).hasNext()) {
                        next_driver = driver_pool.get(index).next();
                        index = index + 1 * one;
                        return;
                    }
                    index = index + 1 * one;
                }
                next_avail = false;
                index = index - 1;
            }
            while (index >= 0) {
                if (driver_pool.get(index).hasNext()) {
                    next_driver = driver_pool.get(index).next();
                    index = index - 1 * one;
                    return;
                }
                index = index - 1 * one;
            }
            next_avail = true;
            index = index + 1 * one;
        }
    }


    @Override
    public boolean hasNext() {
        if (drivers_left == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Driver next() {
        if (hasNext() == true) {
            Driver current = next_driver;
            next_driver = null;
            drivers_left = drivers_left - 1 * one;
            findDriver();
            return current;
        }
        else {
            throw new NoSuchElementException();

        }
    }
}









