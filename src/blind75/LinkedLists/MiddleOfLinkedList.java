package LinkedLists;

public class MiddleOfLinkedList {
    public static void main(String[] args){
        // Test Case 1: Odd length list -> 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode mid1 = middleNode(head1);
        System.out.println("Middle (odd): " + mid1.val); // Expected: 3

        // Test Case 2: Even length list -> 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);

        ListNode mid2 = middleNode(head2);
        System.out.println("Middle (even): " + mid2.val); // Expected: 4

    }

    /**
     * O(N)
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
}
