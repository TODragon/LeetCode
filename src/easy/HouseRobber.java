package easy;

public class HouseRobber {
    //超时啦
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return rob(nums, 0, nums.length - 1);
    }

    private static int rob(int[] nums, int lo, int hi) {
        if(hi == lo) return nums[hi];
        if(hi - lo == 1) return Math.max(nums[lo], nums[hi]);
        if(hi < lo) return 0;

//        return Math.max(nums[lo] + rob(nums, lo + 2, nums.length - 1),
//                nums[lo + 1] + rob(nums, lo + 3, nums.length - 1));

        return Math.max(nums[lo] + rob(nums, lo + 2, nums.length - 1),
                rob(nums, lo + 1, nums.length - 1));
    }

    //使用memo,仅与相邻的两个相关，无需memo，只要两个即可 见solution
    public static int robMemo(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for(int i = 2; i < memo.length; i++) {
            memo[i] = Math.max(nums[i - 1] + memo[i - 2], memo[i - 1]);
        }
        return memo[nums.length];
    }

    //solution
    public int rob1(int[] nums) {
        int with = 0, without = 0;
        for(int i=0;i<nums.length;i++){
            int temp = with;
            with = Math.max(with, without + nums[i]);
            without = Math.max(without,temp);
        }
        return Math.max(with,without);
    }

    //jiuzhang solution
    public long houseRobber(int[] A) {
        // write your code here
        int n = A.length;
        if(n == 0)
            return 0;
        long []res = new long[2];


        res[0] = 0;
        res[1] = A[0];
        for(int i = 2; i <= n; i++) {
            res[i%2] = Math.max(res[(i-1)%2], res[(i-2)%2] + A[i-1]);
        }
        return res[n%2];
    }



    public static void main(String args[]) {
        int[] a = {1};
        int[] b = {2,7,9,3,1};

        System.out.print(robMemo(a) + "---" + robMemo(b));
    }
}
