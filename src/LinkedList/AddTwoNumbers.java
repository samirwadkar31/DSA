package LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] list1 = {2,4,3};
        int[] list2 = {5,6,4};

        ListNode l1head= new ListNode(list1[0]);
        ListNode l2head= new ListNode(list2[0]);

        l1head.buildLinkedList(l1head, list1);
        l2head.buildLinkedList(l2head, list2);


        ListNode res = addTwoNumbers(l1head, l2head);

        l1head.printLinkedList(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l2==null){
            return l1;
        }

        if(l1==null){
            return l2;
        }

        ListNode dummy = new ListNode(0);
        ListNode ans =dummy;

        int carry=0;
        int sum=0;

        while(l1!=null || l2!=null){
            sum=sum+carry;

            if(l1!=null){
                sum=sum+l1.val;
                l1=l1.next;
            }

            if(l2!=null){
                sum=sum+l2.val;
                l2=l2.next;
            }

            carry=sum/10;
            sum=sum%10;
            ans.next= new ListNode(sum);
            ans=ans.next;
            sum=0;

        }

        if(carry==1){
            ans.next= new ListNode(1);
        }

        return dummy.next;

    }
}
