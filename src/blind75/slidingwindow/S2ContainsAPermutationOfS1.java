package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * s1 = "ab";
 * s2 = "eidbaooo";
 * Output: true // "ba" is a valid permutation in s2
 *
 *
 * s1 = "ab";
 * s2 = "eidboaoo";
 * Output: false
 *
 * s1 = "abc";
 * s2 = "abcxyz";
 * Output: true // "abc" is a direct match
 *
 * s1 = "xyz";
 * s2 = "abcdefghixyz";
 * Output: true // "xyz" at end
 *
 * s1 = "abcd";
 * s2 = "abc";
 * Output: false
 *
 * s1 = "abc";
 * s2 = "acdbefg";
 * Output: false // "cdb" ≠ permutation of "abc"
 *
 *
 * s1 = "aabc";
 * s2 = "caaebabacb";
 * Output: true // "abac" is a permutation
 */
public class S2ContainsAPermutationOfS1 {


    public static void main(String[] args){

        String s1 = "ab";
        String s2 = "eidbaooo";




        System.out.println(s2ContainsS1Permutations(s1,s2));

//NO Match
        /*s1 = "ab";
s2 = "eidboaoo";
Output: false
        * */

        System.out.println(s2ContainsS1Permutations("ab","eidboaoo"));
    }
    public static boolean s2ContainsS1Permutations(String s1,String s2){


        if(s1.length()> s2.length()){

            return false;
        }


        Map<Character, Integer> s1FreqMap = new HashMap<>();
        for (int i =0; i < s1.length();i++){
            s1FreqMap.put(s1.charAt(i), s1FreqMap.getOrDefault(s1.charAt(i),0)+1);
        }

        int windowSize = s1.length();
        Map<Character, Integer> windowMap = new HashMap<>();
        for(int right =0; right < s2.length();right++){

            char currChar = s2.charAt(right);
            windowMap.put(currChar,windowMap.getOrDefault(currChar, 0) + 1);
            if (right >= windowSize) {
                char leftChar = s2.charAt(right - windowSize);
                if (windowMap.get(leftChar) == 1) {
                    windowMap.remove(leftChar);
                } else {
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
                if (windowMap.equals(s1FreqMap)) {
                    return true;
                }
            }
        }

        return false;

    }
}
