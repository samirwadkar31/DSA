package Trees.BFS;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {
    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        List<List<Integer>> ans = levelOrderBottom(root);

        for(List<Integer> a: ans){
            System.out.print(a + " ");
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root==null){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelsize= queue.size();
            ArrayList<Integer> levelList = new ArrayList<>();
            for(int i=0; i<levelsize; i++){
                TreeNode currentNode= queue.poll();
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
                levelList.add(currentNode.val);
            }
            result.add(0, levelList);
        }
        return result;
    }
}
