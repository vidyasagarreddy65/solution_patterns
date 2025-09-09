package LinkedLists;

public class ReverseLinkedList {
    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//1 -> 2 -> 3 -> 4 -> 5 -> null



        ListNode curr = head;

        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr =  temp;
        }

        while(prev!= null){
            System.out.println(""+prev.val);

            prev = prev.next;
        }









    }







}
