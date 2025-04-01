package BST;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInputIsBST {
    public static void main(String[] args) {
        Integer[] arr = {5,3,6,2,4,null,7};
        int k = 9;

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTreeBST(arr);

        System.out.println("Is two sum possible for given k? : " + findTarget(root, k));
    }

    public static boolean findTarget(TreeNode root, int k) {

        Set<Integer> set = new HashSet<>();

        return helper(root, k, set);

    }

    public static boolean helper(TreeNode root, int k, Set<Integer> set){

        if(root == null) return false;

        if(set.contains(k - root.val)) return true;
        else set.add(root.val);

        boolean left = helper(root.left, k, set);

        boolean right = helper(root.right, k, set);

        return left || right;
    }

}
