package Trees.DFS;

import Trees.BinaryTree;
import Trees.TreeNode;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,null,5,6,null,null,7};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        System.out.println("Diameter Of Binary Tree Is: " + diameterOfBinaryTree(root));
    }

    static int maxDiameter=0;
    public static int diameterOfBinaryTree(TreeNode root) {
        findDiameterOfBT(root);
        return maxDiameter;
    }

    public static int findDiameterOfBT(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = findDiameterOfBT(root.left);
        int right = findDiameterOfBT(root.right);

        int diameter= left+right;
        maxDiameter= Math.max(diameter, maxDiameter);

        return 1 + Math.max(left,right);

    }
}
