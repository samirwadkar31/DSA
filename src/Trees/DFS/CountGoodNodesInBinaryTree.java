package Trees.DFS;

import Trees.BinaryTree;
import Trees.TreeNode;

public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {3,1,8,3,null,1,4};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        System.out.println("Good nodes count: " + goodNodes(root));
    }

    public static int goodNodes(TreeNode root) {

        int max=Integer.MIN_VALUE;
        int[] count= new int[1];
        helper(root, max, count);

        return count[0];

    }

    public static void helper(TreeNode root, int max, int[] count){
        if(root==null) return;

        if(max<=root.val){
            max=root.val;
            count[0]++;
        }

        helper(root.left, max, count);
        helper(root.right, max, count);

    }
}
