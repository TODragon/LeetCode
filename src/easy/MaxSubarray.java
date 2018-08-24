package easy;

public class MaxSubarray {
	public static int maxSubArray(int[] nums) {
		return max(nums, 0, nums.length - 1);
	}
	
	private static int max(int[] nums, int lo, int hi) {
		
		if(lo >= hi) return nums[lo];
		
		int mid = lo + (hi - lo) / 2;
		int maxLeft = max(nums, lo, mid);
		int maxRight = max(nums, mid + 1, hi);
		
		int maxLeftB = nums[mid];
		int maxRightB = nums[mid + 1];
		int leftB = 0;
		int rightB = 0;
		for(int i = mid; i > 0; i--) {
			leftB += nums[i];
			if(leftB > maxLeftB) maxLeftB = leftB;
		}
		
		for(int i = mid + 1; i < nums.length; i++) {
			rightB += nums[i];
			if(rightB > maxRightB) maxRightB = rightB;
		}
		return Math.max(maxLeftB + maxRightB, Math.max(maxLeft, maxRight));
	}
	
	// Version 1: Greedy

    public int maxSubArray1(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }

	// Version 2: Prefix Sum

    public static int maxSubArray2(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            System.out.println("turn");
        }

        return max;
    }
	
    public int maxSubArray3(int[] nums) {
        // write your code
        if(nums.length == 0){
            return 0; 
        }
        int n = nums.length;
        int[] global = new int[2];
        int[] local = new int[2];
        global[0] = nums[0];
        local[0] = nums[0];
        for(int i = 1; i < n; i ++) {  
            local[i % 2] = Math.max(nums[i], local[(i - 1) % 2] + nums[i]);  
            global[i % 2] = Math.max(local[i % 2], global[(i - 1) % 2]);  
        }  
        return global[(n-1) % 2];  
    }
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int[] a = {2, 1};
		System.out.println(maxSubArray2(nums));
	}
}
