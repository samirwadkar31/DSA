package LinkedList;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        int[] nodes= {1,2,3,4,5};


        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        ListNode res = middleNode(head);

        head.printLinkedList(res);
    }

    public static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }
}
