package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
    //用递归实现栈
    //左中右遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> res) {
        if(root == null) return;
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);

    }

    //solution
    //直接调用栈
    public List < Integer > inorderTraversal1(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
