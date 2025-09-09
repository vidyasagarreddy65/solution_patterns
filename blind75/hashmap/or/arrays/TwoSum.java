package com.company.blind75.hashmap.or.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public static void main(String[] args) {
        // write your code here



        int[] nums= {2,7,11,15};
        int target = 9;


        int[] result = twoSum(nums,target);

        for(int i=0; i < result.length;i++){
            System.out.println(result[i]);
        }

        System.out.println("Sorted input array :");


        int[] numbers = {2,7,11,15};

        int finalTarget = 9;
        //for sorted input array
        int[] result1 = twoSumOfSortedInput(numbers,finalTarget);
        for(int i=0; i < result1.length;i++){
            System.out.println(result1[i]);
        }

    }

    /**
     * Time Complexity = O(n)
     * Space Complexity= O(n) where is n is length of input array
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target){

        Map<Integer, Integer> targetMap = new HashMap<>();


        for(int i =0; i <nums.length; i++){
            int comp = target-nums[i];
            if(targetMap.containsKey(comp)){
                return new int[]{targetMap.get(comp),i};

            }
            targetMap.put(nums[i], i);
        }

        return new int[]{};


    }

    //variant if the input is sorted, we can leverage the the two pointer.

    /**
     * O(n) and O(1)
     * @param nums
     * @param target
     * @return
     */

    public static int[] twoSumOfSortedInput(int[] nums, int target){


        int left =0;
        int right = nums.length-1;


        while(left < right){
            int sum = nums[left]+nums[right];
            if(sum > target){
                right--;
            }else if(sum < target){
                left++;
            }else if(sum == target){
               return  new int[] { left+1, right+1 };
            }
        }


        return  new int[] { -1, -1 };




    }

}
