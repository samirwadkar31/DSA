package BST;

import Trees.BinaryTree;
import Trees.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};

        BinaryTree tree = new BinaryTree();

        TreeNode ans = sortedArrayToBST(arr);
        tree.printTreeBST(ans); //prints level wise
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length-1);
    }

    public static TreeNode helper(int[] nums, int start, int end){
        if(start>end) return null;

        int mid= start+(end-start)/2;

        TreeNode node= new TreeNode(nums[mid]);

        node.left= helper(nums, start, mid-1);
        node.right= helper(nums, mid+1, end);

        return node;
    }
}
