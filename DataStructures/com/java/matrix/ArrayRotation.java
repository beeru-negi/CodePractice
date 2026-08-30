package com.java.matrix;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        // Traverse matrix in order 12,9,6,3,4,5,8,11,10,4,1
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        String direction = "UP";
        int row = rows - 1;
        int col = cols - 1;
        int index = 0;

        int[] result = new int[rows * cols];
        while( index < rows * cols ) {
             result[index++] = matrix[row][col];
             if(direction.equals("UP")) {
                 if (row - 1 < 0) {
                     direction = "DOWN";
                     col = col - 1;
                 } else {
                     row = row - 1;
                 }
             }else {
                 if(row+1 >= rows) {
                     direction = "UP";
                     col = col - 1;
                 } else {
                     row = row + 1;
                }
             }

        }
        System.out.println(Arrays.toString(result));
    }
}
