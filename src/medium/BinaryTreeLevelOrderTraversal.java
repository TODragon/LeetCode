package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
    //bfs queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();


        if(root != null) queue.offer(root);
        else return res;

        while (!queue.isEmpty()) {
            ArrayList<Integer> sub = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                root = queue.poll();
                if(root.left != null) queue.offer(root.left);
                if(root.right != null) queue.offer(root.right);
                sub.add(root.val);
            }
            res.add(sub);
        }

        return res;
    }






















    //bfs
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if(head.left != null) queue.offer(head.left);
                if(head.right != null) queue.offer(head.right);
            }
            res.add(level);
        }
        return res;
    }

    //dfs
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        int maxLevel = 0;
        while (true) {
            List<Integer> level = new ArrayList<>();
            dfs(root, level, 0, maxLevel);
            if(level.size() == 0) break;

            res.add(level);
            maxLevel++;
        }
        return res;
    }

    public void dfs(TreeNode root, List<Integer> level, int curtLevel, int maxLevel) {
        if(root == null || curtLevel > maxLevel) return;

        if(curtLevel == maxLevel) {
            level.add(root.val);
            return;
        }

        dfs(root.left, level, curtLevel + 1, maxLevel);
        dfs(root.right, level, curtLevel + 1, maxLevel);
    }


}
