package BST;

import LinkedList.ListNode;
import Trees.BinaryTree;
import Trees.TreeNode;

public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};

        ListNode head = new ListNode(arr[0]);

        head.buildLinkedList(head,arr);

        BinaryTree tree = new BinaryTree();

        TreeNode ans = sortedListToBST(head);
        tree.printTreeBST(ans); //prints level wise
    }

    public static TreeNode sortedListToBST(ListNode head) {

        if(head==null) return null;

        if(head.next==null) return new TreeNode(head.val);

        ListNode slow= head;
        ListNode fast= head;
        ListNode slowprev= null;

        while(fast!=null && fast.next!=null){
            slowprev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        TreeNode node= new TreeNode(slow.val);

        slowprev.next=null;
        node.left= sortedListToBST(head);
        node.right= sortedListToBST(slow.next);

        return node;

    }
}
