package easy;

public class MoveZeroes {
    //使用两个指针，
    //如何保持原来的顺序


    //jiuzhang solution
    public static void moveZeroes(int[] nums) {
        if (nums.length < 2) return;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
    public static void main(String args[]) {
        int[] a = {5,1,0,3,12};
        moveZeroes(a);
        for(int n: a) System.out.print(n + " ");
    }
}
