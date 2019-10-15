package com.improving;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Grid {



    public void displayGrid(int[][] array){


        for (int row = 0; row < array.length; row++) {
            System.out.println();
            System.out.print(row);
            for (int col = 0; col < array[row].length; col++) {
                if(array[row][col] == 1 || array[row][col] == 0) System.out.print("\t ");
                else if(array[row][col] == -1) System.out.print("\tx");
                else System.out.print("\tH");
               //System.out.print("\t" + array[row][col]);
            }
        }        System.out.print("\n\t0\t1\t2\t3\t4\t5\t6\t7");
        /*for (int row = 0; row < array.length; row++) {
            System.out.println();
            System.out.print(row);
            for (int col = 0; col < array[row].length; col++) {
//                if(array[row][col] == 1 || array[row][col] == 0) System.out.print("\tx");
//                else if(array[row][col] == -1) System.out.print("\t ");
//                else System.out.print("\tH");
                 System.out.print("\t" + array[row][col]);
            }
        }*/
    }
}
