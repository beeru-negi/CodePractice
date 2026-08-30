package com.java.matrix;

/**
 * In this lesson, you'll be taking on the role of a developer working on improving a reservation system at a
 * tech-savvy restaurant. The restaurant utilizes digital seating charts to plan out their table arrangements,
 * which are represented by 2D arrays. Your objective is to correct a slight error in the function transposeSeating
 * that's meant to rearrange the restaurant’s seating layout by transposing the seating chart. Unfortunately,
 * the matrix transposition isn't working correctly.
 * Inspect the Java code carefully and adjust it to ensure it correctly transposes the matrix.
 */
public class ArrayTranspose {
    static int[][] transposeSeating(int[][] seating) {
        int rows = seating.length;
        int cols = seating[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < cols; ++i) {
            for (int j = 0; j < rows; ++j) {
                transposed[i][j] = seating[j][i];
            }
        }

        return transposed;
    }

    public static void main(String[] args) {
        // Sample restaurant seating arrangement represented as a 2D array
        int[][] restaurantSeating = {
                {10, 11, 12},
                {20, 21, 22}
        };

        // Trying to transpose the seating arrangement
        int[][] transposedSeating = transposeSeating(restaurantSeating);

        for (int[] row : transposedSeating) {
            for (int seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
        // Output isn't as expected. Can you identify the fix?
    }
}
