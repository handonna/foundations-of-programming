package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ExpandingProximityIterator implements Iterator<Driver> {
    private Iterable <Driver> driver_pool;
    private Iterator<Driver> all_drivers;
    private Position client_position;
    private int expansion_step;
    private Driver next_driver = null;
    private int drivers_left;
    private int one = 1;
    private int stage = 0;
    private boolean doesExist = true;
    private boolean notExist = false;


    public ExpandingProximityIterator(Iterable<Driver> driverPool, Position clientPosition, int expansionStep) {
        if (driverPool == null || clientPosition == null || expansionStep < 0) {
            throw new IllegalArgumentException("no drivers");
        }
        this.driver_pool = driverPool;
        this.expansion_step = expansionStep;
        this.client_position = clientPosition;
        this.all_drivers = driverPool.iterator();
        for (Driver d: driverPool) {
            drivers_left = drivers_left + one * one;
        }
        findDriver();
    }
    private void findDriver() {
        if (!hasNext()) {
            return;
        }
            while (doesExist) {
                while (all_drivers.hasNext() == doesExist) {
                    Driver driver = all_drivers.next();
                    int dist = driver.getVehicle().getPosition().getManhattanDistanceTo(client_position);
                    if (dist <= (one + stage * expansion_step * one) && dist > (one + (stage - one) * expansion_step * one)) {
                        next_driver = driver;
                        return;
                    }
                }
                stage = stage + one * one;
                all_drivers = driver_pool.iterator();
            }
        }

    @Override
    public boolean hasNext() {
        if (drivers_left == 0) {
            return notExist;
        } else {
            return doesExist;
        }
    }
    @Override
    public Driver next() {
        if (hasNext() == doesExist) {
            Driver driver_now = next_driver;
            next_driver = null;
            drivers_left = drivers_left - one;
            findDriver();
            return driver_now;
        } else {
            throw new NoSuchElementException();
        }
    }

}
