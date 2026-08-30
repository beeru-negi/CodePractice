package com.java.matrix;

import java.util.ArrayList;
import java.util.List;
//https://codesignal.com/learn/course/348/unit/5
public class GridTraversal {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> res = pathTraverse(grid, 0, 0);
        for (int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> pathTraverse(int[][] grid, int row, int col) {


        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // Check the validity of the input
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            System.err.println("Invalid input");
            return new ArrayList<>();
        }

        List<Integer> path = new ArrayList<>();
        path.add(grid[row][col]);

        while(true){

            int maxGridValue = Integer.MIN_VALUE;
            int nextRow = -1;
            int nextCol = -1;
            for(int[] dir : directions){
                int currentGridValue = grid[row][col];
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length){
                    continue;
                }

                if(grid[newRow][newCol] > maxGridValue){
                    maxGridValue = grid[newRow][newCol];
                    nextRow = newRow;
                    nextCol = newCol;
                }

            }

            // If you do not have any higher value in neighbour compare to current value. exit
            if(maxGridValue <= grid[row][col]){
                break;
            }

            // append max value to path
            path.add(maxGridValue);

            // Otherwise, go to the next cell
            row = nextRow;
            col = nextCol;


        }

        return path;
    }
}
