package LinkedList;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        int[] list1 = {4, 1, 8, 4, 5};
        int[] list2 = {5, 6, 1};

        // Convert arrays into linked lists
        ListNode headA = createLinkedList(list1);
        ListNode headB = createLinkedList(list2);

        // Find the node with value 8 in list1 and set it as intersection
        ListNode intersectionNode = findNode(headA, 8);
        appendIntersection(headB, intersectionNode);

        // Finding intersection
        ListNode result = getIntersectionNode(headA, headB);

        // Printing the result
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection found.");
        }
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode curr= headA;
        ListNode p1= headA;
        ListNode p2= headB;
        int l1= 0;

        while(curr!=null){
            curr=curr.next;
            l1++;
        }

        curr= headB;
        int l2=0;

        while(curr!=null){
            curr=curr.next;
            l2++;
        }

        if(l1>l2){
            int diff= l1-l2;
            ListNode node=headA;

            while(diff!=0){
                node=node.next;
                diff--;
            }

            p1=node;
        }

        if(l2>l1){
            int diff= l2-l1;
            ListNode node=headB;

            while(diff!=0){
                node=node.next;
                diff--;
            }
            p2=node;
        }

        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }

        return p1;
    }

    // Method to find a node with a given value
    public static ListNode findNode(ListNode head, int value) {
        while (head != null) {
            if (head.val == value) return head;
            head = head.next;
        }
        return null;
    }

    // Method to create a linked list from an array
    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Method to append an intersection node to a list
    public static void appendIntersection(ListNode head, ListNode intersectionNode) {
        while (head.next != null) {
            head = head.next;
        }
        head.next = intersectionNode;
    }
}
