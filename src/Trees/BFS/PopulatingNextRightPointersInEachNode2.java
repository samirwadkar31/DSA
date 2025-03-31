package Trees.BFS;

import Trees.BinaryTree;
import Trees.TreeNode;

public class PopulatingNextRightPointersInEachNode2 {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        TreeNode ans = connect(root);

        tree.printTree(ans);
        
    }

    public static TreeNode connect(TreeNode root) {
        if(root==null) return root;

        TreeNode dummy= new TreeNode(0);
        TreeNode prev=dummy;
        TreeNode curr=root;

        while(curr!=null){

            if(curr.left!=null){
                prev.next=curr.left;
                prev=curr.left;
            }

            if(curr.right!=null){
                prev.next=curr.right;
                prev=curr.right;
            }

            curr=curr.next;

            if(curr==null){  // end of every level where curr becomes null
                curr=dummy.next; //for every level new curr is dummy.next (new level first TreeNode)
                dummy.next=null; // reset dummy at every new level
                prev=dummy;
            }
        }

        return root;
    }
}
