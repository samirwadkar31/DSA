package Trees.DFS;

import Trees.BinaryTree;
import Trees.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {4,2,7,1,3,6,9};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        TreeNode ans = invertTree(root);

        System.out.println("Inverted tree: ");
        tree.printTree(ans);
    }

    public static TreeNode invertTree(TreeNode root) {
        return invertBT(root);
    }

    public static TreeNode invertBT(TreeNode node){
        if(node==null){
            return node;
        }

        TreeNode left = invertBT(node.left);
        TreeNode right = invertBT(node.right);

        node.left=right;
        node.right=left;

        return node;
    }
}
