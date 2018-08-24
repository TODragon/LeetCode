package medium;

import java.util.Arrays;

public class NextPermutation {
    //有错，交换后仍需要将后面的排序
    public static void nextPermutation1(int[] nums) {
        //1237684985 12354 找到前一个比后一个数值小，且前一个最靠后的情况 constant memory
        //从最后一个开始向前，如果大，cur前移，继续，直至找到小于i或边界（反向输出），此时后移，直至小于i的j或边界，交换i，j
        int temp;
        int i = nums.length - 1;
        while (i >= 0 && nums[i] >= nums[nums.length - 1]) i--;
        if(i == -1) {
            //resverse
//            reverse(nums, 0, nums.length - 1);
            Arrays.sort(nums);
            return;
        }
        int j = i;
        while (j <= nums.length - 1 && nums[j] > nums[i]) j++;
        temp = nums[j - 1];
        nums[j - 1] = nums[i];
        nums[i] = temp;
        int[] a = new int[j - i - 1];
        for(int k = i, n = 0; k < nums.length; k++, n++) {
            a[n] = nums[k];
        }
        Arrays.sort(a);
        for(int k = i, n = 0; k < nums.length; k++, n++) {
            nums[k] = a[n];
        }
//        reverse(nums, i + 1, j - 2);
    }

    public static void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return;
        int i =  nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }

        if(i == 0) {
            Arrays.sort(nums);
            return;
        }

        int j = i;
        while (j < nums.length && nums[j] > nums[i - 1]) {
            j++;
        }

        int temp = nums[i - 1];
        nums[i - 1] = nums[j - 1];
        nums[j - 1] = temp;

        int[] a = new int[nums.length - i];
        for(int k = i, n = 0; k < nums.length; k++, n++) {
            a[n] = nums[k];
        }
        Arrays.sort(a);

        for(int k = i, n = 0; k < nums.length; k++, n++) {
            nums[k] = a[n];
        }
    }

    //jiuzhang solution 1
    public void swapItem(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void swapList(int[] nums, int i, int j) {
        while (i < j) {
            swapItem(nums, i, j);
            i ++; j --;
        }
    }
    public int[] nextPermutation2(int[] nums) {
        int len = nums.length;
        if ( len <= 1)
            return nums;
        int i = len - 1;
        while (i > 0 && nums[i] <= nums[i - 1])
            i --;
        swapList(nums, i, len - 1);
        if (i != 0) {
            int j = i;
            while (nums[j] <= nums[i - 1]) j++;
            swapItem(nums, j, i-1);
        }
        return nums;
    }

    //jiuzhang solution 2
    public void reverse(int[] num, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
    }

    public int[] nextPermutation3(int[] num) {
        // find the last increase index
        int index = -1;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(num, 0, num.length - 1);
            return num;
        }

        // find the first bigger one
        int biggerIndex = index + 1;
        for (int i = num.length - 1; i > index; i--) {
            if (num[i] > num[index]) {
                biggerIndex = i;
                break;
            }
        }

        // swap them to make the permutation bigger
        int temp = num[index];
        num[index] = num[biggerIndex];
        num[biggerIndex] = temp;

        // reverse the last part
        reverse(num, index + 1, num.length - 1);
        return num;
    }



    public static void main(String args[]) {
        int[] nums = {1,2,5,4,9,8,6,3};
        int[] b = {1,5,1};
        int[] a = {1, 1, 1};
        nextPermutation(a);
        for(int i: a) System.out.print(i);
    }
}
