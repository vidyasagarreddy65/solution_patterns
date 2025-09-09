package com.company.blind75.hashmap.or.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreqElements {


    public static void main(String[] args){


        int[] nums={1,1,1,2,2,3,3,3,3,3};


        topKElementsWithMaxHeap(nums, 2);

        topKFreqElementWithMinHeap(nums,2);
    }


    /**
     * Max Heap to but we are sorting its not better the o(n log(n))
     * @param nums
     * @param k
     */
    public static void topKElementsWithMaxHeap( int[] nums, int k){


        //FreqMap
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i <nums.length;i++){
            int count = freqMap.getOrDefault(nums[i], 0);
            freqMap.put(nums[i], count+1);
        }


        PriorityQueue<Map.Entry<Integer,Integer>> maxheap = new PriorityQueue<>((a,b)-> b.getValue()- a.getValue());
        maxheap.addAll(freqMap.entrySet());
        System.out.println("Top K elements");

        for(int i = 0; i < k; i++){
            System.out.println(maxheap.poll().getKey());
        }




    }


    /**
     * Step	Time
     * Count frequencies	O(n)
     * Heap insertions	O(n log k)
     * Extract + optional sort	O(k log k)
     * @param nums
     * @param k
     */
    public static void topKFreqElementWithMinHeap(int[] nums, int k){
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i <nums.length;i++){
            int count = freqMap.getOrDefault(nums[i], 0);
            freqMap.put(nums[i], count+1);
        }


        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a,b)-> a.getValue()- b.getValue());

        for (Map.Entry entry:freqMap.entrySet()) {

            minHeap.add(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }

        }
        System.out.println("Top K with min heap");
        for (Map.Entry minEntry: minHeap) {
            System.out.println(minEntry.getKey());
        }
    }
}
