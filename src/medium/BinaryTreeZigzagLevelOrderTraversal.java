package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
    //类似bfs
    //不过顺序不同，用两个Stack实现
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();

        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        stackA.push(root);

        while (stackA.size() != 0 || stackB.size() != 0) {
            List<Integer> subA = new ArrayList<>();
            while (stackA.size() != 0) {
                root = stackA.pop();
                if(root.left != null) stackB.push(root.left);
                if(root.right != null) stackB.push(root.right);

                subA.add(root.val);
            }
            if(subA.size() != 0) res.add(subA);

            List<Integer> subB = new ArrayList<>();
            while (stackB.size() != 0) {
                root = stackB.pop();
                if(root.right != null) stackA.push(root.right);
                if(root.left != null) stackA.push(root.left);

                subB.add(root.val);
            }
            if(subB.size() != 0) res.add(subB);
        }

        return res;
    }


    //jiuzhang solution
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> tmp;

        currLevel.push(root);
        boolean normalOrder = true;

        while (!currLevel.isEmpty()) {
            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();

            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                currLevelResult.add(node.val);

                if (normalOrder) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }

            result.add(currLevelResult);
            tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;
            normalOrder = !normalOrder;
        }

        return result;

    }


    //discuss
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root)
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) return;

        if(sol.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }




    public static void main(String args[]) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        List<List<Integer>> res = zigzagLevelOrder(null);
        for(List l: res) {
            for(Object i: l) System.out.print(i);
        }
    }
}
