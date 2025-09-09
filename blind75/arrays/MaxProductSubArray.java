package com.company.blind75.arrays;

public class MaxProductSubArray {


    public static void main(String[] args){


        int[] nums ={2,3,-2,-4};


        System.out.println(maxProductSubArray(nums));

    }

    /**
     * o(n)
     * @param nums
     * @return
     */
    public static int maxProductSubArray(int[] nums){

        int maxSoFar= nums[0];

        int minSoFar= nums[0];
        int result = nums[0];

        for(int i =1 ;i < nums.length;i++){
            int tempMax = maxSoFar;

            maxSoFar = Math.max(nums[i],Math.max(maxSoFar*nums[i], minSoFar*nums[i]));
            minSoFar = Math.min(nums[i],Math.min(tempMax*nums[i], minSoFar*nums[i]));

            result = Math.max(result, maxSoFar);
        }
        return result;
    }



}
