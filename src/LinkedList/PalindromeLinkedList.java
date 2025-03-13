package LinkedList;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        int[] nodes= {1,2,2,1};  // even length
//        int[] nodes= {1,2,3,2,1};  // odd length

        ListNode head= new ListNode(nodes[0]);

        head.buildLinkedList(head, nodes);

        boolean res = isPalindrome(head);

        System.out.println("Is it palindrome list? : " + res);
    }

    public static boolean isPalindrome(ListNode head) {

        if(head.next == null) return true;


        // head=[1,3,4,5,4,3,1]

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) slow = slow.next; // for odd length break in slow.next

        ListNode curr = slow;              // for even length break in slow
        ListNode prev = null;


        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        ListNode p1 = head;
        ListNode p2 = prev;

        while(p2 != null){
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;

    }
}
