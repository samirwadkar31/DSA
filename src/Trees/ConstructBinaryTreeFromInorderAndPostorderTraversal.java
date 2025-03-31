package Trees;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        int[] arr1 = {9,3,15,20,7};
        int[] arr2 = {9,15,7,20,3};


        BinaryTree tree = new BinaryTree();

        TreeNode ans = buildTreeQuestion(arr1, arr2);


        tree.printTree(ans);
    }

    static public int index;

    public static TreeNode buildTreeQuestion(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        index= postorder.length-1;
        return printTreeFromInorderAndPostorder(map, postorder, 0, inorder.length-1);

    }

    public static TreeNode printTreeFromInorderAndPostorder(HashMap<Integer, Integer> map, int[] postorder, int start, int end){
        if(start > end){
            return null;
        }

        int rootValue= postorder[index];
        index--;
        TreeNode root= new TreeNode(rootValue);

        int rootindex= map.get(rootValue);

        root.right = printTreeFromInorderAndPostorder(map, postorder, rootindex+1, end);
        root.left = printTreeFromInorderAndPostorder(map, postorder, start, rootindex-1);

        return root;
    }
}
