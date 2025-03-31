package Trees.DFS;

import Trees.BinaryTree;
import Trees.TreeNode;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {1,2,2,3,3,null,null,4,4};
        //output: false
        //[3,9,20,null,null,15,7]
        //output: true

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        System.out.println("Is tree balanced?: " + isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {

        return helper(root) != -1;
    }

    public static int helper(TreeNode root){
        if(root==null){
            return 0;
        }


        int left = helper(root.left);
        if(left==-1){
            return -1;
        }
        int right = helper(root.right);
        if(right==-1){
            return -1;
        }

        if(Math.abs(left-right)>1){
            return -1;
        }

        return 1+ Math.max(left, right);

    }
}
