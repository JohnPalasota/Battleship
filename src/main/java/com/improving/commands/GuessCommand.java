package com.improving.commands;

import java.util.Map;
import java.util.Scanner;

public class GuessCommand {
    private int x;
    private int y;
    private Map map;
    private int size = 14;

    public int shoot(int[][] map, int y, int x){
        if (map[y][x] == 1){
            size--;
            return 2;
        }
        else if(map[y][x] == 2) {
            System.out.println("You have already guessed this set of coordinates.");
            return 2;
        }
        else
            {
                return -1;
            }
        }


    public int remaining() {
        return size;
    }
}
