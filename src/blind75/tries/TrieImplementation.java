package tries;


/**
 * Complexity Analysis:
 *
 * Time: O(M) for all operations (M = word/prefix length)
 * Space: O(ALPHABET_SIZE × N × M) in worst case
 */
public class TrieImplementation {


    public static class TrieNode{

        TrieNode[] children = new TrieNode[26];

        boolean isWordComplete = false;

    }


    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            // TODO: Implement this method
            TrieNode current = root;
            for (Character c: word.toCharArray()) {
                int index = c- 'a';
                if(current.children[index] == null){
                    current.children[index] = new TrieNode();
                }
                current =  current.children[index];
            }

            current.isWordComplete = true;


        }

        public boolean search(String word) {
            // TODO: Implement this method
            TrieNode current = root;
            for (Character c: word.toCharArray()) {
                int index = c-'a';
                if(current.children[index] == null) return false;
                current = current.children[index];
            }

            return current.isWordComplete;
        }

        public boolean startsWith(String prefix) {
            // TODO: Implement this method
            TrieNode curr = root;

            for (Character c:prefix.toCharArray()) {
                int index = c-'a';

                if(curr.children[index] == null) return  false;

                curr = curr.children[index];
            }

            return true;
        }
    }


    public static void main(String[] args){

        Trie trie = new Trie();

        System.out.println("=== Testing Trie Implementation ===");

        // Test Case 1: Basic insertion and search
        trie.insert("apple");
        System.out.println("After inserting 'apple':");
        System.out.println("search('apple'): " + trie.search("apple"));     // Expected: true
        System.out.println("search('app'): " + trie.search("app"));         // Expected: false
        System.out.println("startsWith('app'): " + trie.startsWith("app")); // Expected: true
        System.out.println();

        // Test Case 2: Insert prefix of existing word
        trie.insert("app");
        System.out.println("After inserting 'app':");
        System.out.println("search('app'): " + trie.search("app"));         // Expected: true
        System.out.println("search('apple'): " + trie.search("apple"));     // Expected: true
        System.out.println("startsWith('ap'): " + trie.startsWith("ap"));   // Expected: true
        System.out.println();

        // Test Case 3: Multiple words with shared prefix
        trie.insert("application");
        trie.insert("apply");
        trie.insert("apricot");
        System.out.println("After inserting 'application', 'apply', 'apricot':");
        System.out.println("search('application'): " + trie.search("application")); // Expected: true
        System.out.println("search('apply'): " + trie.search("apply"));             // Expected: true
        System.out.println("search('apricot'): " + trie.search("apricot"));         // Expected: true
        System.out.println("startsWith('apr'): " + trie.startsWith("apr"));         // Expected: true
        System.out.println("startsWith('xyz'): " + trie.startsWith("xyz"));         // Expected: false
        System.out.println();

        // Test Case 4: Edge cases
        trie.insert("a");
        System.out.println("After inserting single character 'a':");
        System.out.println("search('a'): " + trie.search("a"));             // Expected: true
        System.out.println("startsWith('a'): " + trie.startsWith("a"));     // Expected: true
        System.out.println();

        // Test Case 5: Non-existent searches
        System.out.println("Testing non-existent words:");
        System.out.println("search('banana'): " + trie.search("banana"));   // Expected: false
        System.out.println("search('applez'): " + trie.search("applez"));   // Expected: false
        System.out.println("startsWith('ban'): " + trie.startsWith("ban")); // Expected: false
        System.out.println();

        System.out.println("=== All Tests Complete ===");

    }
}
