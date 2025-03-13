package LinkedList;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        int[] nodes= {2,1,3,5,6,4,7};
        // First node is always odd and next to it is even. do not confuse with node value. use odd even endices.
        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        ListNode res = oddEvenList(head);

        head.printLinkedList(res);
    }

    public static ListNode oddEvenList(ListNode head) {

        if(head==null) return null;

        ListNode dummyOdd= new ListNode(0);
        ListNode dummyEven= new ListNode(0);
        ListNode odd= dummyOdd;
        ListNode even=dummyEven;

        ListNode curr=head;
        int size=1;

        while(curr!=null){
            curr=curr.next;
            size++;
        }

        curr=head;
        for(int i=1; i<=size; i++){
            if(i%2!=0){
                odd.next=curr;
                odd=curr;
            }else{
                even.next=curr;
                even=curr;
            }

            if(curr.next==null) break;
            curr=curr.next;

        }

        odd.next=dummyEven.next;
        even.next=null;

        return dummyOdd.next;

    }
}
