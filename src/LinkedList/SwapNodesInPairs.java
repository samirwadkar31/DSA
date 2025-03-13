package LinkedList;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        int[] nodes= {1,2,3,4};

        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        ListNode res = swapPairs(head);

        head.printLinkedList(res);
    }

    public static ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);

        dummy.next=head;
        ListNode point=dummy;


        while(point.next!=null && point.next.next!=null){

            ListNode swap1= point.next;
            ListNode swap2= point.next.next;

            swap1.next=swap2.next;
            swap2.next=swap1;

            point.next=swap2;
            point=swap1;

        }

        return dummy.next;

    }
}
