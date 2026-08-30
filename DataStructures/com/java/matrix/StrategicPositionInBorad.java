package com.java.matrix;

import java.util.ArrayList;
import java.util.List;

public class StrategicPositionInBorad {


    public static List<int[]> findPositions(char[][] board) {
        List<int[]> positions = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'E') {
                    if ((i > 0 && board[i - 1][j] == 'E') ||
                            (i < rows - 1 && board[i + 1][j] == 'E') ||
                            (j > 0 && board[i][j - 1] == 'E') ||
                            (j < cols - 1 && board[i][j + 1] == 'E')) {
                        positions.add(new int[]{i, j});
                    }
                }
            }
        }
        return positions;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'P', 'E', 'E', 'P'},
                {'E', 'P', 'E', 'P'},
                {'P', 'E', 'P', 'P'},
                {'P', 'E', 'P', 'E'}
        };

        List<int[]> positions = findPositions(board);

        for (int[] pos : positions) {
            System.out.println("(" + pos[0] + ", " + pos[1] + ")");
        }
    }
}


