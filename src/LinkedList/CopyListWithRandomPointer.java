package LinkedList;

import java.util.HashMap;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {
//        int[] nodes= [[7,null],[13,0],[11,4],[10,2],[1,0]];
//
//        ListNode head= new ListNode(nodes[0]);
//
//        head.buildLinkedList(head, nodes);
//
//        ListNode res = copyRandomList(head);
//
//        head.printLinkedList(res);
    }

    public static ListNode copyRandomList(ListNode head) {

        if(head == null) return null;

        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode currNode = head;

        while(currNode!=null){
            ListNode newNode = new ListNode(currNode.val);
            map.put(currNode, newNode);
            currNode = currNode.next;
        }

        currNode = head;
        while(currNode != null){

            ListNode newNode = map.get(currNode);

            newNode.next = map.get(currNode.next);
            newNode.random = map.get(currNode.random);

            currNode = currNode.next;
        }

        return map.get(head);
    }
}
