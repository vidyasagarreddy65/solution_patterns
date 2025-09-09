package LinkedLists;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args){

// List: 1 → 2 → 3 → 4 → 5, n = 2 → remove node with value 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 3;

        ListNode newHead = removeNthFromEnd(head, n);
        printList(newHead); // Expected Output: 1 → 2 → 3 → 5

    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n){

        ListNode slow = head;
        ListNode fast = head;


        for (int i = 0; i <n ; i++) {
            fast = fast.next;
        }



        ListNode dummy = new ListNode(-1);

        dummy.next = head;


        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;



    }


}
