package com.company.blind75.hashmap.or.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {


    public static void main(String[] args){



        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagram(input));

    }

    /**
     * O(n*k) n  is length and k is max word lenght
     * space o(n)
     *
     * @param array
     * @return
     */
    public static List<List<String>>  groupAnagram(String[] array){

        Map<String, List<String>> groupAnagrams= new HashMap<>();

        for(int i =0 ; i < array.length; i++){
            int[] charCount = new int[26];
            for (char c : array[i].toCharArray()) {
                charCount[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int c: charCount) {
                key.append(c+"#");
            }
            List<String> value = groupAnagrams.getOrDefault(key.toString(), new ArrayList<>());
            value.add(array[i]);
            groupAnagrams.put(key.toString(),value);
        }
        return new ArrayList<>(groupAnagrams.values());
    }


}

