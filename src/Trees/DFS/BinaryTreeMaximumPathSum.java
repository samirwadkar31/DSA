package Trees.DFS;

import Trees.BinaryTree;
import Trees.TreeNode;

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Integer[] arr = {-10,9,20,null,null,15,7};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        System.out.println("Maximum path sum: " + maxPathSum(root));
    }

    static int maxSum =Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxSum;
    }

    public static int findMaxPathSum(TreeNode root){

        if(root==null){
            return 0;
        }

        int left = Math.max(findMaxPathSum(root.left), 0);
        int right = Math.max(findMaxPathSum(root.right), 0);

        int currentSum= left + right+ root.val;
        maxSum= Math.max(currentSum, maxSum);

        return Math.max(left,right) + root.val;

    }
}
