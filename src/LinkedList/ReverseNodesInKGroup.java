package LinkedList;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        int[] nodes= {1,2,3,4,5};
        int k = 3;

        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        ListNode res = reverseKGroup(head, k);

        head.printLinkedList(res);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer != null) {
            ListNode node = pointer;

            for (int i = 0; i < k && node != null; i++) {
                node = node.next;
            }

            if (node == null) break;

            ListNode prev = null, curr = pointer.next, next = null;
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode tail = pointer.next;
            tail.next = curr;
            pointer.next = prev;
            pointer = tail;
        }
        return dummy.next;
    }
}
