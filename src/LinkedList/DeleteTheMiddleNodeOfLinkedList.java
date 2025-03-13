package LinkedList;

public class DeleteTheMiddleNodeOfLinkedList {
    public static void main(String[] args) {
        int[] nodes= {1,2,3,4,5};

        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        ListNode res = deleteMiddle(head);

        head.printLinkedList(res);
    }

    public static ListNode deleteMiddle(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = prev.next.next;

        return head;
    }
}
