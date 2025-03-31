package Trees.DFS;

import Trees.BinaryTree;
import Trees.TreeNode;

public class SameTree {
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3};
        Integer[] arr2 = {1,2,2};
        int start= 3;

        BinaryTree tree = new BinaryTree();

        TreeNode node1 = tree.buildTree(arr1);
        TreeNode node2 = tree.buildTree(arr2);

        System.out.println("Are they same trees?: " + isSameTree(node1, node2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return checkSameTree(p,q);
    }

    public static boolean checkSameTree(TreeNode left, TreeNode right){
        if(left==null && right==null)
            return true;

        if(left==null || right==null)
            return false;

        if(left.val!=right.val)
            return false;

        return checkSameTree(left.left, right.left) && checkSameTree(left.right, right.right);
    }


}
