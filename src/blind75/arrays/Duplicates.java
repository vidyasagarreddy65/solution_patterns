package arrays;

import java.util.HashMap;
import java.util.Map;

public class Duplicates {


    public static void main(String[] args){


        int[] nums={1,5,3,6};


        System.out.println("duplicate"+duplicates(nums));


    }

    /**
     * O(n) and O(n) better to use set
     * @param nums
     * @return
     */
    public static boolean duplicates(int[] nums){

        Map<Integer, Integer> trackDuplicates = new HashMap<>();

        for(int i =0 ; i < nums.length;i++){

            if(trackDuplicates.containsKey(nums[i])){
                return true;
            }

            trackDuplicates.put(nums[i], nums[i]);

        }

        return false;
    }


}
