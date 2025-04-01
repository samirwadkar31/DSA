package BST;

import Trees.BinaryTree;
import Trees.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
    public static void main(String[] args) {
        Integer[] arr = {543, 384, 652, null, 445, null, 699};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTreeBST(arr);

        System.out.println("Minimum Absolute Difference In a BST: " + getMinimumDifference(root));
    }

    static int min = Integer.MAX_VALUE;
    static Integer prev = null;


    public static int getMinimumDifference(TreeNode root) {

        if (root == null){
            return min;
        }

        getMinimumDifference(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference(root.right);

        return min;

    }
}
