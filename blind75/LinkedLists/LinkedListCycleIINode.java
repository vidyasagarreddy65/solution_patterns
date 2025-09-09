package com.company.blind75.LinkedLists;

public class LinkedListCycleIINode {


    public static void main(String[] args){

        // === Test Case 1: Cycle exists at node with value 2 ===
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head1.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;

        ListNode startOfCycle1 = detectCycle(head1);
        System.out.println("Cycle starts at: " + (startOfCycle1 != null ? startOfCycle1.val : "null")); // expected: 2

        // === Test Case 2: No cycle ===
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        ListNode startOfCycle2 = detectCycle(head2);
        System.out.println("Cycle starts at: " + (startOfCycle2 != null ? startOfCycle2.val : "null")); // expected: null


    }

    public static ListNode detectCycle(ListNode head){

        ListNode slow = head;

        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                //
// Cycle detected. Now find the start node.
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr; // This is the start of the cycle


            }
        }

        return null;



    }



}
