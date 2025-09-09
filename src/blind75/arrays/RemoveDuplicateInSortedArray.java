package arrays;

public class RemoveDuplicateInSortedArray {
    /**
     * Problem 3: Remove Duplicates from Sorted Array
     * Difficulty: Easy
     * <p>
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once, and return the new length.
     * <p>
     * You must do this by modifying the input array in-place with O(1) extra memory.
     */


    public static void main(String[] args) {

        int[] nums = {1,1,2,2,3,3,3,4};

        System.out.println(removeDuplicates(nums));
    }


    /**
     * O(N) and O(1)
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums){


        int prevIndex= 0;

        for(int i =1 ; i < nums.length;i++){
            if(nums[i] != nums[prevIndex]){
                prevIndex++;
                nums[prevIndex] = nums[i];
            }
        }

        return prevIndex+1;

    }

}
