package LinkedList;

public class RotateList {
    public static void main(String[] args) {

    }

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int size = 1;
        ListNode fast=head;
        ListNode slow = head;

        while(fast.next!=null){
            size++;
            fast = fast.next;
        }

        if(size<=k) k=k%size;

        for(int i=1;i<size-k;i++)
            slow = slow.next;


        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;

    }
}
