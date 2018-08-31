package medium;

public class RemoveDuplicatesFromSortedArrayII {

    //记录原长度，每次减去重复个数将后方循环前移
    public static int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;
        int len = nums.length;

        int i = 0;
        while (i < len) {
            int temp = nums[i];
            //记录重复次数
            int count = 1;
            while (++i < len && nums[i] == temp) count++;
            if(count > 2) {
                for (int j = i; j < len; j++) nums[j - count + 2] = nums[j];
                len -= count - 2;
                i -= count - 2;

            }
        }

        return len;
    }

    //discuss
    public static int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }

    public static void main(String args[]) {
        int[] a = {1,1,1,2,2,3,3,3};
        System.out.print(removeDuplicates1(a));
    }
}
