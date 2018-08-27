package medium;

import java.util.ArrayList;
import java.util.Stack;

public class LowestCommonAncestorOfABinaryTree {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    //使用dfs搜索到pq，并记录过程返回，比较路径即可

    //jiuzhang solution
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (root == p || root == q) {
            boolean rootright = true;
            return root;
        }
        if (left != null && right != null) {
            boolean notempty = true;
            return root;
        }

        return right == null ? left : right;
    }


    //discuss
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }


    public static void main(String args[]) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(0);
        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(7);
        TreeNode i = new TreeNode(4);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = h;
        e.right = i;
        c.left = f;
        c.right = g;

        System.out.print(lowestCommonAncestor(a, b, c).val);

    }
}
