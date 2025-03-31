package Trees.DFS;

import Trees.BinaryTree;
import Trees.TreeNode;

public class LowestCommonAncestorOfBinaryTree {

    public static void main(String[] args) {
        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        int p =5;
        int q =8;

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        TreeNode ans = lowestCommonAncestor(root, p, q);

        System.out.println("lowest Common Ancestor of given nodes p & q is: " + ans.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {

        if(root == null) return null;

        if( root.val == p || root.val == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);

        if(left == null){
            return right;
        }else if (right == null){
            return left;
        }else{
            return root;
        }

    }
}
