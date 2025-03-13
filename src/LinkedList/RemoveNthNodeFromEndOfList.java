package LinkedList;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        int[] nodes= {1,2,3,4,5};
        int n = 3;

        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        ListNode res = removeNthFromEnd(head, n);

        head.printLinkedList(res);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy= new ListNode();
        dummy.next=head;

        ListNode slow= dummy;
        ListNode fast= dummy;

        for(int i=1; i<=n; i++){
            fast= fast.next;
        }

        if(fast.next==null){
            head= head.next;
            return head;
        }

        while(fast.next!=null && fast!=null){
            slow=slow.next;
            fast= fast.next;
        }

        slow.next= slow.next.next;

        return dummy.next;

    }
}
