package com.comp301.a05driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ExpandingProximityIterator implements Iterator<Driver> {

    private Iterable<Driver> driverpool;
    private Position clientPosition;
    private int expansionStep;
    private int currentCount;
    private ArrayList<Driver> validDrivers;
    private int driverpoolsize;

    public ExpandingProximityIterator(Iterable<Driver> driverpool, Position clientPosition, int expansionStep) {
        if(driverpool == null || clientPosition == null || expansionStep < 0) {
            throw new IllegalArgumentException("bad argument");
        }
        this.driverpool = driverpool;
        this.clientPosition = clientPosition;
        this.expansionStep = expansionStep;
        this.currentCount = 0;
        this.validDrivers = new ArrayList<>();
        driverpoolsize = getDPS();
        populateDriverList();
    }
    private void populateDriverList() {
        int timesExpanded = 0;
        int bound1 = 0;
        int bound2;
        while(validDrivers.size()<driverpoolsize){
            bound2 = 1+expansionStep*timesExpanded;
            int idxToStop = validDrivers.size();
            ProximityIterator pix = new ProximityIterator(driverpool, clientPosition, bound2);
            while(pix.hasNext()){
                Driver driver = pix.next();
                int distance = driver.getVehicle().getPosition().getManhattanDistanceTo(clientPosition);
                if(distance > bound1){
                    validDrivers.add(driver);
                }
            }
            timesExpanded++;
            bound1 = bound2;
        }
    }

    private int getDPS() {
        int count = 0;
        Iterator<Driver> iteratorObj = driverpool.iterator();
        while(iteratorObj.hasNext()){
            iteratorObj.next();
            count++;
        }
        return count;
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
