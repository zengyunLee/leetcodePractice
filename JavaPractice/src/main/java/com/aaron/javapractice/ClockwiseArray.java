package com.aaron.javapractice;

public class ClockwiseArray {

    public static void main(String[] args) {
        int[][] testMatrix = new int[3][4];
        int temp = 1;
        for(int i = 0 ; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                testMatrix[i][j] = temp++;
            }
        }
        printMatrix(testMatrix);
        int[] mapedArr = spiralOrder(testMatrix);
        for(int i = 0; i < mapedArr.length; i++) {
            System.out.println(mapedArr[i]);
        }
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int left = 0, top = 0, right = columns - 1, bottom = rows - 1;
        int index = 0;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                order[index++] = matrix[top][i];
            }
            for(int j = top + 1; j <= bottom; j++) {
                order[index++] = matrix[j][right];
            }
            if(left < right && top < bottom) {
                for (int k = right - 1; k > left; k--) {
                    order[index++] = matrix[bottom][k];
                }
                for (int l = bottom; l > top; l--) {
                    order[index++] = matrix[l][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    private static void printMatrix(int[][] matrix) {
        if(matrix.length > 0 && matrix[0].length > 0) {
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[i].length; j++) {
                    System.out.println(matrix[i][j]);
                }
            }
        }
    }
}
