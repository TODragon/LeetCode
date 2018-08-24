package easy;

public class SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
		if(nums.length == 0 || nums[0] >= target) return 0;
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] < target && nums[i + 1] >= target) return ++i;
		}
		return nums.length;
	}
	public static void main(String[] args) {
		int[] a = {1, 3, 5, 6};
		int[] b = {};
		System.out.println(searchInsert(a, 0));
		System.out.println(searchInsert(a, 5));
		System.out.println(searchInsert(a, 7));
		System.out.println(searchInsert(b, 1));
	}
}
