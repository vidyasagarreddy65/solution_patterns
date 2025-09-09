package LinkedLists;

public class PalindromeLinkedList {



    public static void main(String[] args){

// === Test Case 1: Palindrome (1 → 2 → 2 → 1)
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        boolean result1 = isPalindrome(head1);
        System.out.println("Test Case 1 (Palindrome): " + result1); // Expected: true

        // === Test Case 2: Not a Palindrome (1 → 2)
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        boolean result2 = isPalindrome(head2);
        System.out.println("Test Case 2 (Not Palindrome): " + result2); // Expected: false


    }


    /**
     * O(N) and O(1)
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head){
        // determine the middle
        ListNode slow = head;
        ListNode fast = head;


        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode middle = slow;
        //reverse the linked list of middle and compare
        ListNode reversedSecondHalf= reverseLinkedList(middle);

        while(reversedSecondHalf != null){
            if(head.val != reversedSecondHalf.val){
                 return false;
            }
            head = head.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }

        return true;




    }


    public static ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }



}
