package stack;

import java.util.ArrayList;
import java.util.List;


//use phython tutot for vizualizeing or manually do the diagram

public class ValidParthensisFromN {

    /**
     *                           ""
     *                          /  \
     *                        (     X    ← close not allowed yet
     *                      /
     *                   "("
     *                  /   \
     *                ((     ()
     *               /         \
     *            (()          ()(
     *           /              \
     *         (())            ()()
     *
     *         ✅ Leaf nodes = valid combinations (length 4)
     *
     * 🔙 After visiting each leaf, you go back up and explore other branches

     * @return
     */

    public static void main(String[] args){
        int n =2;
        List<String> result = new ArrayList<>();
        generateString(result, "", 0, 0, n);
      System.out.println(result);
    }


    public static void generateString(List<String> result,String curr, int open , int close , int n){
        if(curr.length() == n*2 ){
            System.out.println("✅ ADD to result: " + curr);
            result.add(curr);
            return;
        }
        if(open< n) generateString(result,curr+"(", open+1, close, n);
        if(close< open) generateString(result,curr+")", open, close+1, n);
        System.out.println("⬅️ RETURN: current=" + curr);

    }



}
