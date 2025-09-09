package com.company.blind75;

public class ValidPalindrom {

    public static void main(String[] args){


        // System.out.println("valid Palindrom : "+ validPalin("A man, a plan, a canal: Panama"));
      //  System.out.println("valid Palindrom :"+ validPalin("race a car"))
        // Valid palindrom2

        /**
         *
         * "abca" → true
         *
         * "abc" → false
         *
         * "racecar" → true
         *
         * "deeee" → true
         *
         * "abcdef" → false
         */
        System.out.println("Valid Plalin 2 " + validPalindrome2("abca"));


    }

    /**
     * Time complexity is o(n) and o(1)
     * @param inputStr
     * @return
     */
    public static boolean validPalin(String inputStr){
        if(inputStr == null || inputStr.length() ==0){
            return false;
        }
        int left =0;

        int right = inputStr.length()-1;

        while(left <= right){
            while(left< right && !Character.isLetterOrDigit(inputStr.charAt(left))) left++;
            while(left< right && !Character.isLetterOrDigit(inputStr.charAt(right)))  right--;
            if(Character.toLowerCase(inputStr.charAt(left)) != Character.toLowerCase(inputStr.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    ///Valid Palindrom 2

    /**
     *Difficulty: Easy–Medium
     *
     * Given a string s, return true if the s can be a palindrome after deleting at most one character from it.
     *Input: s = "abca"
     * Output: true
     * Explanation: Remove 'b' or 'c' → "aca" or "aba" are palindromes.
     * Input: s = "abc"
     * Output: false
     */
    public static boolean validPalindrome2(String input){
        int left =0;
        int right = input.length()-1;

        while(left <= right){
            if(input.charAt(left) != input.charAt(right) ){
                return isValidPalindromHelper(input, left+1, right) || isValidPalindromHelper(input, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    };

    public static boolean isValidPalindromHelper(String input, int left, int right) {

        while (left <= right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
    return true;
    }

}
