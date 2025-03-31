package Trees.DFS;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {
        Integer[] arr = {1,2,2,3,4,4,3};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        System.out.println("Is tree symmetric?: " + isSymmetricIterative(root));
        System.out.println("Is tree symmetric?: " + isSymmetricRecursive(root.left, root.right));
    }
    //1) Iterative
    public static boolean isSymmetricIterative(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode l= queue.poll();
            TreeNode r= queue.poll();

            if(l==null && r==null){
                continue;
            }
            if(l==null || r==null){
                return false;
            }
            if(l.val!=r.val){
                return false;
            }

            queue.offer(l.left);
            queue.offer(r.right);
            queue.offer(l.right);
            queue.offer(r.left);

        }
        return true;
    }
    //2) recursive
    public static boolean isSymmetricRecursive(TreeNode left, TreeNode right){
        if(left==null && right==null)
            return true;

        if(left==null || right==null)
            return false;

        if(left.val!=right.val)
            return false;

        return isSymmetricRecursive(left.left, right.right) && isSymmetricRecursive(left.right, right.left);
    }
}
