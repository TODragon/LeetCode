package easy;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }


    //approach1: recursive
    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        return (t1 == t2) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    //approach2: iterative
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;

            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    //jiuzhang solution

    public boolean isSymmetric2(TreeNode root) {
        if(root == null){
            return true;
        }else{
            return helper(root.left,root.right);
        }
    }

    public boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }else{
            return helper(left.right,right.left) && helper(left.left, right.right);
        }
    }













    public static void main(String args[]) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

    }
}
