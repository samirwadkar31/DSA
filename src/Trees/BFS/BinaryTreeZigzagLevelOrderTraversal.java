package Trees.BFS;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        List<List<Integer>> ans = zigzagLevelOrder(root);

        for(List<Integer> a: ans){
            System.out.print(a + " ");
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root==null){
            return new ArrayList<>();
        }

        List<List<Integer>> zigzag = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        boolean reverse = false;
        deque.offer(root);

        while(!deque.isEmpty()){
            int levelsize=deque.size();
            ArrayList<Integer> level= new ArrayList<>();
            for(int i=0; i<levelsize; i++){
                if(reverse){
                    TreeNode currentNode= deque.removeLast();
                    if(currentNode.right!=null){
                        deque.addFirst(currentNode.right);
                    }
                    if(currentNode.left!=null){
                        deque.addFirst(currentNode.left);
                    }
                    level.add(currentNode.val);
                }
                if(!reverse){
                    TreeNode currentNode= deque.removeFirst();
                    if(currentNode.left!=null){
                        deque.addLast(currentNode.left);
                    }
                    if(currentNode.right!=null){
                        deque.addLast(currentNode.right);
                    }
                    level.add(currentNode.val);
                }
            }

            reverse=!reverse;
            zigzag.add(level);

        }
        return zigzag;
    }


}
