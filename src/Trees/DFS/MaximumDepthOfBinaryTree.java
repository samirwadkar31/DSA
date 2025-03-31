package Trees.DFS;

import Trees.BinaryTree;
import Trees.TreeNode;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        System.out.println("Max depth of binary tree is: " + maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {

        return findDepth(root);
    }

    public static int findDepth(TreeNode node){
        if(node==null){
            return 0;
        }
        int left_depth = maxDepth(node.left);
        int right_depth = maxDepth(node.right);

        int max_depth= Math.max(left_depth, right_depth)+1;

        return max_depth;
    }
}
