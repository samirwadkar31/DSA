package BST;

import Trees.BinaryTree;
import Trees.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Integer[] arr = {6,2,8,0,4,7,9,null,null,3,5};
        int p =5;
        int q =8;

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTreeBST(arr);

        TreeNode ans = lowestCommonAncestor(root, p, q);

        System.out.println("lowest Common Ancestor of given nodes p & q is: " + ans.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {

        while(root!=null){
            if(p<root.val && q<root.val){
                root=root.left;
            }else if(p>root.val && q>root.val){
                root=root.right;
            }else{
                return root;
            }
        }
        return null;
    }
}
