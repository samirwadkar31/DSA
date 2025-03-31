package Trees;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    static Map<TreeNode, TreeNode> parentMap;
    public static void main(String[] args) {
        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        int target = 5 ;
        int k = 2;

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);
        parentMap = new HashMap<>();
        TreeNode targetNode = buildParent(root, parentMap, target);

        System.out.println("TreeNodes at a distance of k from target node: : " + distanceK(root, targetNode, k));
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // step 1 build parent pointer of each node.

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        int dist = 0;

        while(!queue.isEmpty()){

            if(dist == k) break;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();

                if(curr.left != null && !visited.contains(curr.left)){
                    visited.add(curr.left);
                    queue.offer(curr.left);
                }

                if(curr.right != null && !visited.contains(curr.right)){
                    visited.add(curr.right);
                    queue.offer(curr.right);
                }

                if(parentMap.get(curr) != null && !visited.contains(parentMap.get(curr))){
                    visited.add(parentMap.get(curr));
                    queue.offer(parentMap.get(curr));
                }
            }

            dist++;
        }

        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            res.add(queue.poll().val);
        }

        return res;
    }

    public static TreeNode buildParent(TreeNode root, Map<TreeNode, TreeNode> parentMap, int target){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode targetNode = null;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if(node.val == target){
                    targetNode = node;
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

        return targetNode;
    }
}
