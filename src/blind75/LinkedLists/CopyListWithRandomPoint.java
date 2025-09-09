package LinkedLists;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * "don’t mutate original list" requirement comes from in the LeetCode Blind 75 version of:
 *
 * 🔗 Problem: Copy List with Random Pointer
 *
 * Note: aboveDeepc
 * You are given a linked list where each node has two pointers:
 *
 * next: the next node in the list
 *
 * random: a pointer to any node in the list (or null)
 *
 * Your task is to create a deep copy of the list.
 *
 * 7 → 13 → 11 → 10 → 1
 *      ↑         ↑     ↑
 *      |         |     |
 *      └─────┐   |     |
 *            |   └─────┐
 *            ↓         ↓
 *           7         11
 *
 */
public class CopyListWithRandomPoint {


    public static void main(String[] args){

// Create original list
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node copiedHead = copyRandomList(node1);
        printList(copiedHead);

    }


    /**
     * Time: O(n)
     *
     * Space: O(n) (due to the map)
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head){


        Map<Node, Node> nodeNodeMap = new HashMap<>();

        Node curr = head;

        //put all node in a map with current and new one we are creating a deep copy
        while(curr != null){
            nodeNodeMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            nodeNodeMap.get(curr).next = nodeNodeMap.get(curr.next);
            nodeNodeMap.get(curr).random = nodeNodeMap.get(curr.random);
            curr = curr.next;
        }



        return nodeNodeMap.get(head);
    }

    public static void printList(Node head) {
        while (head != null) {
            String randomVal = (head.random != null) ? String.valueOf(head.random.val) : "null";
            System.out.println("Node val: " + head.val + ", Random points to: " + randomVal);
            head = head.next;
        }
    }



}
