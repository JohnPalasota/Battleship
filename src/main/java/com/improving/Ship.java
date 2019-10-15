package com.improving;

import java.util.Random;


public class Ship {
    private int size;
    private int x;
    private int y;
    private boolean direction;
    Random random = new Random();
    static int remainingShips = 14;

    public Ship(int size, int y, int x, boolean direction) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public boolean isValid(int[][] map, Ship ship) {
        try {
            if (direction == true) {
                return x + size <= 7;
            } else {

                return y + size <= 7;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            ship.makeValid(map, ship);
        }
        return false;
    }

    public boolean crosses(int[][] map, Ship ship){
        if (direction == true) {
            if (x + size > 7) return false;
        } else {
            if (y + size > 7) return false;
        }
        if (direction == true){
            for (int i = 0; i < ship.getSize(); i++) {
                if (map[ship.getX() + i][ship.getY()] == 1) return true;
            }
        }
        else{
            for (int j = 0; j < ship.getSize(); j++){
                if (map[ship.getX()][ship.getY() + j] == 1) return true;
            }
        }
        return false;
    }

    public Ship makeValid(int[][] map, Ship ship) {

        while (ship.isValid(map, ship) == false ){
            ship = new Ship(size, random.nextInt(7), random.nextInt(7), random.nextBoolean());
        }
        while (ship.crosses(map, ship) == true){
            ship = new Ship(size, random.nextInt(7), random.nextInt(7), random.nextBoolean());
            ship.isValid(map,ship);
        }
        return ship;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean getDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[][] plot(int[][] map, Ship ship) {
        if (direction == true) {
            if (x + size > 7) ship.makeValid(map, ship);
        } else {
            if (y + size > 7) ship.makeValid(map, ship);
        }
       if (ship.getDirection() == true) {//plot to the right
            for (int i = 0; i < ship.getSize(); i++) {
                map[ship.getX() + i][ship.getY()] = 1;
            }
       }
        else{
            for (int j = 0; j < ship.getSize(); j++){
                map[ship.getX()][ship.getY() + j] = 1;
            }
       }
        return map;
    }
    }

