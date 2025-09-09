package com.company.blind75.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class validParentheses {

    public static void main(String[] args)
    {


        /*Input: "()[]{}"     → Output: true
Input: "([)]"       → Output: false
Input: "{[]}"       → Output: true
Input: "(("         → Output: false


         */

        String input = "((";
        System.out.println(validParenthesis(input));
    }

    /**
     * O(N) and O(N)
     * @param input
     * @return
     */
    public static boolean validParenthesis(String input){

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character>  stack = new Stack<>();

        for (char c: input.toCharArray() ) {
            if(map.containsKey(c)){
                if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
