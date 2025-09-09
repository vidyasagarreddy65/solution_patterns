package com.company.blind75.LinkedLists;

import java.util.List;


/**
 * you must do this in-place, without modifying the node values (only rearrange next pointers).
 */
public class ReorderLinkedList {

    public static void main(String[] args){


        // Test Case: 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);  // Should modify list to: 1 → 5 → 2 → 4 → 3

        // Print reordered list
        printList(head);

    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " → ");
            head = head.next;
        }
        System.out.println("null");
    }


    public static void reorderList(ListNode head){

        ListNode slow = head;
        ListNode fast = head;


        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }


        //reverse second half

        ListNode second = reverseLinkedList(slow);

        // Test Case: 1 → 2 → 3 → 4 → 5


        ListNode first = head;

        //5 → 4 → 3
        while(second!= null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next= temp1;
            first = temp1;
            second= temp2;

        }







    }


    public static ListNode reverseLinkedList(ListNode head){

        ListNode prev = null;

        while(head != null){
                ListNode temp = head.next;
                head.next = prev;
                prev= head;
                head = temp;
        }

        return prev;


    }




}
