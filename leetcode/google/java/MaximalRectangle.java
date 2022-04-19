package google.java;

import debug.UsefulPrinting;

import java.util.*;


public class MaximalRectangle {
    /*
     * Brute Force:
     * 1. Pre-compute the cumulative sum of all the cells of the matrix
     * 2. For every (i, j) to (k,l) in O(1) find the sum of sub-matrix
     *
     * Optimal O(n^3)
     * 1. Pre-compute the row matrix the longest number of 1's with index i,j
     * 2. Pre-compute the Column matrix the longest number of 1's with index i,j
     * 3. For index i,j -> iterate through the row until you get 1 and find max area
     *    For Eg: Take min from row colMat[i,j] to colMat[k,j]
     * 4. Do same for rowMat
     * */

    private final Integer[][] rect;
    private final Integer[][] colMat;
    private final Integer[][] rowMat;
    public  MaximalRectangle(char[][] rect) {
        this.rect = new Integer[rect.length][rect[0].length];
        this.colMat = new Integer[rect.length][rect[0].length];
        this.rowMat = new Integer[rect.length][rect[0].length];
        for (int i=0; i < rect.length; i++) {
            for (int j = 0; j < rect[0].length; j++) {
                this.rect[i][j] = rect[i][j] - '0';
            }
        }

        for (int i=0; i < rect.length; i++) {
            for (int j = rect[0].length -1; j >= 0; j--) {
                if (this.rect[i][j] == 0) {
                    this.colMat[i][j] = 0;
                } else {
                    this.colMat[i][j] = this.rect[i][j] + ((j != (rect[0].length -1)) ? this.colMat[i][j+1] : 0);
                }
            }
        }

        for (int i= rect.length -1; i >= 0; i--) {
            for (int j = 0; j < rect[0].length; j++) {
                if (this.rect[i][j] == 0) {
                    this.rowMat[i][j] = 0;
                } else {
                    this.rowMat[i][j] = this.rect[i][j] + ((i != (rect.length -1)) ? this.rowMat[i +1][j] : 0);
                }
            }
        }

        UsefulPrinting.print2DArray(this.rect);
        System.out.println("-------------");
        UsefulPrinting.print2DArray(this.rowMat);
        System.out.println("-------------");
        UsefulPrinting.print2DArray(this.colMat);
        System.out.println("-------------");
    }

    public int computeLargestSubRectangle() {
        int max1s = 0;
        for (int i = 0; i < rect.length; i++) {
            for (int j = 0; j < rect[0].length; j++) {
                if (rect[i][j] == 1) {
                    int currentMin = Integer.MAX_VALUE;
                    int k = i;
                    for (; k < rect.length && rect[k][j] == 1; k++) {
                        currentMin = Math.min(currentMin, colMat[k][j]);
                        max1s = Math.max(currentMin * (k-i +1), max1s);
                    }

                    currentMin = Integer.MAX_VALUE;
                    k = j;
                    for (; k < rect[0].length && rect[i][k] == 1; k++) {
                        currentMin = Math.min(currentMin, rowMat[i][k]);
                        max1s = Math.max(currentMin * (k -j +1), max1s);
                    }

                }
            }
        }

        return max1s;
    }


    public static void main(String[] args) {
//        char [][] matrix = {{'0'}};
//        char [][] matrix = {{'1'}};
//        char [][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char [][] matrix =
                {{'1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','0','0','0'},{'0','1','1','1','1','0','0','0'}};
        System.out.println(new MaximalRectangle(matrix).computeLargestSubRectangle());
    }
}

