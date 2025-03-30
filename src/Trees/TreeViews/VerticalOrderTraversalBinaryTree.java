package Trees.TreeViews;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.*;

public class VerticalOrderTraversalBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        List<List<Integer>> ans = verticalTraversal(root);

        for(List<Integer> a: ans){
            System.out.print(a + " ");
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        if(root == null) return new ArrayList<>();


        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0, 0));

        while(!queue.isEmpty()){

            Pair temp = queue.poll();

            TreeNode node = temp.node;
            int row = temp.row;
            int col = temp.col;

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new int[]{row, node.val});


            if(temp.node.left != null){
                queue.offer(new Pair(temp.node.left, temp.row + 1, temp.col - 1));
            }

            if(temp.node.right != null){
                queue.offer(new Pair(temp.node.right, temp.row + 1, temp.col + 1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(List<int[]> val: map.values()){
            val.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

            List<Integer> colValues = new ArrayList<>();
            for (int[] v : val) colValues.add(v[1]);
            res.add(colValues);
        }

        return res;
    }
}

class Pair{

    TreeNode node;
    int row;
    int col;

    public Pair(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}