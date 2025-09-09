package arrays;

public class ProductExceptSelf {


    public static void main(String[] args){

        int[] nums = {1, 2, 3, 4};





        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for(int i =1 ; i < nums.length;i++){
           prefix[i] = nums[i-1]* prefix[i-1];
        }
        int rightProduct = 1;
        for(int i = nums.length-1; i >=0 ; i--){
            prefix[i] = prefix[i]* rightProduct;
            rightProduct= rightProduct*nums[i];
        }


        for(int k=0 ; k<prefix.length;k++){
            System.out.println(prefix[k]);

        }


    }
}
