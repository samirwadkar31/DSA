package LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] nodes= {1,2,3,4,5};

        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        ListNode res = reverseList(head);

        head.printLinkedList(res);
    }

    public static ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode currentNode = head;

        while(currentNode != null){
            ListNode nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;
        }

        return prev;
    }
}
