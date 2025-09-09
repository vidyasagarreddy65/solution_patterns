package LinkedLists;

public class DetectCycleInLinkedList {


    public static void main(String[] args){
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;


        boolean hasCycle = hasCycle(head);
        System.out.println("Has cycle? " + hasCycle); // expected: true

// === Test Case 2: No cycle ===
        ListNode head2 = new ListNode(1);
        ListNode node22 = new ListNode(2);

        head2.next = node22;
        node22.next = null; // no cycle

        System.out.println("Test Case 2 (No Cycle): " + hasCycle(head2)); // expected: false

    }

    /**
     * O(n)
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;

            }
        }

        return false;

    }
}
