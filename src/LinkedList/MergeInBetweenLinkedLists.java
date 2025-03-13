package LinkedList;

public class MergeInBetweenLinkedLists {
    public static void main(String[] args) {
        int[] list1 = {10,1,13,6,7,9,5};
        int[] list2 = {1000000,1000001,1000002};
        int a = 3;
        int b = 5;

        ListNode l1head= new ListNode(list1[0]);
        ListNode l2head= new ListNode(list2[0]);

        l1head.buildLinkedList(l1head, list1);
        l2head.buildLinkedList(l2head, list2);

        ListNode res = mergeInBetween(l1head, a,b, l2head);

        l1head.printLinkedList(res);
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode currentNode = list1;
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        int position = 0;

        while(currentNode != null){
            if(position == a - 1){
                temp1 = currentNode;
            }
            if(position == b + 1){
                temp2 = currentNode;
            }
            currentNode = currentNode.next;
            position++;
        }
        ListNode newNode = list2;

        while(newNode != null){
            if(newNode.next == null){
                newNode.next = temp2;
                break;
            }
            newNode = newNode.next;
        }
        temp1.next = list2;
        return list1;
    }
}
