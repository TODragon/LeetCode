package easy;

public class Two_Sum {
//	solution
	public static int[] twoSum(int[] nums, int target) {
		int[] solution = new int[2];
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if((nums[i] + nums[j]) == target) {
					solution[0] = i;
					solution[1] = j;
					break;
				}
			}
		}
		
		return solution;
	}
//	test
	public static void main(String[] args) {
		int[] test = new int[] {3,3};
		int tar = 6;
		
		System.out.println(twoSum(test, tar)[0]);
		System.out.println(twoSum(test, tar)[1]);
	}
}
