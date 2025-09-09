package binarysearch;

public class FindElementINRoatedSortedArray {


    public static void main(String[] args){

        int[] input = {3,4,5,1,2};

        System.out.println(findElementIndex(input, 0)); //-1
        System.out.println(findElementIndex(input, 4)); //1
        System.out.println(findElementIndex(input, 1)); //3
    }

    /**
     * O(n) and o(1)
     * @param array
     * @param target
     * @return
     */
    public static int findElementIndex(int[] array, int target){

        int left =0;
        int right =array.length-1;
        while(left <= right){
            int mid = left+ (right-left)/2;
            if (array[mid] == target) return mid;
            /// left half is sorted

            if(array[left] <= array[mid]){


                if(target>= array[left] && target<= array[mid] ){
                    right= mid-1;
                }else{
                    left = mid+1;
                }


            }else{

                if(target>= array[mid] && target<=array[right]){

                    left= mid+1;


                }else{
                    right= mid-1;
                }


            }


        }
        return -1;
    }



}
