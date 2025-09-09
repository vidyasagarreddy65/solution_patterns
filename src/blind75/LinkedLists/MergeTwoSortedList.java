package LinkedLists;

public class MergeTwoSortedList {


    public static void main(String[] args){

            // First sorted list: 1 -> 2 -> 4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode merged = merged(l1, l2);
        while (merged != null) {
            System.out.print(merged.val + " -> ");
            merged = merged.next;
        }
        System.out.println("null");
    }

    //Note dummy node doesnt create a new space

    /**
     * O(M+N) and O(1)
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode merged(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next;


    }


}
