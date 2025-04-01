package BST;

import Trees.BinaryTree;
import Trees.TreeNode;

public class InsertIntoBinarySearchTree {
    public static void main(String[] args) {
        Integer[] arr = {4,2,7,1,3,6,9,11};
        int val = 0;

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTreeBST(arr);
        tree.printTreeBST(root);

        System.out.println();

        TreeNode ans = insertIntoBST(root, val);
        tree.printTreeBST(ans); //prints level wise
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {

        if(root==null) return new TreeNode(val);

        TreeNode curr= root;

        while(curr!=null){

            if(val<curr.val && curr.left==null){
                TreeNode node= new TreeNode(val);
                curr.left=node;
                return root;
            }

            if(val>curr.val && curr.right==null){
                TreeNode node= new TreeNode(val);
                curr.right=node;
                return root;
            }

            if(val<curr.val){
                curr=curr.left;
            }else{
                curr=curr.right;
            }
        }

        return root;

    }
}
