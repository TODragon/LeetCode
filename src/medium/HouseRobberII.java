package medium;

public class HouseRobberII {

    //递归
    public static int rob(int[] nums) {
        return rob(nums, 0, nums.length - 1);
    }

    private static int rob(int[] nums, int lo, int hi) {
        if(lo > hi) return 0;

        if(lo == 0) return Math.max(nums[lo] + rob(nums, lo + 2, hi - 1), rob(nums, 1, hi));
        else return Math.max(nums[lo] + rob(nums, lo + 2, hi), rob(nums, lo + 1, hi));
    }

    //使用memo 自底向上 使用自底向上会遇到同时取首位的情况
    //如果求两次， 一次删去nums0 一次删去nums-1
    public static int robMemo(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(robMemo(nums, 1, nums.length - 1), robMemo(nums, 0, nums.length - 2));
    }
    private static int robMemo(int[] nums, int lo, int hi) {
        if(lo > hi) return 0;
        int with = nums[hi];
        int without = 0;

        for(int i = hi; i > lo; i--) {
            int temp = with;
            with = without + nums[i - 1];
            without = Math.max(temp, without);
        }

        return Math.max(with, without);
    }


    ///jiuzhang solution
    public int houseRobber2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robber1(nums, 0, nums.length - 2), robber1(nums, 1, nums.length - 1));
    }
    public int robber1(int[] nums, int st, int ed) {
        int []res = new int[2];
        if(st == ed)
            return nums[ed];
        if(st+1 == ed)
            return Math.max(nums[st], nums[ed]);
        res[st%2] = nums[st];
        res[(st+1)%2] = Math.max(nums[st], nums[st+1]);

        for(int i = st+2; i <= ed; i++) {
            res[i%2] = Math.max(res[(i-1)%2], res[(i-2)%2] + nums[i]);

        }
        return res[ed%2];
    }


    public static void main(String args[]) {
        int[] a = {1,2,3,1};
        System.out.print(robMemo(a));
    }
}
