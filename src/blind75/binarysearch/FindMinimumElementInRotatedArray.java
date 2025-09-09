package binarysearch;

public class FindMinimumElementInRotatedArray {


    public static void main(String[] args){

        System.out.println(findMinimumElement(new int[]{4,5,6,7,0,1,2})); // 0
        System.out.println(findMinimumElement(new int[]{3,4,5,1,2}));     // 1
        System.out.println(findMinimumElement(new int[]{1,2,3,4,5}));     // 1
        System.out.println(findMinimumElement(new int[]{2,1}));           // 1
    }

    public static int findMinimumElement(int[] nums){

        int left = 0;
        int right = nums.length-1;
        while(left< right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
       return nums[left];

    }
}
