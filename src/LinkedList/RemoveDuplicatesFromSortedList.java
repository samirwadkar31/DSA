package LinkedList;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        int[] nodes= {1,1,1,3,3,4,4,5};

        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        ListNode res = deleteDuplicates(head);

        head.printLinkedList(res);
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode currentNode = head;

        while(currentNode != null){
            if(currentNode.next != null && currentNode.val == currentNode.next.val){
                currentNode.next = currentNode.next.next;
            }else{
                currentNode = currentNode.next;
            }


        }


        return head;

    }
}
