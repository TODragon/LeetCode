package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> solution = new ArrayList<>();
        if(nums == null || nums.length < 4) return solution;

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = nums.length - 1;


                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        List<Integer> sub = new ArrayList<>();
                        sub.add(nums[i]);
                        sub.add(nums[j]);
                        sub.add(nums[left]);
                        sub.add(nums[right]);
                        for(int a: sub) System.out.print(a);
                        System.out.println("");
                        solution.add(sub);

                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                    else if(sum < target) left++;
                    else if(sum > target) right--;
                }
            }
        }
        return solution;
    }

    public static void main(String args[]) {
        int[] a = {1,1,1,1,1,1,1,1,1,1,1,1,1};
        fourSum(a, 4);
    }
}
