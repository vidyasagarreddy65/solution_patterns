package com.company.blind75.binarysearch;

public class Search_2D_BInarySearch {


    public static void main(String[] args){


        int[][] matrix ={  {1, 3, 5, 7},
                           {10, 11, 16, 20},
                            {23, 30, 34, 60}
                        };

        System.out.println(findElement(matrix, 34));

    }

    /** this is easy for
     *
     * when m is less but when m grow is worst case will come, so you should know how to flatten the 2D to 1D array and access the elements
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findElement(int[][] matrix,int target){

        int rowLen = matrix.length-1;


        for(int i= 0 ; i <=rowLen; i++){
            int[] row = matrix[i];
            if(target>=row[0] && target<=row[row.length-1]){
               return findElement(row, target) != -1?true:false ;

            }
        }

        return false;
    }

    public static int findElement(int[] nums, int target){

        int left=0;
        int right= nums.length-1;

        while(left <= right){
            int mid = left+ (right-left)/2;
            if(nums[mid]> target){
                right= mid-1;
            }else if(nums[mid]< target){
                left = mid +1;
            }else {
                return  mid;
            }
        }
        return -1;
    }
}
