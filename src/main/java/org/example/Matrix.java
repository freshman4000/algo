package org.example;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        /*
         *       {7, 4, 1}
         *       {8, 5, 2}
         *       {9, 6, 3}
         * */
        int[][] matrix1 = new int[][]{
                {1, 2},
                {4, 5}
        };
        /*
         *       {7, 4, 1}
         *       {8, 5, 2}
         *       {9, 6, 3}
         * */
        int[][] matrix2 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        /*6
         *       {13,  9, 5, 1}
         *       {14, 10, 6, 2}
         *       {15, 11, 7, 3}
         *       {16, 12, 8, 4}
         * */
        int[][] input = matrix2;
        rotateMatrix(input);
        for (int[] row : input) {
            System.out.println(Arrays.toString(row));
        }
    }
    public static void rotateMatrix(int [][] input) {
        //resolve matrix boundaries
        int L = 0;
        int R = input.length - 1;
        //narrowing matrix boundaries in each cycle
        while(L < R) {
            int T = L;
            int B = R;
            //iterating over row between L and R markers
            for (int i = 0; i < R - L; i++) {
                //saving in temp left corner of matrix
                int temp = input[T][L + i];
                input[T][L + i] = input[B - i][L];
                input[B - i][L] = input[B][R - i];
                input[B][R - i] = input[T + i][R];
                input[T + i][R] = temp;
            }
            L++;
            R--;
        }
    }
}

