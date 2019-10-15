package com.improving;

import com.improving.commands.GuessCommand;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;
@Component
public class Game {
    private Scanner scanner = new Scanner(System.in);
    private boolean loop = true;
    Grid grid = new Grid();
    int[][] map = new int[8][8];
    Random random = new Random();
    GuessCommand guessCommand = new GuessCommand();
    private boolean direction = random.nextBoolean(); //If true, the ship will be built to the right. If false, will be built downward.




    public void run(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 0;
            }
        }
        int xCord;
        int yCord;
        Ship ship5;
        ship5 = new Ship(5, random.nextInt(7), random.nextInt(7), random.nextBoolean());
        ship5 = ship5.makeValid(map, ship5);
        map = ship5.plot(map, ship5);

        Ship ship4 = new Ship(4, random.nextInt(7), random.nextInt(7), random.nextBoolean());
        ship4 = ship4.makeValid(map, ship4);
        map = ship4.plot(map, ship4);

        Ship ship3 = new Ship(3, random.nextInt(7), random.nextInt(7), random.nextBoolean());
        ship3 = ship3.makeValid(map, ship3);
        map = ship3.plot(map, ship3);

        Ship ship2 = new Ship(2, random.nextInt(7), random.nextInt(7), random.nextBoolean());
        ship2 = ship2.makeValid(map, ship2);
        map = ship2.plot(map, ship2);


        System.out.println("Symbol guide:\nx = unchecked\nH = hit\n(blank) = miss");
        while (loop) {

            System.out.println();
            grid.displayGrid(map);
            System.out.println("\nRemaining: "+ guessCommand.remaining());
            System.out.println("Enter your x coordinate");
            System.out.print("> ");
            yCord = scanner.nextInt();
            System.out.println("Enter your y coordinate");
            System.out.print("> ");
            xCord = scanner.nextInt();
            map[xCord][yCord] = guessCommand.shoot(map, xCord, yCord);

            if (guessCommand.remaining() == 0) {
                System.out.print("\nYou win!");
                break;
            }


        }
    }
}
