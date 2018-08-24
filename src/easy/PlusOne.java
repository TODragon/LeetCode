package easy;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int plus = 1;
		for(int i = digits.length - 1; i >= 0; i--) {
			digits[i] += plus;
			if(digits[i] / 10 != 0) digits[i] = digits[i] % 10;
			else {
				plus = 0;
				break;
			}
		}
		
		if(plus == 1) {
			int[] nums= new int[digits.length + 1];
			nums[0] = 1;
			for(int i = 1; i < nums.length; i++) {
				nums[i] = digits[i - 1];
			}
			return nums;
		}
		return digits;
	}
}
