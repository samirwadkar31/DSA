package LinkedList;

public class RemoveNodesFromLinkedList {
    public static void main(String[] args) {
        int[] nodes= {15,2,13,3,8};

        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        ListNode res = removeNodes(head);

        head.printLinkedList(res);
    }

    public static ListNode removeNodes(ListNode head) {

        //Reverse then remove and again reverse :)

        if(head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        ListNode newHead = prev;
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        int max = Integer.MIN_VALUE;

        while(newHead!=null){
            if(newHead.val >= max){
                max = newHead.val;
                pointer.next = newHead;
                pointer = newHead;
            }

            newHead = newHead.next;
        }

        pointer.next = null;

        prev = null;
        curr = dummy.next;

        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;

    }
}
