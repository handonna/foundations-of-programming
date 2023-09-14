package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ProximityIterator implements Iterator<Driver> {
    private Iterator<Driver> driver_pool;
    private Position client_position;
    private int prox_range;
    private Driver next_driver = null;

    public ProximityIterator(Iterable<Driver> driverPool, Position clientPosition, int proximityRange) {
        if (driverPool == null || clientPosition == null || proximityRange < 0) {
            throw new IllegalArgumentException("no drivers");
        }
        this.client_position = clientPosition;
        this.prox_range = proximityRange;
        this.driver_pool = driverPool.iterator();
        findDriver();
    }

    private void findDriver() {
        while (next_driver == null && driver_pool.hasNext()) {
            Driver new_driver = driver_pool.next();
            if (new_driver.getVehicle().getPosition().getManhattanDistanceTo(client_position) <= prox_range) {
                next_driver = new_driver;
                return;
            }
        }
    }
    @Override
    public boolean hasNext() {
        if (next_driver != null) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public Driver next() {
        if (!(hasNext())) {
            throw new NoSuchElementException("no next");
        }
        else {
            Driver current = next_driver;
            next_driver = null;
            findDriver();
            return current;
        }

    }

}
