package com.java.matrix;

/**
 * Your coding quest continues with this challenge: Write a Java function named countSubmatricesWithE that
 * calculates how many 3x3 submatrices in a given 2D array of characters have 'E's in all four corners.
 * Each 3x3 submatrix can be seen as a small square within the larger grid.
 *
 * Multiple test boards are provided to verify your solution works correctly across different scenarios.
 */
public class NoOfSubMatrixHavingAllCornerEmpty {
    public static int countSubmatricesWithE(char[][] board) {
        // TODO: Initialize a count variable to keep track of 3x3 submatrices with 'E's in all four corners

        int rows = board.length;
        int cols = board[0].length;
        int countSubmatrices = 0;
        // TODO: Use a nested loop to go through each element that can be the top-left corner of a 3x3 submatrix
        for(int i =0; i+2 < rows; i++) {

            for(int j =0; j+2 < cols; j++) {
                if(board[i][j] == 'E' &&  board[i][j+2] == 'E' &&
                        board[i+2][j] == 'E' &&  board[i+2][j+2] == 'E' ) {
                    countSubmatrices +=1;
                }
            }

        }

        // TODO: Check if the current 3x3 submatrix has 'E's in all four corners
        // If it does, increment the count

        // TODO: Return the count of submatrices with 'E's in all four corners
        return countSubmatrices;
    }

    public static void main(String[] args) {
        // Test case 1: Original board with 2 valid submatrices
        char[][] board1 = {
                {'E', 'P', 'E', 'P'},
                {'P', 'E', 'P', 'E'},
                {'E', 'P', 'E', 'P'},
                {'P', 'E', 'P', 'E'}
        };
        int result1 = countSubmatricesWithE(board1);
        System.out.println("Test 1: " + result1);
        assert result1 == 2 : "Expected 2, but got " + result1;

        // Test case 2: Board with no valid submatrices
        char[][] board2 = {
                {'P', 'P', 'P', 'P'},
                {'P', 'E', 'E', 'P'},
                {'P', 'E', 'E', 'P'},
                {'P', 'P', 'P', 'P'}
        };
        int result2 = countSubmatricesWithE(board2);
        System.out.println("Test 2: " + result2);
        assert result2 == 0 : "Expected 0, but got " + result2;

        // Test case 3: Minimal 3x3 board with E's in all corners
        char[][] board3 = {
                {'E', 'P', 'E'},
                {'P', 'P', 'P'},
                {'E', 'P', 'E'}
        };
        int result3 = countSubmatricesWithE(board3);
        System.out.println("Test 3: " + result3);
        assert result3 == 1 : "Expected 1, but got " + result3;

        // Test case 4: Board with all E's
        char[][] board4 = {
                {'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E'}
        };
        int result4 = countSubmatricesWithE(board4);
        System.out.println("Test 4: " + result4);
        assert result4 == 4 : "Expected 4, but got " + result4;

        // Test case 5: Larger board with multiple valid submatrices
        char[][] board5 = {
                {'E', 'P', 'E', 'P', 'E'},
                {'P', 'P', 'P', 'P', 'P'},
                {'E', 'P', 'E', 'P', 'E'},
                {'P', 'P', 'P', 'P', 'P'},
                {'E', 'P', 'E', 'P', 'E'}
        };
        int result5 = countSubmatricesWithE(board5);
        System.out.println("Test 5: " + result5);
        assert result5 == 4 : "Expected 4, but got " + result5;

        System.out.println("All tests passed!");
    }
}
