package LinkedList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode random;

    public ListNode(){
        this.next = null;
        this.random = null;
    }
    public ListNode(int val){
        this.val= val;
    }

    public ListNode(ListNode next){
        this.next= next;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public void buildLinkedList(ListNode head, int[] nodes){
        ListNode temp= head;

        for(int i=1; i<nodes.length; i++){
            temp.next= new ListNode(nodes[i]);
            temp=temp.next;

        }
    }

    public void printLinkedList(ListNode res){
        while(res!= null){
            System.out.print(res.val + "->");
            res= res.next;
        }
    }
}
