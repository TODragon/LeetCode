package easy;

public class RotateArray {
    //1.每次循环一个，k次 O(1) space
    //2.直接新建一个int[]

    //超时
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        if(k == 0) return;
        for(int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for(int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if(k == 0) return;

        int[] temp = new int[k];
        for(int i = nums.length - k, j = 0; i < nums.length; i++, j++) {
            temp[j] = nums[i];
        }

        for(int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        for(int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    //jiuzhang solution
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }
    }
    public void rotate2(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
}
