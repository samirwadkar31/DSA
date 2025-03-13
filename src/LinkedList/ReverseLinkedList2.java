package LinkedList;

public class ReverseLinkedList2 {
    public static void main(String[] args) {
        int[] nodes= {1,2,3,4,5};
        int left = 2, right = 4;

        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        ListNode res = reverseBetween(head, left, right);

        head.printLinkedList(res);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || left == right){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode leftPrev = dummy;

        for (int i = 0; i < left-1; i++) {
            leftPrev = leftPrev.next;
        }

        ListNode prev= null;
        ListNode currentNode= leftPrev.next;
        ListNode startPoint= leftPrev.next;

        for(int i=0; i<right-left+1;i++){
            ListNode nextNode= currentNode.next;
            currentNode.next=prev;
            prev=currentNode;
            currentNode=nextNode;
        }

        leftPrev.next=prev;
        startPoint.next= currentNode;

        return dummy.next;
    }
}
