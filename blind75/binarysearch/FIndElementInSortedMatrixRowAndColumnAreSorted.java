package com.company.blind75.binarysearch;


/**
 * problem Statement:
 * You're given an m x n matrix where:
 *
 * Each row is sorted in ascending order (left to right),
 *
 * Each column is sorted in ascending order (top to bottom).
 *
 * Write a function to search for a target value in this matrix.
 * Return true if the target is found, and false otherwise.
 *
 * Input:
 * matrix = [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * target = 5
 *
 * Output: true
 *
 * ---
 * target = 20
 * Output: false
 */
public class FIndElementInSortedMatrixRowAndColumnAreSorted {

    public static void main(String[] args){


        int[][] matrix = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24}, {
                18, 21, 23, 26, 30
            }};

        System.out.println(findElement(matrix, 20));
    }


    /**
     * O(M+N) is timecomplexity
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findElement(int[][] matrix, int target){


        int row = 0;
        int col =matrix[0].length-1;

       while(row< matrix.length && col>=0){
           int val = matrix[row][col];
           if(val == target)  return true;
           if(target > val){
              row++;
           }else if(target< val){
               col--;
           }
       }
       return false;
    }


}
