package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    /**
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b"
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke"
     * @param args
     */
    public static void main(String args[]){

        String input = "abcabcbb";


        String input1 = "bbbbb";
        String input2 = "pwwkew";

        System.out.println(longestSubString(input));
       System.out.println(longestSubString(input1));
        System.out.println(longestSubString(input2));



        //Variant with atmost 2

        System.out.println(longSubStringAtMostKDistinctCharacter("eceba", 2));  // Output: 3
        System.out.println(longSubStringAtMostKDistinctCharacter("aaabbcc", 2)); // Output: 5
        System.out.println(longSubStringAtMostKDistinctCharacter("abcabc", 3));  // Output: 6



    }


    /**
     * O(N) and O(K) where k is character set
     * @param input
     * @return
     */
    public static int longestSubString(String input){
        Map<Character, Integer>  indexMap = new HashMap<>();
        int left =0;
        int maxLength =0;
        for (int right =0 ;right < input.length();right++){

            Character currChar = input.charAt(right);
            if(indexMap.containsKey(currChar) && indexMap.get(currChar) >= left ){
                left= indexMap.get(currChar)+1;
            }
            indexMap.put(currChar, right);
            maxLength= Math.max(right-left+1, maxLength);
        }

        return  maxLength;
    }


    //variant of f


    public static int longSubStringAtMostKDistinctCharacter(String input, int k){


        int left =0;
        int maxLen=0;
        Map<Character,Integer> charMap = new HashMap<>();
        for(int right=0 ; right<input.length();right++){

            Character currChar = input.charAt(right);

            charMap.put(currChar, charMap.getOrDefault(currChar,0)+1);

            while(charMap.size()>k){
                if(charMap.containsKey(input.charAt(left))){
                    if(charMap.get(input.charAt(left) )> 1){
                        charMap.put(input.charAt(left),charMap.get(input.charAt(left))-1);
                    }else {
                        charMap.remove(input.charAt(left));
                    }
                    left++;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);

        }

        return maxLen;
    }




}
