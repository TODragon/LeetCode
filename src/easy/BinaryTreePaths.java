package easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    //dfs
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> s = new ArrayList<>();

        if(root == null) return s;

        String str = "";
        binaryTreePaths(root, str, s);

        s.add(str);
        return s;
    }

    public void binaryTreePaths(TreeNode root, String str, List<String> s) {
        if(root.left == null && root.right == null) {
            str += "->" + root.val;
            s.add(str.substring(2, str.length()));
        }

        if(root.left != null) {
            binaryTreePaths(root.left, str + "->" + root.val, s);

        }
        if(root.right != null) {
            binaryTreePaths(root.right, str + "->" + root.val, s);
        }
    }

    //jiuzhang solution
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }

        // root is a leaf
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }

        return paths;
    }

    //having dreams is what makes life tolerable
    //
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        helper(root, String.valueOf(root.val), result);
        return result;
    }

    private void helper(TreeNode root, String path, List<String> result) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        if (root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), result);
        }

        if (root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }
}
