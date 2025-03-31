package Trees.BFS;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,null,5,6,null,null,7};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        System.out.println("Leftmost node value in a tree: " + findBottomLeftValueBFS(root));
        System.out.println("Leftmost node value in a tree: " + findBottomLeftValueDFS(root));
    }

    public static int findBottomLeftValueBFS(TreeNode root) {

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (i == 0) result = node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return result;
    }

    static int maxHeight;
    static int ans;
    public static int findBottomLeftValueDFS(TreeNode root) {

        maxHeight= -1;
        ans=0;
        helper(root, 1);
        return ans;
    }

    private static void helper(TreeNode root, int height){

        if(root==null) return;

        if(root.left == null && root.right == null && height > maxHeight){
            maxHeight= height;
            ans=root.val;
        }

        helper(root.left, height+1);
        helper(root.right, height+1);
    }
}
