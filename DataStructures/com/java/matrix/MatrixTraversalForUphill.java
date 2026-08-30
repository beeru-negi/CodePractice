package com.java.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixTraversalForUphill {

        // TODO: Define the pathTraverse function which takes a mountain matrix and the current position (row, column) as parameters.
        // The function should return an ArrayList of int arrays representing the coordinates of the path taken,
        // starting from the initial position and moving to each higher adjacent cell.
        public static List<int[]> pathTraverse(int[][] mountain, int startRow, int startCol){
            int rows = mountain.length;
            int cols = mountain[0].length;

            if(startRow < 0 || startRow >= rows || startCol < 0 || startCol > cols) {
                return new ArrayList<>();
            }

            int maxValue = mountain[startRow][startCol];
            List<int[]> pathCoordinates = new ArrayList<>();
            pathCoordinates.add(new int[]{startRow, startCol});

            int[][] neighbours = {{1,0}, {-1,0}, {0,1},{0,-1}};

            while(true) {
                int nextRow = -1;
                int nextCol = -1;

                for(int[] direction :neighbours) {
                    int newRow = startRow + direction[0];
                    int newCol = startCol + direction[1];

                    if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                        continue;
                    }

                    if(newRow >=0 && newRow < rows && newCol >=0 && newCol < cols && mountain[newRow][newCol] > maxValue) {
                        maxValue = mountain[newRow][newCol];
                        nextRow = newRow;
                        nextCol = newCol;
                    }
                }

                if(mountain[startRow][startCol] == maxValue) {
                    break;
                }

                pathCoordinates.add(new int[]{nextRow,nextCol});
                startRow = nextRow;
                startCol = nextCol;
            }

            return pathCoordinates;


        }

        public static void main(String[] args) {
            // TODO: Create a matrix named 'mountain' representing ascending values, akin to the increasing elevation while hiking up a mountain.
            int[][] mountain = {
                    {60,59,58,55},
                    {21,42,56,7},
                    {3,43,33,44},
                    {12,24,35,22}

            };
            int startRow =  2;
            int startCol = 2;

            // TODO: Set the starting position on the mountain using an array to store the row and column index.

            // TODO: Call the pathTraverse function to find the path from the starting point.
            List<int[]> pathCoordinates = pathTraverse(mountain, startRow, startCol);

            // TODO: Output the coordinates of the path taken from the starting point.
            for(int[] path : pathCoordinates) {
                System.out.println(path[0]+", "+ path[1]);
            }


        }

}
