package Trees;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] arr1 = {3,9,20,15,7};
        int[] arr2 = {9,3,15,20,7};


        BinaryTree tree = new BinaryTree();

        TreeNode ans = buildTreeQuestion(arr1, arr2);


        tree.printTree(ans);
    }

    public static HashMap<Integer, Integer> inorderMap;
    public static int preorderIndex;

    public static TreeNode buildTreeQuestion(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        preorderIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return constructTree(preorder, 0, inorder.length - 1);
    }
    public static TreeNode constructTree(int[] preorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderMap.get(rootValue);

        root.left = constructTree(preorder, inorderStart, rootIndex - 1);
        root.right = constructTree(preorder, rootIndex + 1, inorderEnd);

        return root;
    }
}
