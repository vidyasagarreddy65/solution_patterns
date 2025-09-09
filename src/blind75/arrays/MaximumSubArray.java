package arrays;

//kadens
public class MaximumSubArray {

    public static void main(String[] args){

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxContinuousSum(nums));

        System.out.println(maxContinuousSum(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6
        System.out.println(maxContinuousSum(new int[]{1}));                     // 1
        System.out.println(maxContinuousSum(new int[]{-1,-2,-3,-4}));   //-1
        System.out.println(maxContinuousSum(new int[]{5,3,-9,7,8}));
    }

    /**
     * Kandance alogrith
     *
     * O(n) and O(1)
     * @param nums
     * @return
     */
    public static int maxContinuousSum(int[] nums){

        if(nums.length==0)
        {
            return 0;
        }

        int maxSum = nums[0];

        int currSum = nums[0];
        for(int i =1; i < nums.length; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum,currSum);
        }

        return maxSum;

    }
}
