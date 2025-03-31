package Trees.DFS;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        Integer[] arr1 = {3,5,1,6,2,9,8,null,null,7,4};
        Integer[] arr2 = {3,5,1,6,7,4,2,null,null,null,null,null,null,9,8};

        BinaryTree tree = new BinaryTree();

        TreeNode node1 = tree.buildTree(arr1);
        TreeNode node2 = tree.buildTree(arr2);

        System.out.println("Are they having same leaf-nodes?: " + leafSimilar(node1, node2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> tempList1= new ArrayList<>();
        List<Integer> tempList2= new ArrayList<>();

        helper(root1, tempList1);
        helper(root2, tempList2);

        if(tempList1.size()!=tempList2.size()) return false;

        for(int i=0; i<tempList1.size(); i++){
            if(!tempList1.get(i).equals(tempList2.get(i))) return false;
        }

        return true;
    }


    public static void helper(TreeNode root, List<Integer> tempList){
        if(root==null) return;

        if(root.left==null && root.right==null) tempList.add(root.val);

        helper(root.left, tempList);
        helper(root.right, tempList);

        return;
    }
}
