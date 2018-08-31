package medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {


    //dfs
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        dfs(nums, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, List res, ArrayList<Integer> sub) {
        if(sub.size() == nums.length) res.add(new ArrayList<>(sub));
        else {
            for(int i = 0; i < nums.length; i++) {
                if(sub.contains(nums[i])) continue;
                sub.add(nums[i]);
                dfs(nums, res, sub);
                sub.remove(sub.size() - 1);
            }
        }
    }




    //可以递归，2,3,4,5，。。。
    //先确定第一位， 再加上剩余部分的排列，太慢了O(n!)
    //backtracking
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();

        permute(nums, 0, solution);

        return solution;
    }
    public void permute(int[] nums, int level, List<List<Integer>> solution) {
        if(level == nums.length) {
            List<Integer> row = new ArrayList<>();
            for(int a: nums) row.add(a);
            solution.add(row);
            return;
        }

        for(int i = level; i < nums.length; i++) {
            exch(nums, level, i);
            permute(nums, level + 1, solution);
            exch(nums, level, i);
        }
    }

    public void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}
