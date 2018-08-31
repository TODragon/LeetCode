package medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {
    //dfs
    //还可以改进，因为多算了一部分，如果sum > target跳出就ok
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);

        dfs(candidates, target, res, new ArrayList<>(), 0, 0);
        return res;
    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> res, ArrayList sub, int sum, int index) {
        if(sum > target) return;
        if(sum == target) {
            res.add(new ArrayList<>(sub));
            return;
        }
        //利用传入形参改变而省略了对sum的操作
        for(int i = index; i < candidates.length; i++) {
//            if(i > index && candidates[i] == candidates[i - 1]) continue;
//            sum += candidates[i];
            sub.add(candidates[i]);
            dfs(candidates, target, res, sub, sum + candidates[i], i + 1);
            sub.remove(sub.size() - 1);
//            sum -= candidates[i];
        }
    }

    public static void main(String args[]) {
        int[] a = {10,1,2,7,6,1,5};
        combinationSum2(a, 8);
        System.out.print("joi");
    }












    //jiuzhang solution
    public List<List<Integer>> combinationSum21(int[] candidates,
                                               int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<Integer>();
        helper(candidates, 0, combination, target, results);

        return results;
    }

    private void helper(int[] candidates,
                        int startIndex,
                        List<Integer> combination,
                        int target,
                        List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target < candidates[i]) {
                break;
            }
            combination.add(candidates[i]);
            helper(candidates, i + 1, combination, target - candidates[i], results);
            combination.remove(combination.size() - 1);
        }
    }
}
