package com.company.blind75.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class MaxiumWindowArraySliding {

    public static void main(String[] args){
    int[] nums= {1,3,-1,-3,5,3,6,7};
System.out.println(result(nums, 3));
    }
    public static List<Integer> result(int[] nums, int target){
        int left =0;
        List<Integer> result = new ArrayList<>();
        int maxInWindow = Integer.MIN_VALUE;
        for(int right=0;right< nums.length; right++){
            maxInWindow= Math.max(maxInWindow, nums[right]);

            if(right-left+1>=target){
                result.add(left,maxInWindow);
                left++;
                maxInWindow= nums[right];
            }
        }


    return result;

    }




}
