package medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {

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
