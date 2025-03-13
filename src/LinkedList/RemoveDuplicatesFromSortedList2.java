package LinkedList;

public class RemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {
        int[] nodes= {1,2,3,3,4,4,5};

        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        ListNode res = deleteDuplicates(head);

        head.printLinkedList(res);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy= new ListNode(-1);
        dummy.next=head;
        ListNode currentNode= dummy;

        while(currentNode!=null){

            if(currentNode.next!=null && currentNode.next.next!=null && currentNode.next.val==currentNode.next.next.val){
                ListNode temp = currentNode.next;
                while(temp.next!=null && temp.val==temp.next.val){
                    temp=temp.next;
                }
                currentNode.next = temp.next;

            }else{
                currentNode=currentNode.next;
            }

        }
        return dummy.next;
    }
}
