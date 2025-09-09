package tries;

public class WordDictionary {

    /**
     * inal Complexity:
     *
     * AddWord: O(M) time, O(1) extra space
     * Search: O(M) for no wildcards, O(26^D × M) for D wildcards
     * Space: O(ALPHABET_SIZE × N × M) for storage + O(M) recursion stack
     */
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWordComplete = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        // TODO: Implement this (similar to your insert method)
        TrieNode curr = root;
        for (Character c: word.toCharArray()) {
            int index = c-'a';

            if(curr.children[index] == null){
                curr.children[index]  = new TrieNode();
            }

            curr = curr.children[index];
        }
        curr.isWordComplete = true;

    }

    public boolean search(String word){
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isWordComplete;  // Are we at end of a valid word?
        }

        char c = word.charAt(index);


        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (node.children[j] != null) {
                    if (searchHelper(node.children[j], word, index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            int indexWord = c - 'a';
            if (node.children[indexWord] == null) return false;
            return searchHelper(node.children[indexWord], word, index + 1);
        }

    }


    public static void main(String[] args){
        WordDictionary wd = new WordDictionary();

        System.out.println("=== Testing WordDictionary ===");

        // Add words
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println("Added: bad, dad, mad");

        // Test exact matches
        System.out.println("search('bad'): " + wd.search("bad"));   // Expected: true
        System.out.println("search('dad'): " + wd.search("dad"));   // Expected: true
        System.out.println("search('mad'): " + wd.search("mad"));   // Expected: true
        System.out.println("search('pad'): " + wd.search("pad"));   // Expected: false

        // Test wildcard matches
        System.out.println("search('.ad'): " + wd.search(".ad"));   // Expected: true (matches bad, dad, mad)
        System.out.println("search('b.d'): " + wd.search("b.d"));   // Expected: true (matches bad)
        System.out.println("search('b..'): " + wd.search("b.."));   // Expected: true (matches bad)
        System.out.println("search('..d'): " + wd.search("..d"));   // Expected: true (matches bad, dad, mad)

        // Test non-matches with wildcards
        System.out.println("search('.a.'): " + wd.search(".a."));   // Expected: false (no 3-letter words ending with anything but 'd')
        System.out.println("search('....'): " + wd.search("...."));  // Expected: false (no 4-letter words)

        // Additional test cases
        wd.addWord("a");
        wd.addWord("a");  // Duplicate
        System.out.println("Added: a, a");
        System.out.println("search('.'): " + wd.search(""));       // Expected: true (matches 'a')
        System.out.println("search('a'): " + wd.search("a"));       // Expected: true

        System.out.println("=== All Tests Complete ===");
    }


}
