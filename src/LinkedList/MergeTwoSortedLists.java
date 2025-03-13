package LinkedList;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] list1 = {1,2,4};
        int[] list2 = {1,3,4};

        ListNode l1head= new ListNode(list1[0]);
        ListNode l2head= new ListNode(list2[0]);

        l1head.buildLinkedList(l1head, list1);
        l2head.buildLinkedList(l2head, list2);


        ListNode res = mergeTwoLists(l1head, l2head);

        l1head.printLinkedList(res);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode dummyNode= new ListNode(-1);
        ListNode current= dummyNode;

        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                current.next=list1;
                current=list1;
                list1=list1.next;
            }else{
                current.next=list2;
                current=list2;
                list2=list2.next;
            }

            if(list1==null){
                current.next=list2;
            }else if(list2==null){
                current.next=list1;
            }
        }
        return dummyNode.next;
    }
}
