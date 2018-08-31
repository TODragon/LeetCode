package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    //dfs
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        boolean[] flag = new boolean[nums.length];
        Arrays.sort(nums);

        dfs(nums, res, new ArrayList<>(), flag);
        return res;
    }

    private void dfs(int[] nums, List res, ArrayList<Integer> sub, boolean[] flag) {
        if(sub.size() == nums.length) res.add(new ArrayList<>(sub));
        else {
            for(int i = 0; i < nums.length; i++) {
//                if(flag[i]) continue;
                if(flag[i] || i > 0 && nums[i] == nums[i-1] && !flag[i - 1]) continue;
                flag[i] = true;
                sub.add(nums[i]);
                dfs(nums, res, sub, flag);
                sub.remove(sub.size() - 1);
                flag[i] = false;
            }
        }
    }















    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        permute(nums, 0, solution);
        return solution;
    }

    public void permute(int[] nums, int level, List<List<Integer>> solution) {
        if(level == nums.length) {
            ArrayList<Integer> sub = new ArrayList<>();
            for(int a: nums) sub.add(a);
            solution.add(sub);
            return;
        }

        for(int i = level; i < nums.length; i++) {
            if(nums[level] == nums[i]) continue;
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
