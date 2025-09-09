package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {


    public static void main(String[] args){


     //   String[] nums= {"2", "1", "+", "3", "*"};


        String[] nums = {"4", "13", "5", "/", "+"};
// Explanation: 13 / 5 = 2, then 4 + 2 = 6
// Output: 6

        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("*");
        operators.add("-");
        operators.add("/");


        Stack<Integer> stack = new Stack<>();


        for(int i =0 ; i < nums.length;i++){

            String curr = nums[i];
            if(operators.contains(curr)){

                int valueTillNow = 0;
                int b = stack.pop();
                int a = stack.pop();
                if(curr == "+"){
                    valueTillNow = a+b;
                }else if(curr == "-"){
                    valueTillNow =a-b;
                }else if(curr == "*"){
                    valueTillNow = a*b;
                }else {
                    valueTillNow =a/b;
                }
                stack.push(valueTillNow);
            }else{
                stack.push(Integer.parseInt(curr));
            }

        }
        System.out.println(stack.pop());
    }




}
