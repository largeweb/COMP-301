package com.comp301.a05driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ProximityIterator implements Iterator<Driver> {

    private Iterable<Driver> driverpool;
    private Position clientPosition;
    private int ProximityRange;
    private int currentCount;
    private ArrayList<Driver> validDrivers;

    public ProximityIterator(Iterable<Driver> driverpool, Position clientPosition, int ProximityRange) {
        if(driverpool == null || clientPosition == null || ProximityRange < 0) {
            throw new IllegalArgumentException("bad argument");
        }
        this.driverpool = driverpool;
        this.clientPosition = clientPosition;
        this.ProximityRange = ProximityRange;
        this.currentCount = 0;
        this.validDrivers = new ArrayList<>();
        populateDriverList();
    }

    private void populateDriverList() {
        Iterator<Driver> iteratorObj = driverpool.iterator();
        while(iteratorObj.hasNext()){
            Driver driver = iteratorObj.next();
            if(driver.getVehicle().getPosition().getManhattanDistanceTo(clientPosition) <= ProximityRange){
                validDrivers.add(driver);
            }
        }
    }

    @Override
    public boolean hasNext() {
        if(currentCount < validDrivers.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Driver next() {
        if(currentCount >= validDrivers.size()) {
            throw new NoSuchElementException();
        }
        Driver nextDriver = validDrivers.get(currentCount);
        currentCount++;
        return nextDriver;
    }
}
