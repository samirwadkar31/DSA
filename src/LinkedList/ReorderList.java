package LinkedList;

public class ReorderList {
    public static void main(String[] args) {
        int[] nodes= {1,2,3,4,5};


        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        ListNode res = reorderList(head);

        head.printLinkedList(res);
    }

    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }


        ListNode p1 = head, p2 = prev;

        while (p2 != null) {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }

        return head;
    }
}
