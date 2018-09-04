package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0) return res;
        for(int i = 1; i <= nums.length; i++) {
            dfs(nums, i, 0, 0, res, new ArrayList<>());
        }

        return res;
    }

    private void dfs(int[] nums, int size, int level, int lo, List res, ArrayList sub) {
        if(level == size) res.add(new ArrayList(sub));
        else {
            for(int i = lo; i < nums.length; i++) {
                // if(sub.contains(nums[i])) continue;
                sub.add(nums[i]);
                dfs(nums, size, level + 1, i + 1, res, sub);
                sub.remove(sub.size() - 1);
            }
        }
    }
}
