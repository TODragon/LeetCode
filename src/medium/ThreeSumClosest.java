package medium;

import java.util.Arrays;

public class ThreeSumClosest {
    //先排序，O(n^2)。。没想到更好的
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return -1;
        Arrays.sort(nums);

        int less = Integer.MIN_VALUE + 2;
        int more = Integer.MAX_VALUE - 1;
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                if(nums[i] + nums[left] + nums[right] == target) return target;
                else if(nums[i] + nums[left] + nums[right] < target) {
                    if(nums[i] + nums[left] + nums[right] > less) less = nums[i] + nums[left] + nums[right];
                    left++;
                }
                else if(nums[i] + nums[left] + nums[right] > target) {
                    if(nums[i] + nums[left] + nums[right] < more) more = nums[i] + nums[left] + nums[right];
                    right--;
                }
            }
        }

        return (target - less) > (more - target)? more: less;
    }




    //jiuzhang solution
    public int threeSumClosest1(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3) {
            return -1;
        }

        Arrays.sort(numbers);
        int bestSum = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0; i < numbers.length; i++) {
            int start = i + 1, end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[i] + numbers[start] + numbers[end];
                if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
                    bestSum = sum;
                }
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return bestSum;
    }
}
