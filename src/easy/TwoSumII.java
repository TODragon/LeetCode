package easy;

public class TwoSumII {

    //直接O(n^2)求和判断
    //可以O(n)吗
    //如果用两个pointer一前一后ok
    public int[] twoSum(int[] numbers, int target) {
        int[] solution = new int[2];

        int i = 0;
        int j = numbers.length - 1;
        int sum = numbers[i] + numbers[j];
        while (sum != target) {
            i = sum > target? i: i + 1;
            j = sum > target? j - 1: j;
            if(i == j) return solution;
            sum = numbers[i] + numbers[j];
        }

        solution[0] = i + 1;
        solution[1] = j + 1;

        return solution;
    }

    //jiuzhang solution
    public int[] twoSum1(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        for (int l = 0, r = nums.length - 1; l < r; r--) {
            while (l < r && nums[l] + nums[r] < target) {
                l++;
            }
            if (l != r && nums[l] + nums[r] == target) {
                return new int[]{l + 1, r + 1};
            }

        }
        return new int[0];
    }
}
