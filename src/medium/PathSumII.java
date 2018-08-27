package medium;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //dfs
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//
//    }
//
//    private void dfs(TreeNode root, int num, List<Integer> sub, List<List<Integer>> res) {
//        if (root.left == null && root.right == null && root.val == num) {
//            sub.add(root.val);
//
//        }
//
//        dfs()
//    }


    //jiuzhang solution
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();

        findSum(rst, solution, root, sum);
        return rst;
    }

    private void findSum(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution, TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;

        if (root.left == null && root.right == null) {
            if (sum == 0) {
                solution.add(root.val);
                result.add(new ArrayList<>(solution));
                solution.remove(solution.size() - 1);
            }
            return;
        }

        solution.add(root.val);
        findSum(result, solution, root.left, sum);
        findSum(result, solution, root.right, sum);
        solution.remove(solution.size() - 1);

    }
}
