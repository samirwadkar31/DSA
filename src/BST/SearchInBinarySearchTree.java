package BST;

import Trees.BinaryTree;
import Trees.TreeNode;

public class SearchInBinarySearchTree {
    public static void main(String[] args) {
        Integer[] arr = {4,2,7,1,3};
        int val = 2;

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTreeBST(arr);
        tree.printTreeBST(root);

        System.out.println();

        TreeNode ans = searchBST(root, val);
        tree.printTreeBST(ans); //prints level wise
    }

    public static TreeNode searchBST(TreeNode root, int val) {

        if(root.val==val) return root;

        while(root!=null){

            if(root.val==val){
                return root;
            }else if(root.val<val){
                root=root.right;
            }else{
                root=root.left;
            }

        }

        return null;

    }
}
