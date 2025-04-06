package Trees.BFS;

import Trees.BinaryTree;
import Trees.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};

        BinaryTree tree = new BinaryTree();

        TreeNode root = tree.buildTree(arr);

        String ans = serialize(root);
        System.out.println(ans);

        TreeNode res = deserialize(ans);

        tree.printTree(res);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {

        if(root == null) return new String();

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();

                if(curr == null){
                    sb.append('#').append(',');
                    continue;
                }

                sb.append(curr.val).append(',');

                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {

        if(data.length() == 0) return null;

        String[] s = data.split(",");

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.valueOf(s[0]));

        queue.offer(root);

        for(int i = 1; i < s.length - 1; i++){
            TreeNode node = queue.poll();

            if(!s[i].equals("#")){
                node.left = new TreeNode(Integer.valueOf(s[i]));
                queue.offer(node.left);
            }

            if(!s[i + 1].equals("#")){
                node.right = new TreeNode(Integer.valueOf(s[i + 1]));
                queue.offer(node.right);
            }

            i = i + 1;
        }

        return root;
    }
}


