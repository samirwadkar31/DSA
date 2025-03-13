package LinkedList;

public class PartitionList {
    public static void main(String[] args) {
        int[] nodes= {1,4,3,2,5,2};
        int x = 3;

        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        ListNode res = partition(head, x);

        head.printLinkedList(res);
    }

    public static ListNode partition(ListNode head, int x) {

        //doing two partitions 1) smaller than x 2) greate or equal to x

        ListNode smallerdummy1= new ListNode(0);
        ListNode greaterdummy2= new ListNode(0);

        ListNode smaller= smallerdummy1;
        ListNode greater=greaterdummy2;

        ListNode currNode= head;

        while(currNode!=null){
            if(currNode.val<x){
                smaller.next=currNode;
                smaller=currNode;
            }else{
                greater.next=currNode;
                greater=currNode;
            }
            currNode=currNode.next;
        }

        // 0->1->2->2
        // 0->4->3->5

        smaller.next=greaterdummy2.next;
        greater.next=null;

        return smallerdummy1.next;

    }
}
