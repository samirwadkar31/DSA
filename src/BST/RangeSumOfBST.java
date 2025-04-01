package BST;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.sql.SQLOutput;

public class RangeSumOfBST {
    public static void main(String[] args) {
        Integer[] arr = {10,5,15,3,7,null,18};
        int low =7;
        int high =15;

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTreeBST(arr);

        System.out.println("Range sum of BST is: " + rangeSumBST(root, low, high));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;

        if (low <= root.val && root.val <= high) {
            sum += root.val;
        }

        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }

        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }
}
