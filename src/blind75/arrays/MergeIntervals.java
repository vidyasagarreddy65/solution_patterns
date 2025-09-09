package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {


    public static void main(String[] args){


        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] intervals1 = {
                {1, 10},
                {2, 3},
                {4, 5},
                {6, 9}
        };
// Output: [[1, 10]]

        int[][] intervals2 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
// Output: [[1, 2], [3, 4], [5, 6]]

        int[][] intervals3= {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };
// Output: [[1, 5]]

        List<List<Integer>> result =  mergeInterval(intervals3 );


        for(int i =0 ;i < result.size();i++){
            System.out.println(result.get(i).get(0)+","+ result.get(i).get(1));

        }




    }


    /**
     * o(n)
     * o(n)
     * @param intervals
     * @return
     */
    public static List<List<Integer>>   mergeInterval(int[][] intervals){
        List<List<Integer>> mergedInterval = new ArrayList<>();

        if(intervals.length ==0){
            return mergedInterval;
        }

       // int[][] mergedInterval = new int[][]{intervals[0]};



        int[] lastInterval = intervals[0];

        mergedInterval.add(new ArrayList<>(Arrays.asList(lastInterval[0], lastInterval[1])));

        int trackIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(lastInterval[1] <= intervals[i][0]){

                List<Integer>   temp  = new ArrayList<>();
            //    temp.add(intervals[i][0]);
            //    temp.add(intervals[i][1]);
           //     mergedInterval[trackIndex++] = intervals[i];
                lastInterval= intervals[i];

              //  mergedInterval.add(temp);

                mergedInterval.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
            }else if(lastInterval[1]> intervals[i][0]){
                int[] merged = new int[]{Math.min(lastInterval[0],intervals[i][0]),
                Math.max(lastInterval[1], intervals[i][1])};
                lastInterval = merged;

                mergedInterval.get(mergedInterval.size() - 1).set(1, lastInterval[1]);
            }
        }

        return mergedInterval;
    }
}
