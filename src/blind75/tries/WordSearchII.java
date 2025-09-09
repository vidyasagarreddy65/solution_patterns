package tries;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {


    static class TrieNode{

        TrieNode[] children = new TrieNode[26];
        String word;
    }


    /**
     * Total Space: O(W×L)
     * Why not O(M×N)?
     *
     * We don't allocate extra space proportional to board size
     * We reuse the board itself for marking visited cells
     * Space grows with number/length of words, not board dimensions
     *
     * Why not O(H) for recursion?
     *
     * The recursion depth is bounded by word length, not board height
     * Even on a 100×100 board, if max word length is 10, recursion depth is max 10
     *Complete Time Complexity Analysis:
     * Your Analysis:
     *
     * ✅ O(M×N) - Good start (we visit each cell as starting point)
     * ❌ Missing the DFS exploration part
     *
     * Full Time Complexity: O(M×N × 4^L)
     *
     *
     *
     * @param words
     * @return
     */
    private static TrieNode buildTrie(String[] words){
        TrieNode node = new TrieNode();

        for (String word: words) {
            TrieNode curr = node;
            for (Character c: word.toCharArray()) {
                int index = c-'a';
                if(curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.word = word;
        }

        return  node;
    }
    public static void main(String[] args) {
        WordSearchII solution = new WordSearchII();

        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        String[] words = {"oath","pea","eat","rain"};

        List<String> result =findWords(board, words);
        System.out.println("Found words: " + result);
    }

    public static List<String> findWords(char[][] board, String[] words){

        List<String> results = new ArrayList<>();

        TrieNode node = buildTrie(words);


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, node, results);
            }
        }

        return results;


    }

    public static void dfs(char[][] board, int i , int j, TrieNode node, List<String> results){

        // Step 1: Check bounds and if cell is already visited
        if( i < 0 ||  i >= board.length  || j< 0 || j >= board[0].length){
            return ;  //OUT of bounds
        }


        char c = board[i][j];

        if(c == '#'){
            return ; // ALREADY VISITED
        }

        // Step 2: Check if current character exists in Trie
        int index = c-'a';
        if(node.children[index] == null) return ;

        // Step 3: Move to next node in Trie
        node = node.children[index];

        if(node.word != null){
            results.add(node.word);
            node.word = null;//AVOID duplication
        }
      // Step 5: BACKTRACKING SETUP - Mark cell as visited
        board[i][j] = '#'; // Mark as visited for current path



        // Step 6: Explore all 4 directions (UP, DOWN, LEFT, RIGHT)
        dfs(board, i-1, j, node,results ); //UP
        dfs(board, i+1, j, node,results );// DOWN

        dfs(board, i, j-1, node,results );//LEFT
        dfs(board, i, j+1, node,results );//RIGHT


        board[i][j] = c;
    }


}
