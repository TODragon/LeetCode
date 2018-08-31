package medium;

public class SearchInRotatedSortedArrayII {

    //binary search
    public static boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    //因为有重复无法直接二分 有错误。。。
    private static boolean search(int[] nums, int target, int lo, int hi) {
        if(lo > hi) return false;
        int mid = lo + (hi - lo) / 2;
        if(target == nums[mid]) return true;
        if(nums[mid] < nums[hi]) {
            if(target > nums[nums.length - 1] || target < nums[mid]) return search(nums, target, lo, mid - 1);
            else return search(nums, target, mid + 1, hi);
        }
        else if(nums[mid] > nums[lo]) {
            if(target < nums[nums.length - 1] || target > nums[mid]) return search(nums, target, mid + 1, hi);
            else return search(nums, target, lo, mid - 1);
        }
        else if(nums[mid] == nums[hi]) {
            if(target > nums[mid]) return search(nums, target, mid + 1, hi);
            else return search(nums, target, lo, mid - 1);
        }
        return false;
    }


    //discuss
    public boolean search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            else {
                left++;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int[] a = {1,1,1,2,1,1};
        System.out.print(search(a, 2));
    }
}
