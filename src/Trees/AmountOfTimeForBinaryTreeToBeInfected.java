package Trees;

import java.util.*;

public class AmountOfTimeForBinaryTreeToBeInfected {
    public static void main(String[] args) {
        Integer[] arr = {1,5,3,null,4,10,6,9,2};
        int start= 3;

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        System.out.println("Minimum time to infect all nodes: " + amountOfTime(root, start));
    }

    public static int amountOfTime(TreeNode root, int start) {
        // step 1 build parent pointer of each node.

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        TreeNode startNode = buildParent(root, parentMap, start);

        Set<TreeNode> visited = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(startNode);
        visited.add(startNode);
        int dist = 0;

        while(!queue.isEmpty()){
            boolean flag = false;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();

                if(curr.left != null && !visited.contains(curr.left)){
                    visited.add(curr.left);
                    queue.offer(curr.left);
                    flag = true;
                }

                if(curr.right != null && !visited.contains(curr.right)){
                    visited.add(curr.right);
                    queue.offer(curr.right);
                    flag = true;
                }

                if(parentMap.get(curr) != null && !visited.contains(parentMap.get(curr))){
                    visited.add(parentMap.get(curr));
                    queue.offer(parentMap.get(curr));
                    flag = true;
                }
            }

            if(flag) dist++;
        }

        return dist;
    }

    public static TreeNode buildParent(TreeNode root, Map<TreeNode, TreeNode> parentMap, int start){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode startNode = null;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if(node.val == start){
                    startNode = node;
                }

                if(node.left != null){
                    parentMap.put(node.left, node);
                    queue.offer(node.left);
                }
                if(node.right != null){
                    parentMap.put(node.right, node);
                    queue.offer(node.right);
                }
            }

        }

        return startNode;
    }
}
