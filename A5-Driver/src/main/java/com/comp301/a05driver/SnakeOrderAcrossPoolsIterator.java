package com.comp301.a05driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SnakeOrderAcrossPoolsIterator implements Iterator<Driver> {

    private List<Iterable<Driver>> driverpools;
    private ArrayList<Iterator<Driver>> driverIterators;
    private int currentCount;
    private ArrayList<Driver> validDrivers;
    private int snakeCurrent;
    private int snakeLast;
    private boolean snakeRepeat;
    private boolean snakeGoUp;

    public SnakeOrderAcrossPoolsIterator(List<Iterable<Driver>> driverpools) {
        if(driverpools == null) {
            throw new IllegalArgumentException("bad argument");
        }
        this.driverpools = driverpools;
        this.currentCount = 0;
        this.validDrivers = new ArrayList<>();
        this.snakeCurrent = 0;
        this.driverIterators = new ArrayList<>();
        this.snakeLast = driverpools.size()-1;
        this.snakeRepeat = false;
        this.snakeGoUp = true;
        if(driverpools.size() > 1) {
            for(int i=0; i<driverpools.size(); i++) {
                Iterator<Driver> dIt = driverpools.get(i).iterator();
                driverIterators.add(dIt);
            }
            populateDrivers();
        } else if(driverpools.size() == 1) {
            Iterator<Driver> dIt = driverpools.get(0).iterator();
            driverIterators.add(dIt);
            while(thereIsNextAmongstPools()){
                try {
                    Driver driver = driverIterators.get(0).next();
                    validDrivers.add(driver);
                } catch (Exception e) {}
            }
        }
    }

    private void populateDrivers() {
        while(thereIsNextAmongstPools()){
            try {
                Driver driver = driverIterators.get(snakeCurrent).next();
                validDrivers.add(driver);
            } catch (Exception e) {}
            changeSnakeCurrent();
        }
    }

    private void changeSnakeCurrent() {
        if(!snakeRepeat) {
            if (snakeGoUp) {
                snakeCurrent++;
                if (snakeCurrent == snakeLast) {
                    snakeRepeat = true;
                    snakeGoUp = false;
                }
            } else {
                snakeCurrent--;
                if (snakeCurrent == 0) {
                    snakeRepeat = true;
                    snakeGoUp = true;
                }
            }
        } else {
            snakeRepeat = false;
        }
    }
    private boolean thereIsNextAmongstPools() {
        boolean thereIsNext = false;
        for(int i=0; i< driverIterators.size(); i++){
            if(driverIterators.get(i).hasNext()) {
                thereIsNext = true;
            }
        }
        return thereIsNext;
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
