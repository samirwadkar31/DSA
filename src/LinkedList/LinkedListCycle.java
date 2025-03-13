package LinkedList;


import java.util.List;

public class LinkedListCycle {

    public static void main(String[] args) {
        int[] nodes= {3,2,0,-4};

        ListNode head= new ListNode(0);

        head.buildLinkedList(head, nodes);
        ListNode temp= head;
        ListNode cycleNode= null;

        for(int i=1; i<nodes.length; i++){
            temp.next= new ListNode(nodes[i]);
            temp=temp.next;
            if(i==1){
                cycleNode= temp;
            }
        }
        temp.next=cycleNode;

        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {

        if(head==null || head.next==null){
            return false;
        }

        ListNode slow= head;
        ListNode fast= head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
