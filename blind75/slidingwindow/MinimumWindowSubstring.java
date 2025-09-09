package com.company.blind75.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {


    public static void main(String[] args) {


        String s = "ADOBECODEBANC";

        String t2 = "ABC";

        System.out.println(minimumWindowSubstring(s, t2));


    }


    public static String minimumWindowSubstring(String s1, String t2) {

        if (t2.length() > s1.length()) return "";

        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < t2.length(); i++) {
            char curr = t2.charAt(i);
            freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);
        }

        //Now sliding window

        int left = 0;

        Map<Character, Integer> windowMap = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int have = 0;
        int startIndex = 0;
        for (int right = 0; right < s1.length(); right++) {

            char currChar = s1.charAt(right);
            windowMap.put(currChar, windowMap.getOrDefault(currChar, 0) + 1);

            if (freqMap.containsKey(currChar) && windowMap.get(currChar) == freqMap.get(currChar)) {
                have++;
            }

            while(have == freqMap.size()){
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }
                char leftChar = s1.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (freqMap.containsKey(leftChar) &&
                        windowMap.get(leftChar) < freqMap.get(leftChar)) {
                    have--;
                }


                left++;
            }
        }
        if (minLen != Integer.MAX_VALUE) {
            return s1.substring(startIndex, startIndex + minLen);
        } else {
            return ""; // no valid window
        }


    }
}
