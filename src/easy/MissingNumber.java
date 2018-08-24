package easy;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (0+len)*(len+1)/2;
        for(int i=0; i<len; i++)
            sum-=nums[i];
        return sum;
    }

    public int missingNumber1(int[] nums) { //xor
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String args[]) {
        int[] n = {3,0,1};
        System.out.print(missingNumber(n));
    }
}
