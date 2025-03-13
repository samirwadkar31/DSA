package LinkedList;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        int[] nodes= {1,1,1,3,3,1,4,4,5};
        int val = 1;

        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        ListNode res = removeElements(head, val);

        head.printLinkedList(res);
    }

    public static ListNode removeElements(ListNode head, int val) {

        if(head==null){
            return null;
        }

        ListNode dummynode= new ListNode(0);
        dummynode.next=head;
        ListNode curr= dummynode;

        while(curr.next!=null){

            if(curr.next.val==val){
                curr.next=curr.next.next;
            }else{
                curr=curr.next;
            }
        }
        return dummynode.next;
    }
}
